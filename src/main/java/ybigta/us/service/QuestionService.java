package ybigta.us.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ybigta.us.domain.Question1;
import ybigta.us.domain.Question2;
import ybigta.us.domain.Question3;
import ybigta.us.dto.FeatureResponse;
import ybigta.us.repository.Question1Repository;
import ybigta.us.repository.Question2Repository;
import ybigta.us.repository.Question3Repository;

@Service
public class QuestionService {
    @Autowired
    private Question1Repository question1Repository;
    @Autowired
    private Question2Repository question2Repository;
    @Autowired
    private Question3Repository question3Repository;


    public Question1 saveFeatureResponseToQuestion1(Question1 question1) {
        System.out.println(question1.getAudioFeature().toString());
        System.out.println(question1.getPos().toString());
        System.out.println(question1.getTransText());;
        question1Repository.save(question1);
        return question1;
    }

    public Question2 saveFeatureResponseToQuestion2(Question2 question2) {
        System.out.println(question2.toString());
        question2Repository.save(question2);
        return question2;
    }

    public Question3 saveFeatureResponseToQuestion3(Question3 question3) {
        System.out.println(question3.toString());
        question3Repository.save(question3);
        return question3;
    }

    public boolean isExistQuestion1(Integer userId) {
        return question1Repository.existsByUserId(userId);
    }

    public void updateQuestion1(Integer userId, Question1 question1Entity) {
        Question1 question1 = question1Repository.findByUserId(userId).get();
        question1.setAudioFeature(question1Entity.getAudioFeature());
        question1.setPos(question1Entity.getPos());
        question1.setTransText(question1Entity.getTransText());
        question1Repository.save(question1);
    }

    public boolean isExistQuestion2(Integer userId) {
        return question2Repository.existsByUserId(userId);
    }

    public void updateQuestion2(Integer userId, Question2 question2Entity) {
        Question2 question2 = question2Repository.findByUserId(userId).get();
        question2.setAudioFeature(question2Entity.getAudioFeature());
        question2.setPos(question2Entity.getPos());
        question2.setTransText(question2Entity.getTransText());
        question2Repository.save(question2);
    }


    public boolean isExistQuestion3(Integer userId) {
        return question3Repository.existsByUserId(userId);
    }

    public void updateQuestion3(Integer userId, Question3 question3Entity) {
        Question3 question3 = question3Repository.findByUserId(userId).get();
        question3.setAudioFeature(question3Entity.getAudioFeature());
        question3.setPos(question3Entity.getPos());
        question3.setTransText(question3Entity.getTransText());
        question3Repository.save(question3);
    }
}
