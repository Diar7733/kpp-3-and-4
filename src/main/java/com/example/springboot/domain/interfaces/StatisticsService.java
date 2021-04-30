package com.example.springboot.domain.interfaces;

import com.example.springboot.models.CalculationsResult;

import java.util.List;

public interface StatisticsService {

    CalculationsResult getMin(List<CalculationsResult> results);

    CalculationsResult getMax(List<CalculationsResult> results);

    CalculationsResult count(double value, List<CalculationsResult> results);
}
