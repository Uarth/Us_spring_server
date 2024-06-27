package ybigta.us.dto;

import lombok.Getter;
import lombok.Setter;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question2;
import ybigta.us.domain.Question3;

import java.util.List;

@Getter
@Setter
public class FeatureResponse {
    private int status;
    private String message;
    private Features features;

    @Getter
    @Setter
    public static class Features {
        private List<Float> audio_feature;
        private String transcribed_text;
        private List<Float> pos_feature;
        private List<Float> text_embedding;
    }

    public Question1 toQuestion1Entity(Integer userId) {
        Question1 question1 = new Question1();
        question1.setAudioFeature(this.features.getAudio_feature());
        question1.setPos(this.features.getPos_feature());
        question1.setTransText(this.features.getTranscribed_text());
        question1.setEmbText(this.features.getText_embedding());
        question1.setUserId(userId);
        return question1;
    }

    public Question2 toQuestion2Entity(Integer userId) {
        Question2 question2 = new Question2();
        question2.setAudioFeature(this.features.getAudio_feature());
        question2.setPos(this.features.getPos_feature());
        question2.setTransText(this.features.getTranscribed_text());
        question2.setEmbText(this.features.getText_embedding());
        question2.setUserId(userId);
        return question2;
    }

    public Question3 toQuestion3Entity(Integer userId) {
        Question3 question3 = new Question3();
        question3.setAudioFeature(this.features.getAudio_feature());
        question3.setPos(this.features.getPos_feature());
        question3.setTransText(this.features.getTranscribed_text());
        question3.setEmbText(this.features.getText_embedding());
        question3.setUserId(userId);
        return question3;
    }
}
