package pl.tscript3r.notify.client.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tscript3r.notify.client.backend.data.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCase(String email);

}
