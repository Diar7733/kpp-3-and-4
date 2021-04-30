package com.example.springboot.data;

import java.util.List;

public interface CalculationDao {

    List<CalculationEntity> getCalculations();

    void addCalculation(CalculationEntity calculationEntity);
}
