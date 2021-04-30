package com.example.springboot.domain;

import com.example.springboot.domain.calculations.AreaCalculationService;
import com.example.springboot.models.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaCalculationServiceTest {

    private final AreaCalculationService service = new AreaCalculationService();

    @Test
    void testCalculateReturnsCorrectValue() {
        assertEquals(0.0, service.calculate(new Triangle(0, 0, 0)).getValue());
        assertEquals(6.0, service.calculate(new Triangle(3, 4, 5)).getValue());
    }
}