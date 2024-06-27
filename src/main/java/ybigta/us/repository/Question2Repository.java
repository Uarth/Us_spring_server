package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question2;
import ybigta.us.dto.FeatureResponse;

import java.util.Optional;

public interface Question2Repository extends JpaRepository<Question2, Integer> {
    Question2 save(Question2 question2);
    boolean existsByUserId(Integer userId);
    Question2 findByUserId(Integer userId);
}
