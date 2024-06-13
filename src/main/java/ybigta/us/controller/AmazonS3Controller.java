package ybigta.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import ybigta.us.dto.RecordDto;
import ybigta.us.service.AmazonS3Service;

import java.io.IOException;

@RestController
public class AmazonS3Controller {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @ResponseBody
    @PostMapping("/upload")
    public RecordDto upload(@RequestParam MultipartFile file, Integer quesNumber) throws IOException {
        //todo: original file name 쓰지 말고 user 이름 쓰기 (user id나)
        //      session에서 user 정보 가져오기
        String fileName = file.getOriginalFilename();
        String filePath = "Question" + quesNumber.toString() + "/" + fileName;
        String s3url = amazonS3Service.uploadFileToS3(filePath, file);
        return new RecordDto(filePath, s3url);
    }

}
