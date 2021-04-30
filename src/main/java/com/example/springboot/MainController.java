package com.example.springboot;

import com.example.springboot.data.CalculationEntity;
import com.example.springboot.domain.CalculateUseCase;
import com.example.springboot.domain.GetHistoryUseCase;
import com.example.springboot.domain.GetStatisticsUseCase;
import com.example.springboot.domain.RegisterRequestUseCase;
import com.example.springboot.exceptions.InvalidInputException;
import com.example.springboot.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    CalculateUseCase calculateUseCase;

    @Autowired
    RegisterRequestUseCase registerRequestUseCase;

    @Autowired
    GetStatisticsUseCase getStatisticsUseCase;

    @Autowired
    GetHistoryUseCase getHistoryUseCase;

    @GetMapping("/{calculation}/calculate")
    public CalculationsResult calculate(
            @PathVariable("calculation") Calculation calculation,
            @RequestParam("a") double a,
            @RequestParam("b") double b,
            @RequestParam("c") double c
    ) {
        registerRequestUseCase.registerRequest();
        if (a < 0 || b < 0 || c < 0) {
            logger.warn("Request with invalid params");
            throw new InvalidInputException();
        }
        logger.info("Request to calculate " + calculation + " of triangle " + a + " " + b + " " + c);
        return calculateUseCase.calculate(calculation, new Triangle(a, b, c));
    }

    @PostMapping("/calculate/list")
    public List<CalculationsResult> calculateList(
            @RequestBody List<CalculationRequest> requests
    ) {
        return calculateUseCase.calculateList(requests);
    }

    @PostMapping("/{statistics}/stat")
    public CalculationsResult getStatistics(
            @PathVariable("statistics") Statistics statistics,
            @RequestBody List<CalculationRequest> requests
    ) {
        return getStatisticsUseCase.getStatistics(statistics, requests);
    }

    @PostMapping("/count")
    public CalculationsResult countResults(
            @RequestBody List<CalculationRequest> requests,
            @RequestParam("value") double value
    ) {
        return getStatisticsUseCase.count(value, requests);
    }

    @GetMapping("/history")
    public List<CalculationEntity> getCalculations() {
        return getHistoryUseCase.getHistory();
    }
}