package com.example.springboot.domain.interfaces;

import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;

public interface CalculationService {

    CalculationsResult calculate(Triangle triangle);
}
