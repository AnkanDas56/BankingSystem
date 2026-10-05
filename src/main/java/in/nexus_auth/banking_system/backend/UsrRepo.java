package in.nexus_auth.banking_system.backend;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsrRepo extends JpaRepository<UserRow,String> {
    Optional<User> findByUsername(String username);
}
