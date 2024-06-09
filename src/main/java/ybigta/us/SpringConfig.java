package ybigta.us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ybigta.us.repository.UserRepository;
import ybigta.us.service.UserService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }
}
