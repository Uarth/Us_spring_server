package ybigta.us.dto;

import lombok.Getter;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question2;
import ybigta.us.domain.Question3;

import java.util.List;

@Getter
@Setter
public class FeatureResponse {
    private List<Float> audio_feature;
    private List<Float> pos;
    private String trans_text;
    private List<Float> emb_text;

    public Question1 toQuestion1Entity() {
        Question1 question1 = new Question1();
        question1.setAudioFeature(this.audio_feature);
        question1.setPos(this.pos);
        question1.setTransText(this.trans_text);
        question1.setEmbText(this.emb_text);
        return question1;
    }

    public Question2 toQuestion2Entity() {
        Question2 question2 = new Question2();
        question2.setAudioFeature(this.audio_feature);
        question2.setPos(this.pos);
        question2.setTransText(this.trans_text);
        question2.setEmbText(this.emb_text);
        return question2;
    }

    public Question3 toQuestion3Entity() {
        Question3 question3 = new Question3();
        question3.setAudioFeature(this.audio_feature);
        question3.setPos(this.pos);
        question3.setTransText(this.trans_text);
        question3.setEmbText(this.emb_text);
        return question3;
    }
}
