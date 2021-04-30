package com.example.springboot.domain.calculations;

import com.example.springboot.domain.interfaces.CalculationService;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;

public class PerimeterCalculationService implements CalculationService {

    private double getPerimeterValue(Triangle triangle) {
        return triangle.getA() + triangle.getB() + triangle.getC();
    }

    @Override
    public CalculationsResult calculate(Triangle triangle) {
        return new CalculationsResult(getPerimeterValue(triangle));
    }
}
