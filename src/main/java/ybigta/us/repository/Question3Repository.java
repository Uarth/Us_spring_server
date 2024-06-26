package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question3;
import ybigta.us.dto.FeatureResponse;

import java.util.Optional;

public interface Question3Repository extends JpaRepository<Question3, Integer> {
    Question3 save(Question3 question3);
    boolean existsByUserId(Integer userId);
    Question3 findByUserId(Integer userId);
}
