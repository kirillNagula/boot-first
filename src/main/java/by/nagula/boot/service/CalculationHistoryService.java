package by.nagula.boot.service;

import by.nagula.boot.entity.Operation;
import by.nagula.boot.dao.CalculationHistoryDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationHistoryService {
    private final CalculationHistoryDaoImpl calculationHistoryDao;

    public CalculationHistoryService(CalculationHistoryDaoImpl calculationHistoryDao) {
        this.calculationHistoryDao = calculationHistoryDao;
    }

    public void add(Operation operation){
        calculationHistoryDao.addNewOperation(operation);
    }

    public List<Operation> showAll(){
        return calculationHistoryDao.showAll();
    }

    public List<Operation> showAllSorted(String type){
        return calculationHistoryDao.showType(type);
    }
}
