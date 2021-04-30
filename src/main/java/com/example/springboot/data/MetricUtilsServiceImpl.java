package com.example.springboot.data;

import com.example.springboot.domain.interfaces.MetricUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MetricUtilsServiceImpl implements MetricUtilsService {

    private final AtomicInteger count = new AtomicInteger(0);

    Logger logger = LoggerFactory.getLogger(MetricUtilsServiceImpl.class);

    @Override
    public void registerServiceRequest() {
        logger.info(count.incrementAndGet() + " requests was registered");
    }
}
