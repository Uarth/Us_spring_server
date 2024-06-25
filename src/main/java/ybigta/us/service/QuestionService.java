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

}
