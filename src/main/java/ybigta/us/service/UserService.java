package ybigta.us.service;

import ybigta.us.domain.User;
import ybigta.us.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User join(User user) {
        userRepository.save(user);
        return user;
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

