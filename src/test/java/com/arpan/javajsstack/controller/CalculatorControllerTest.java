package com.arpan.javajsstack.controller;

import com.arpan.javajsstack.model.CalculatorOperation;
import com.arpan.javajsstack.service.CalculatorHistoryService;
import com.arpan.javajsstack.service.CalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//Mockito example
class CalculatorControllerTest {

    private static CalculatorService calculatorService;
    private static CalculatorHistoryService calculatorHistoryService;
    private static CalculatorController calculatorController;

    @BeforeAll
    static void beforeAll() {
        calculatorService = mock(CalculatorService.class);
        calculatorHistoryService = mock(CalculatorHistoryService.class);
        calculatorController = new CalculatorController(calculatorService, calculatorHistoryService);
    }
    @Test
    void add() {
        given(calculatorService.add(1,2)).willReturn(4);

        CalculatorOperation calculatorOperation = new CalculatorOperation(1, 2, null);
        calculatorOperation.setType("addition");
        CalculatorOperation result = calculatorController.calculate(calculatorOperation);

        verify(calculatorService, times(1)).add(1, 2);
        assertThat(result.getResult()).isEqualTo(4);
    }

}