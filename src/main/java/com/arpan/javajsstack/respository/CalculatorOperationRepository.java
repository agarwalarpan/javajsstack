package com.arpan.javajsstack.respository;

import com.arpan.javajsstack.model.CalculatorOperation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorOperationRepository extends CrudRepository<CalculatorOperation, Integer> {

    @Query("select c from CalculatorOperation c where c.type like %?1%")
    List<CalculatorOperation> getOperationsContaining(String chars);
}
