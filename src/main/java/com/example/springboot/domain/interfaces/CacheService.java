package com.example.springboot.domain.interfaces;

import com.example.springboot.models.Calculation;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;

public interface CacheService {

    CalculationsResult getResult(Calculation calculation, Triangle triangle);

    void addResult(Calculation calculation, Triangle triangle, CalculationsResult calculationsResult);
}
