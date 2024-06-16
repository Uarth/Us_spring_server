package ybigta.us.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ybigta.us.domain.User;

@Controller
@RequestMapping("/session")
public class SessionController {
//Session 정보 확인용 페이지
    @GetMapping("/get")
    public String getSession(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        String accessToken = (String) session.getAttribute("accessToken");
        model.addAttribute("user", user);
        model.addAttribute("accessToken", accessToken);
        return "sessionData";
    }

}
