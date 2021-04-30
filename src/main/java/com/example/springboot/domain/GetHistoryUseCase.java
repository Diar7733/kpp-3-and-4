package com.example.springboot.domain;

import com.example.springboot.data.CalculationDao;
import com.example.springboot.data.CalculationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetHistoryUseCase {

    @Autowired
    CalculationDao dao;

    public List<CalculationEntity> getHistory() {
        return dao.getCalculations();
    }
}
