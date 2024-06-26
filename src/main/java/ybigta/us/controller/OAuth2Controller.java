package ybigta.us.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ybigta.us.service.OAuth2Service;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Controller {
/* 개발과정에서 쓰게될수도, 아닐수도 있는데..우선 같이 커밋하고 안쓰게되면 지울게요
    @Autowired
    private OAuth2Service oAuth2Service;

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response) {
        return oAuth2Service.handleTokenRequest(code, request, response);
    }

 */
}
