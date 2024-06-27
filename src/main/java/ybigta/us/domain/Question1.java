package ybigta.us.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ybigta.us.converter.ListFloatToStringConverter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "question1")
public class Question1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Convert(converter = ListFloatToStringConverter.class)
    @Column(name = "audio_feature", columnDefinition = "json")
    private List<Float> audioFeature;

    @Convert(converter = ListFloatToStringConverter.class)
    @Column(name = "pos", columnDefinition = "json")
    private List<Float> pos;

    @Column(name = "trans_text", length = 500)
    private String transText;

    @Convert(converter = ListFloatToStringConverter.class)
    @Column(name = "emb_text", columnDefinition = "json")
    private List<Float> embText;

    public Question1 get() {
        return this;
    }
}
