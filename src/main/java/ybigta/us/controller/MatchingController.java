package ybigta.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.reactive.function.client.WebClient;
import ybigta.us.domain.User;
import ybigta.us.dto.MatchingDto;
import ybigta.us.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MatchingController {
    @Autowired
    @Qualifier("matchingWebClient")
    private WebClient matchingWebClient;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/match")
    public ResponseEntity<Map<String, Object>> match(/*HttpSession session*/) {

//        User user = (User) session.getAttribute("user");
//        Integer userId = user.getId();
        Integer userId = 6;
        MatchingDto matchingDto = matchingWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("FAST/matching")
                        .queryParam("userid", userId)
                        .build())
                .retrieve().bodyToMono(MatchingDto.class).block();

        if (matchingDto != null) {
            Map<String, Object> responseBody = new HashMap<>();
            String username = userService.findUser((int) matchingDto.getUserid()).getName();
            responseBody.put("reason", matchingDto.getExplain());
            responseBody.put("user_name", username);
            return ResponseEntity.ok(responseBody);
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Model Server Problem");
            return ResponseEntity.status(401).body(responseBody);
        }
    }
}
