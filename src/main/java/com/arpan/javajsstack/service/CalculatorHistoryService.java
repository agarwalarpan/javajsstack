package com.arpan.javajsstack.service;

import com.arpan.javajsstack.model.CalculatorOperation;
import com.arpan.javajsstack.respository.CalculatorOperationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CalculatorHistoryService {


    private final CalculatorOperationRepository calculatorOperationRepository;

    public CalculatorHistoryService(CalculatorOperationRepository calculatorOperationRepository) {
        this.calculatorOperationRepository = calculatorOperationRepository;
    }

    public void saveDataAndGetSequence(CalculatorOperation calculatorOperation) {
        CalculatorOperation savedValue = calculatorOperationRepository.save(calculatorOperation);
        calculatorOperation.setSeq(savedValue.getSeq());
    }

    public Iterable<CalculatorOperation> getAllOperations() {
        return calculatorOperationRepository.findAll();
    }

    public List<CalculatorOperation> getOperationsContaining(String chars) {
        return calculatorOperationRepository.getOperationsContaining(chars);
    }

    public CalculatorOperation updateResult(Integer seq, Integer result) {
        Optional<CalculatorOperation> optionalRow = calculatorOperationRepository.findById(seq);
        CalculatorOperation calculatorOperation = optionalRow.orElseThrow();
        calculatorOperation.setResult(result);
        return calculatorOperationRepository.save(calculatorOperation);
    }
//
//    public CalculatorOperation updateResult(Integer seq, Integer result) {
//        Iterable<CalculatorOperation> allById = calculatorOperationRepository.findAllById(Arrays.asList(1, 2, 3));
//        allById.forEach((operation) -> operation.setResult(result));
//        calculatorOperationRepository.saveAll(allById);
//        return allById.iterator().next();
//    }
}
