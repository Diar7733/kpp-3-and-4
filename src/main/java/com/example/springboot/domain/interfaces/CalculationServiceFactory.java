package com.example.springboot.domain.interfaces;

import com.example.springboot.models.Calculation;

public interface CalculationServiceFactory {

    CalculationService getService(Calculation calculation);
}
