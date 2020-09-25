package com.arpan.javajsstack.respository;

import com.arpan.javajsstack.model.CalculatorOperation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalculatorOperationRepository extends CrudRepository<CalculatorOperation, Integer> {

    @Query("select c from CalculatorOperation c where c.type like %?1%")
    List<CalculatorOperation> getOperationsContaining(String chars);
}
