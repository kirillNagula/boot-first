package by.nagula.boot.repository;

import by.nagula.boot.entity.ApplicationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationKeyRepository extends JpaRepository<ApplicationKey, Long> {
    Optional<ApplicationKey> findByLogin (String login);
    Optional<ApplicationKey> findByApiKey (String apiKey);
}
