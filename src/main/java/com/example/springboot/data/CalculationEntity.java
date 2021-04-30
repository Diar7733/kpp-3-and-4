package com.example.springboot.data;

import com.example.springboot.models.Calculation;
import com.example.springboot.models.CalculationRequest;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Calculation")
public class CalculationEntity implements Serializable {

    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Id
    @Column(name = "calculation")
    @Enumerated(EnumType.STRING)
    private Calculation calculation;

    @Id
    @Column(name = "a")
    private double a;

    @Id
    @Column(name = "b")
    private double b;

    @Id
    @Column(name = "c")
    private double c;

    @Id
    @Column(name = "result")
    private double result;

    public CalculationEntity(CalculationRequest request, CalculationsResult result) {
        this.calculation = request.getCalculation();
        Triangle triangle = request.getTriangle();
        this.a = triangle.getA();
        this.b = triangle.getB();
        this.c = triangle.getC();
        this.result = result.getValue();
    }

    public CalculationEntity() {}

    public Calculation getCalculation() {
        return calculation;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getResult() {
        return result;
    }
}
