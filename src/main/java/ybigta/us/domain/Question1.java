package ybigta.us.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "question1")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "audio_feature", columnDefinition = "json")
    private String audioFeature;

    @Column(name = "pos", columnDefinition = "json")
    private String pos;

    @Column(name = "trans_text")
    private String transText;

    @Column(name = "emb_text", columnDefinition = "json")
    private String embText;
}
