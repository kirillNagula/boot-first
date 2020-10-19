package by.nagula.boot.controller;

import by.nagula.boot.entity.ApplicationKey;
import by.nagula.boot.entity.Operation;
import by.nagula.boot.service.ApplicationKeyService;
import by.nagula.boot.service.CalculationHistoryService;
import by.nagula.boot.service.CalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/calc")
public class CalculationResource {
    private final CalculationService calculationService;
    private final CalculationHistoryService calculationHistoryService;
    private final ApplicationKeyService applicationKeyService;

    public CalculationResource(CalculationService calculationService, CalculationHistoryService calculationHistoryService, ApplicationKeyService applicationKeyService) {
        this.calculationService = calculationService;
        this.calculationHistoryService = calculationHistoryService;
        this.applicationKeyService = applicationKeyService;
    }

    @GetMapping(path = "/history")
    public List<Operation> showAll(@RequestHeader ("apiKey") String apiKey){
        if (checkKey(apiKey)){
            return new ArrayList<>();
        } else {
            return calculationHistoryService.showAll();
        }
    }

    @GetMapping(path = "/history/sort/{type}")
    public List<Operation> showAllSorted(@PathVariable String type){
         return calculationHistoryService.showAllSorted(type);
    }

    @PostMapping("/calc")
    public Operation calculation(@RequestBody Operation operation, @RequestHeader ("apiKey") String apiKey){
        if (checkKey(apiKey)){
            return new Operation();
        } else {
            operation.setResult(calculationService.calculation(operation));
            calculationHistoryService.add(operation);
            return operation;
        }

    }

    private boolean checkKey(String apiKey){
        return applicationKeyService.containsByApi(apiKey);
    }

}
