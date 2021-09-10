package ru.ceounit.teatime.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ceounit.teatime.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findByEmail(String email);
}
