package ybigta.us.repository;

import ybigta.us.domain.User;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Integer id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
