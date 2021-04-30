package com.example.springboot.domain;

import com.example.springboot.domain.calculations.PerimeterCalculationService;
import com.example.springboot.models.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerimeterCalculationServiceTest {

    private final PerimeterCalculationService service = new PerimeterCalculationService();

    @Test
    void testCalculateReturnsCorrectValue() {
        assertEquals(0.0, service.calculate(new Triangle(0, 0, 0)).getValue());
        assertEquals(12.0, service.calculate(new Triangle(3, 4, 5)).getValue());
    }
}