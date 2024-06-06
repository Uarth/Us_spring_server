package ybigta.us;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
class S3Config {
    @Bean
    public S3Client s3() {
        return S3Client.builder().region(Region.AP_NORTHEAST_2).build();
    }
}
