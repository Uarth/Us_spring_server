package ybigta.us;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${model.server.url}")
    private String modelServerUrl;
    @Value("${MATCHING_SERVER_URL}")
    private String matchingServerUrl;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl(modelServerUrl)
                .build();
    }

    @Bean
    public WebClient matchingWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(matchingServerUrl)
                .build();
    }
}
