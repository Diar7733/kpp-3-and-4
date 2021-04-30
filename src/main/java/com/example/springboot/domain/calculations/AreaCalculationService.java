package com.example.springboot.domain.calculations;

import com.example.springboot.domain.interfaces.CalculationService;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;

public class AreaCalculationService implements CalculationService {

    private double getArea(Triangle triangle) {
        double semiPerimeter = (triangle.getA() + triangle.getB() + triangle.getC()) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getA()) * (semiPerimeter - triangle.getB()) * (semiPerimeter - triangle.getC()));
    }

    @Override
    public CalculationsResult calculate(Triangle triangle) {
        return new CalculationsResult(getArea(triangle));
    }
}
