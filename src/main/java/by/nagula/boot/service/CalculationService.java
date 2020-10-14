package by.nagula.boot.service;

import by.nagula.boot.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double calculation(Operation operation){
        switch (operation.getType()){
            case "sum": return operation.getNum1() + operation.getNum2();
            case "mult": return operation.getNum1() * operation.getNum2();
            case "sub": return operation.getNum1() - operation.getNum2();
            case "div": return operation.getNum1() / operation.getNum2();
            default: return 0;
        }
    }
}
