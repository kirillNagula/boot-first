package by.nagula.boot.controller;

import by.nagula.boot.entity.Operation;
import by.nagula.boot.service.CalculationHistoryService;
import by.nagula.boot.service.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/calc")
public class CalculationResource {
    private final CalculationService calculationService;
    private final CalculationHistoryService calculationHistoryService;

    public CalculationResource(CalculationService calculationService, CalculationHistoryService calculationHistoryService) {
        this.calculationService = calculationService;
        this.calculationHistoryService = calculationHistoryService;
    }

    @GetMapping(path = "/history")
    public List<Operation> showAll(){
        return calculationHistoryService.showAll();
    }

    @GetMapping(path = "/history/sort/{type}")
    public List<Operation> showAllSorted(@PathVariable String type){
         return calculationHistoryService.showAllSorted(type);
    }

    @PostMapping("/calc")
    public Operation calculation(@RequestBody Operation operation){
        operation.setResult(calculationService.calculation(operation));
        calculationHistoryService.add(operation);
        return operation;
    }


}
