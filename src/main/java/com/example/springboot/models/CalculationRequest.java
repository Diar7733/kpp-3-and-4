package com.example.springboot.models;

public class CalculationRequest {

    private final Calculation calculation;

    private final Triangle triangle;

    public CalculationRequest(Calculation calculation, Triangle triangle) {
        this.calculation = calculation;
        this.triangle = triangle;
    }

    public Calculation getCalculation() {
        return calculation;
    }

    public Triangle getTriangle() {
        return triangle;
    }
}
