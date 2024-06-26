package ybigta.us.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ybigta.us.domain.User;
import ybigta.us.service.FeatureSelectService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FeatureSelectController {

    private final FeatureSelectService featureSelectService;

    @Autowired
    public FeatureSelectController(FeatureSelectService featureSelectService) {
        this.featureSelectService = featureSelectService;
    }

    @PostMapping("/saveFeatureSelection")
    public ResponseEntity<Map<String, Object>> saveFeatureSelection(@RequestBody Map<String, Object> featureData, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            featureSelectService.saveFeatureSelection(user.getId(), featureData);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Feature selection saved successfully");
            return ResponseEntity.ok(responseBody);
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "User not found in session");
            return ResponseEntity.status(401).body(responseBody);
        }
    }


}
