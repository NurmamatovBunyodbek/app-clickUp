package uz.pdp.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appclickup.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User ,Long> {

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

}
