package com.arpan.javajsstack.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }
}
