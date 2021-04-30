package com.example.springboot.domain;

import com.example.springboot.domain.interfaces.MetricUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestUseCase {

    @Autowired
    MetricUtilsService metricUtilsService;

    public void registerRequest() {
        metricUtilsService.registerServiceRequest();
    }
}
