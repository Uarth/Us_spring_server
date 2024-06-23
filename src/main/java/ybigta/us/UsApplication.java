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
		SpringApplication.run(UsApplication.class, args);


	}
}
