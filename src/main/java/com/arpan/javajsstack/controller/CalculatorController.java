package com.arpan.javajsstack.controller;

import com.arpan.javajsstack.model.CalculatorOperation;
import com.arpan.javajsstack.service.CalculatorHistoryService;
import com.arpan.javajsstack.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {


    private final CalculatorService calculatorService;
    private final CalculatorHistoryService calculatorHistoryService;

    public CalculatorController(CalculatorService calculatorService, CalculatorHistoryService calculatorHistoryService) {
        this.calculatorService = calculatorService;
        this.calculatorHistoryService = calculatorHistoryService;
    }

    @PostMapping("/calculate")
    public CalculatorOperation calculate(@RequestBody CalculatorOperation calculatorOperation) {
        Integer result;

        switch (calculatorOperation.getType()) {
            case "addition":
                result = calculatorService.add(calculatorOperation.getA(), calculatorOperation.getB());
                break;
            case "subtraction":
                result = calculatorService.subtract(calculatorOperation.getA(), calculatorOperation.getB());
                break;
            case "division":
                result = calculatorService.divide(calculatorOperation.getA(), calculatorOperation.getB());
                break;
            default:
                result = null;
        }

        calculatorOperation.setResult(result);

        calculatorHistoryService.saveDataAndGetSequence(calculatorOperation);

        return calculatorOperation;
    }

    @GetMapping(path="/get-all-operations")
    public Iterable<CalculatorOperation> getAllOperations() {
        return calculatorHistoryService.getAllOperations();
    }

    @GetMapping(path="/get-operations-containing")
    public List<CalculatorOperation> getOperationsContaining(String chars) {
        return calculatorHistoryService.getOperationsContaining(chars);
    }

    @PostMapping(path = "/update-result")
    public CalculatorOperation updateResult(@RequestBody CalculatorOperation calculatorOperation) {
        return calculatorHistoryService.updateResult(calculatorOperation.getSeq(), calculatorOperation.getResult());
    }
}