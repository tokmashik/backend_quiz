package project.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.backend.domain.Message;

public interface MessageRepo  extends JpaRepository<Message, Long> {
}
