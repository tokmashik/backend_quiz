package project.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.backend.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
