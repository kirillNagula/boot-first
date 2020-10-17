package by.nagula.boot.repository;

import by.nagula.boot.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByType(String type);
}
