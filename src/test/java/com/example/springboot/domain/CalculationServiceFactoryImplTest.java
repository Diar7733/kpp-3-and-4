package com.example.springboot.domain;

import com.example.springboot.domain.calculations.AreaCalculationService;
import com.example.springboot.domain.calculations.CalculationServiceFactoryImpl;
import com.example.springboot.domain.calculations.PerimeterCalculationService;
import com.example.springboot.domain.interfaces.CalculationServiceFactory;
import com.example.springboot.models.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceFactoryImplTest {

    private final CalculationServiceFactory factory = new CalculationServiceFactoryImpl();

    @Test
    void testReturnsCorrectServiceForArea() {
        assertTrue(factory.getService(Calculation.AREA) instanceof AreaCalculationService);
    }

    @Test
    void testReturnsCorrectServiceForPerimeter() {
        assertTrue(factory.getService(Calculation.PERIMETER) instanceof PerimeterCalculationService);
    }
}