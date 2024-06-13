package ybigta.us.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class AmazonS3Service{
    @Autowired
    private S3Client s3;

    @Value("${cloud.aws.bucket}")
    private String bucketName;

    //todo: bucket name과 region을 application.properties에 저장하기
    public String uploadFileToS3(String s3Path, MultipartFile file) throws IOException {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(s3Path)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .build();

        File tempFile = File.createTempFile("temp", null, null);
        file.transferTo(tempFile);

        s3.putObject(putObjectRequest,RequestBody.fromFile(tempFile));

        return "https://us-record-test-bucket.s3.ap-northeast-2.amazonaws.com/" + s3Path;
    }
}
