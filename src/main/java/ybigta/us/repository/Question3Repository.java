package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question3;
import ybigta.us.dto.FeatureResponse;

public interface Question3Repository extends JpaRepository<Question3, Integer> {
    Question3 save(Question3 question3);
}
