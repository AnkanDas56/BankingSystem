package in.nexus_auth.banking_system.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepo extends JpaRepository<UserRow,String> {
}
