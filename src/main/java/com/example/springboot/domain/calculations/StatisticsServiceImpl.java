package com.example.springboot.domain.calculations;

import com.example.springboot.domain.interfaces.StatisticsService;
import com.example.springboot.exceptions.InvalidInputException;
import com.example.springboot.models.CalculationsResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public CalculationsResult getMin(List<CalculationsResult> results) {
        Optional<Double> result = results.stream().map(CalculationsResult::getValue).min(Double::compare);
        if (result.isPresent()) {
            return new CalculationsResult(result.get());
        } else throw new InvalidInputException();
    }

    @Override
    public CalculationsResult getMax(List<CalculationsResult> results) {
        Optional<Double> result = results.stream().map(CalculationsResult::getValue).max(Double::compare);
        if (result.isPresent()) {
            return new CalculationsResult(result.get());
        } else throw new InvalidInputException();
    }

    @Override
    public CalculationsResult count(double value, List<CalculationsResult> results) {
        return new CalculationsResult(
                results.stream()
                        .map(CalculationsResult::getValue)
                        .filter(r -> r == value)
                        .count()
        );
    }
}
