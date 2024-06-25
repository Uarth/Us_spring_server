package ybigta.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ybigta.us.dto.FeatureResponse;
import ybigta.us.dto.RecordDto;
import ybigta.us.service.AmazonS3Service;
import org.springframework.web.reactive.function.client.WebClient;
import ybigta.us.service.QuestionService;

import java.io.IOException;

@RestController
public class AmazonS3Controller {

    @Autowired
    private AmazonS3Service amazonS3Service;
    @Autowired
    private WebClient webClient;
    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @PostMapping("/upload")
    public RecordDto upload(@RequestParam MultipartFile file, Integer quesNumber) throws IOException {
        //todo: original file name 쓰지 말고 user 이름 쓰기 (user id나)
        //      session에서 user 정보 가져오기
        String fileName = file.getOriginalFilename();
        String filePath = "Question" + quesNumber.toString() + "/" + fileName;
        String s3url = amazonS3Service.uploadFileToS3(filePath, file);
        RecordDto recordDto = new RecordDto(filePath, s3url, quesNumber);

        sendGetRequestToFeatureServer(recordDto);

        return recordDto;
    }

    // s3가 들어오면 해댱 question, user에 맞게 feature를 저장함
    @Async
    public void sendGetRequestToFeatureServer(RecordDto recordDto) {

        webClient.get()
            .uri(uriBuilder -> uriBuilder
                        .path("FAST/test_s3")
                        .queryParam("file_url", recordDto.getRecordS3Url())
                        .build())
                .retrieve()
                .bodyToMono(FeatureResponse.class)
                .doOnNext(response -> {
                    if(response == null) {
                        System.out.println("Response body is null");
                    } else {
                        System.out.println("Response body is not null");
                        System.out.println(response.getFeatures().toString());
                    }
                })
                .subscribe(featureResponse -> {
                    switch (recordDto.getQuestionNumber()) {
                        case 1:
                            questionService.saveFeatureResponseToQuestion1(featureResponse.toQuestion1Entity());
                            break;
                        case 2:
                            questionService.saveFeatureResponseToQuestion2(featureResponse.toQuestion2Entity());
                            break;
                        case 3:
                            questionService.saveFeatureResponseToQuestion3(featureResponse.toQuestion3Entity());
                            break;
                    }
                });
    }

}
