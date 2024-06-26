package ybigta.us.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ybigta.us.domain.User;
import ybigta.us.dto.SignupDto;
import ybigta.us.service.UserService;

@RestController
@RequestMapping("/api")
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDto signupdto, HttpSession session) {
        // 세션에서 현재 사용자 정보를 가져옴
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        // 사용자 프로필 업데이트
        userService.updateUserProfile(user.getId(), signupdto);

        return ResponseEntity.ok("User registration successful");
    }
}