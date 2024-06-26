package ybigta.us.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ybigta.us.domain.User;
import ybigta.us.dto.UserDashboardResponse;
import ybigta.us.service.DashboardService;

@RestController
@RequestMapping("/api")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<UserDashboardResponse>  getUserDashboard(HttpSession session) {
        //인증된 사용자의 dashboard
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
        UserDashboardResponse response = dashboardService.getUserDashboard(user.getId());
        return ResponseEntity.ok(response);
    }

}
