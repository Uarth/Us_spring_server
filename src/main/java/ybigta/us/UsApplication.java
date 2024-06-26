package ybigta.us;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class UsApplication {

	public static void main(String[] args) {
		// OAuth2.0 비공개정보
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("CLIENT_ID", dotenv.get("CLIENT_ID"));
		System.setProperty("CLIENT_SECRET", dotenv.get("CLIENT_SECRET"));
		System.setProperty("SMS_API_KEY", dotenv.get("SMS_API_KEY"));
		System.setProperty("SMS_API_SECRET", dotenv.get("SMS_API_SECRET"));
		System.setProperty("SMS_API_PROVIDER", dotenv.get("SMS_API_PROVIDER"));
		System.setProperty("SMS_API_SENDER", dotenv.get("SMS_API_SENDER"));
		System.setProperty("MODEL_SERVER_URL", dotenv.get("MODEL_SERVER_URL"));
		System.setProperty("MATCHING_SERVER_URL", dotenv.get("MATCHING_SERVER_URL"));



		SpringApplication.run(UsApplication.class, args);


	}
}
