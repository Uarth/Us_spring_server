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

    @Autowired
    private OAuth2Service oAuth2Service;

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response) {
        return oAuth2Service.handleTokenRequest(code, request, response);
    }
}
