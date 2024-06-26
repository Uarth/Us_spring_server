package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.FeatureSelect;

import java.util.List;
import java.util.Optional;

public interface FeatureSelectRepository extends JpaRepository<FeatureSelect, Integer> {
    List<FeatureSelect> findByUserId(Integer userId);
}
