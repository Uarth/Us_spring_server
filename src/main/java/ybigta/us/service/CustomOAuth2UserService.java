package ybigta.us.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ybigta.us.domain.User;
import ybigta.us.dto.Role;
import java.util.Collections;
import java.util.Map;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import ybigta.us.repository.UserRepository;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public CustomOAuth2UserService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email;
        if ("google".equals(registrationId)) {
            email = (String) attributes.get("email");
        } else {

            throw new OAuth2AuthenticationException("허용되지 않은 인증");
        }

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setRole("ROLE_USER");
                    return userRepository.save(newUser);
                });

        httpSession.setAttribute("user", user);

        // 액세스 토큰을 세션에 저장합니다.
        String accessToken = userRequest.getAccessToken().getTokenValue();
        httpSession.setAttribute("accessToken", accessToken);
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())),
                oAuth2User.getAttributes(),
                userNameAttributeName
        );
    }
}
