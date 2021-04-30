package com.example.springboot.domain;

import com.example.springboot.domain.interfaces.StatisticsService;
import com.example.springboot.exceptions.UnknownErrorException;
import com.example.springboot.models.CalculationRequest;
import com.example.springboot.models.CalculationsResult;
import com.example.springboot.models.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStatisticsUseCase {

    @Autowired
    CalculateUseCase calculateUseCase;

    @Autowired
    StatisticsService statisticsService;

    public CalculationsResult getStatistics(Statistics statistics, List<CalculationRequest> requests) {
        if (statistics == Statistics.MAX) {
            return statisticsService.getMax(calculateUseCase.calculateList(requests));
        } else if (statistics == Statistics.MIN) {
            return statisticsService.getMin(calculateUseCase.calculateList(requests));
        } else throw new UnknownErrorException();
    }

    public CalculationsResult count(double value, List<CalculationRequest> requests) {
        return statisticsService.count(value, calculateUseCase.calculateList(requests));
    }
}
