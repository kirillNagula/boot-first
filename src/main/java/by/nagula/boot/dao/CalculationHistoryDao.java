package by.nagula.boot.dao;

import by.nagula.boot.entity.Operation;

import java.util.List;

public interface CalculationHistoryDao {
    void addNewOperation(Operation operation);
    List<Operation> showAll();
    List<Operation> showType(String type);
}
