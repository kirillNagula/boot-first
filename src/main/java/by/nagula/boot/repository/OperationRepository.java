package by.nagula.boot.repository;

import by.nagula.boot.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByType(String type);
}
