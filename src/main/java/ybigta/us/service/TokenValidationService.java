package ybigta.us.service;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ybigta.us.domain.User;
import ybigta.us.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TokenValidationService {

    private static final String GOOGLE_TOKEN_INFO_URL = "https://www.googleapis.com/oauth2/v1/tokeninfo";

    private final UserRepository userRepository;

    public TokenValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> validateToken(String accessToken, String email, HttpServletResponse response, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        // Google의 토큰 정보 엔드포인트 호출
        String url = UriComponentsBuilder.fromHttpUrl(GOOGLE_TOKEN_INFO_URL)
                .queryParam("access_token", accessToken)
                .toUriString();

        try {
            Map<String, Object> tokenInfo = restTemplate.getForObject(url, Map.class);

            // 토큰의 유효성을 검사하고 이메일이 일치하는지 확인
            if (tokenInfo != null && email.equals(tokenInfo.get("email"))) {

                // 사용자 정보 조회 또는 생성
                User user = findOrCreateUser(email);

                // 세션에 사용자 정보 저장
                session.setAttribute("user", user);

                // 세션 ID를 쿠키에 설정
                Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
                sessionCookie.setHttpOnly(true);
                sessionCookie.setPath("/");
                sessionCookie.setMaxAge(60 * 60); // 1시간 유효
                response.addCookie(sessionCookie);

                // 쿠키 정보를 맵으로 반환
                Map<String, String> cookieMap = new HashMap<>();
                cookieMap.put(sessionCookie.getName(), sessionCookie.getValue());

                return cookieMap;
            }
        } catch (Exception e) {
            // 예외 발생 시 토큰이 유효하지 않음
            e.printStackTrace();
        }

        return null;
    }
    private User findOrCreateUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setRole("ROLE_USER");
            return userRepository.save(newUser);
        }
    }



    }
