package by.nagula.boot.dao;

import by.nagula.boot.entity.Operation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculationHistoryDaoImpl implements CalculationHistoryDao {

    private final List<Operation> operations = new ArrayList<>();

    @Override
    public void addNewOperation(Operation calculation) {
        operations.add(calculation);
    }

    @Override
    public List<Operation> showAll() {
        return operations;
    }

    @Override
    public List<Operation> showType(String type) {
        List<Operation> operationList = new ArrayList<>();

        for (Operation operation: operations){
            if (operation.getType().equals(type)){
                operationList.add(operation);
            }
        }
        return operationList;
    }

}
