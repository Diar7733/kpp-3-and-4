package com.example.springboot.data;

import com.example.springboot.models.Calculation;
import com.example.springboot.models.Triangle;

import java.util.Objects;

public class CacheCalculationKey {
    private final Triangle triangle;
    private final Calculation calculation;

    CacheCalculationKey(Triangle triangle, Calculation calculation) {
        this.triangle = triangle;
        this.calculation = calculation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheCalculationKey that = (CacheCalculationKey) o;
        return Objects.equals(triangle, that.triangle) && calculation == that.calculation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(triangle, calculation);
    }
}
