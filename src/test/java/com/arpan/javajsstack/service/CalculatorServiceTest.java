package com.arpan.javajsstack.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {
    private static CalculatorService calculatorService;

    @BeforeAll
    static void beforeAll() {
        calculatorService = new CalculatorService();
    }

    @Test
    void add() {
        assertThat(calculatorService.add(1, 2)).isEqualTo(3);
    }
}
