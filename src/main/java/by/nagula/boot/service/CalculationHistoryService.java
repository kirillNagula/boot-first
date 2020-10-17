package by.nagula.boot.service;

import by.nagula.boot.entity.Operation;
import by.nagula.boot.dao.CalculationHistoryDaoImpl;
import by.nagula.boot.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculationHistoryService {
    private final CalculationHistoryDaoImpl calculationHistoryDao;
    private final OperationRepository operationRepository;

    public CalculationHistoryService(CalculationHistoryDaoImpl calculationHistoryDao, OperationRepository operationRepository) {
        this.calculationHistoryDao = calculationHistoryDao;
        this.operationRepository = operationRepository;
    }

    public void add(Operation operation){
        operationRepository.save(operation);
    }

    public List<Operation> showAll(){
        return (List<Operation>) operationRepository.findAll();
    }

    public List<Operation> showAllSorted(String type){
        return operationRepository.findByType(type);
    }
}
