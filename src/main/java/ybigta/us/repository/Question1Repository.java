package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question2;
import ybigta.us.dto.FeatureResponse;

public interface Question1Repository extends JpaRepository<Question1, Integer> {
    Question1 save(Question1 question1);
    Question1 updateQuestion(Integer userId, Question1 updateQuestion );

}
