package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.Question1;

import java.util.Optional;

public interface Question1Repository extends JpaRepository<Question1, Integer> {
    Question1 save(Question1 question1);
    boolean existsByUserId(Integer userId);
    Question1 findByUserId(Integer userId);
}
