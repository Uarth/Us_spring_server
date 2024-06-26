package ybigta.us.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ybigta.us.domain.FeatureSelect;
import ybigta.us.repository.FeatureSelectRepository;

import java.util.Map;

@Service
public class FeatureSelectService {

    private final FeatureSelectRepository featureSelectRepository;

    @Autowired
    public FeatureSelectService(FeatureSelectRepository featureSelectRepository) {
        this.featureSelectRepository = featureSelectRepository;
    }


    public void saveFeatureSelection(int userId, Map<String, Object> featureData) {
        FeatureSelect featureSelect = new FeatureSelect();
        featureSelect.setUserId(userId);
        featureSelect.setFeatureValue1((String) featureData.get("feature_value_1"));
        featureSelect.setFeatureValue2((String) featureData.get("feature_value_2"));
        featureSelect.setFeatureValue3((String) featureData.get("feature_value_3"));
        featureSelect.setFeatureValue4((String) featureData.get("feature_value_4"));
        featureSelect.setFeatureValue5((String) featureData.get("feature_value_5"));
        featureSelectRepository.save(featureSelect);

    }
}