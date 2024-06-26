package ybigta.us.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ybigta.us.domain.FeatureSelect;
import ybigta.us.domain.User;
import ybigta.us.dto.UserDashboardResponse;
import ybigta.us.repository.FeatureSelectRepository;
import ybigta.us.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final FeatureSelectRepository featureSelectRepository;

    @Autowired
    public DashboardService(UserRepository userRepository, FeatureSelectRepository featureSelectRepository) {
        this.userRepository = userRepository;
        this.featureSelectRepository = featureSelectRepository;
    }

    public UserDashboardResponse getUserDashboard(int userId) {
        // 사용자 정보 조회
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOptional.get();

        // 사용자의 feature select 정보 조회
        List<FeatureSelect> featureSelectList = featureSelectRepository.findByUserId(userId);
        if (featureSelectList.isEmpty()) {
            throw new IllegalArgumentException("FeatureSelect not found");

        }

        // UserDashboardResponse 객체 생성
        UserDashboardResponse response = new UserDashboardResponse();
        response.setName(user.getName());
        response.setSex(user.getSex());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());

        FeatureSelect featureSelect = featureSelectList.get(0);
        response.setFeatureValue1(featureSelect.getFeatureValue1());
        response.setFeatureValue2(featureSelect.getFeatureValue2());
        response.setFeatureValue3(featureSelect.getFeatureValue3());
        response.setFeatureValue4(featureSelect.getFeatureValue4());
        response.setFeatureValue5(featureSelect.getFeatureValue5());
        return response;
    }


}
