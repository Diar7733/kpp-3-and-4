package com.example.springboot.domain;

import com.example.springboot.data.CalculationDao;
import com.example.springboot.data.CalculationEntity;
import com.example.springboot.domain.interfaces.CacheService;
import com.example.springboot.domain.interfaces.CalculationServiceFactory;
import com.example.springboot.models.Calculation;
import com.example.springboot.models.CalculationRequest;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CalculateUseCase {

    @Autowired
    CacheService cacheService;

    @Autowired
    CalculationServiceFactory factory;

    @Autowired
    CalculationDao dao;

    Logger logger = LoggerFactory.getLogger(CalculateUseCase.class);

    private CalculationsResult calculateSingle(Calculation calculation, Triangle triangle) {
        CalculationsResult result = cacheService.getResult(calculation, triangle);
        if (result == null) {
            logger.info("Recalculation is required");
            result = factory.getService(calculation).calculate(triangle);
            cacheService.addResult(calculation, triangle, result);
        }
        dao.addCalculation(new CalculationEntity(new CalculationRequest(calculation, triangle), result));
        return result;
    }

    public CalculationsResult calculate(Calculation calculation, Triangle triangle) {
        return calculateSingle(calculation, triangle);
    }

    public List<CalculationsResult> calculateList(List<CalculationRequest> requests) {
        return requests.stream()
                .map(r -> calculateSingle(r.getCalculation(), r.getTriangle())
                )
                .collect(Collectors.toList());
    }
}
