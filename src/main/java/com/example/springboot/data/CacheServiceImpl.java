package com.example.springboot.data;

import com.example.springboot.domain.interfaces.CacheService;
import com.example.springboot.models.Calculation;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CacheServiceImpl implements CacheService {

    private final HashMap<CacheCalculationKey, CalculationsResult> cacheHashMap = new HashMap<>();

    @Override
    public CalculationsResult getResult(Calculation calculation, Triangle triangle) {
        return cacheHashMap.get(new CacheCalculationKey(triangle, calculation));
    }

    @Override
    public void addResult(Calculation calculation, Triangle triangle, CalculationsResult calculationsResult) {
        cacheHashMap.put(new CacheCalculationKey(triangle, calculation), calculationsResult);
    }
}
