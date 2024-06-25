package ybigta.us.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ybigta.us.domain.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    //UserDashboard
    
    @Autowired
    public UserInfoController() {
    }

    @GetMapping("/userInfo")
    public ResponseEntity<Map<String, Object>> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "User info retrieved successfully");
            responseBody.put("user", user);
            return ResponseEntity.ok(responseBody);
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "User not found in session");
            return ResponseEntity.status(401).body(responseBody);
        }
    }




}
