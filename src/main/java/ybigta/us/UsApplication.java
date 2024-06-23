package ybigta.us;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


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





		SpringApplication.run(UsApplication.class, args);


	}
}
