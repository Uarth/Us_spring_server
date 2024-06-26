package ybigta.us.service;

import org.springframework.stereotype.Service;
import ybigta.us.domain.User;
import ybigta.us.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User join(User user) {
        userRepository.save(user);
        return user;
    }

    public User createUser(String name, Boolean sex, String phoneNumber, String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            // 이메일 일치 여부 기준으로 사용자 정보를 업데이트합니다.
            User user = optionalUser.get();
            user.setName(name);
            user.setSex(sex);
            user.setPhoneNumber(phoneNumber);
            return userRepository.save(user);
        } else {
            // 기존 사용자가 없으면 아무 작업도 하지 않습니다.
            return null;
        }
    }
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public User findUserByName(String name) {
        return userRepository.findByName(name).get();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}

