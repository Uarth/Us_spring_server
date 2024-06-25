package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question2;
import ybigta.us.dto.FeatureResponse;

public interface Question2Repository extends JpaRepository<Question2, Integer> {
    Question2 save(Question2 question2);
}
