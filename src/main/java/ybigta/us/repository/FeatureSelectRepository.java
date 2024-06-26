package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.FeatureSelect;

public interface FeatureSelectRepository extends JpaRepository<FeatureSelect, Integer> {
    FeatureSelect save(FeatureSelect featureSelect);

}
