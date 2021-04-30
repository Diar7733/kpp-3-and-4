package com.example.springboot.domain.calculations;

import com.example.springboot.domain.interfaces.CalculationService;
import com.example.springboot.domain.interfaces.CalculationServiceFactory;
import com.example.springboot.exceptions.UnknownErrorException;
import com.example.springboot.models.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalculationServiceFactoryImpl implements CalculationServiceFactory {

    Logger logger = LoggerFactory.getLogger(CalculationServiceFactoryImpl.class);

    @Override
    public CalculationService getService(Calculation calculation) {
        if (calculation == Calculation.AREA) {
            return new AreaCalculationService();
        } else if (calculation == Calculation.PERIMETER) return new PerimeterCalculationService();
        else {
            logger.error("unknown calculation " + calculation);
            throw new UnknownErrorException();
        }
    }
}
