package ybigta.us.domain;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "featureselect")
public class FeatureSelect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "feature_value_1")
    private String featureValue1;

    @Column(name = "feature_value_2")
    private String featureValue2;

    @Column(name = "feature_value_3")
    private String featureValue3;

    @Column(name = "feature_value_4")
    private String featureValue4;

    @Column(name = "feature_value_5")
    private String featureValue5;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
