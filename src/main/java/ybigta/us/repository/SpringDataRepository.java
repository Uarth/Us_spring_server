package ybigta.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybigta.us.domain.User;

import java.util.Optional;

public interface SpringDataRepository extends JpaRepository<User, Integer>, UserRepository {
    @Override
    User save(User user);

    @Override
    Optional<User> findByName(String name);

    @Override
    Optional<User> findByEmail(String email);

    @Override
    Optional<User> findById(Integer id);
}
