package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question;
import ybigta.us.dto.FeatureDao;
import ybigta.us.dto.FeatureResponse;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    FeatureDao save(FeatureResponse featureResponse);
}
