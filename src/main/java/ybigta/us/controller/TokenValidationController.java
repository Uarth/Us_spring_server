package ybigta.us.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ybigta.us.service.TokenValidationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TokenValidationController {

    private final TokenValidationService tokenValidationService;

    @Autowired
    public TokenValidationController(TokenValidationService tokenValidationService) {
        this.tokenValidationService = tokenValidationService;
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Map<String, Object>> validateToken(@RequestBody Map<String, String> request,
                                                             HttpServletResponse response,
                                                HttpSession session) {
        String email = request.get("email");
        String accessToken = request.get("access_token");

        Map<String, String> cookieMap = tokenValidationService.validateToken(accessToken, email,response, session);

        if (cookieMap != null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Token is valid");
            responseBody.put("email", email);
            responseBody.put("status", "success");
            responseBody.put("cookies", cookieMap);

            return ResponseEntity.ok(responseBody);
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Invalid token");
            responseBody.put("status", "error");
            return ResponseEntity.status(401).body(responseBody);
        }
    }


}
