package pl.tscript3r.notify.client.backend.services.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.tscript3r.notify.client.backend.data.entities.User;
import pl.tscript3r.notify.client.backend.repositories.UserRepository;
import pl.tscript3r.notify.client.backend.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User create() {
        return new User();
    }

}
