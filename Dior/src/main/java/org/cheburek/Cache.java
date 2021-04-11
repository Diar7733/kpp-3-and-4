package org.cheburek;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {

    private final Map<GetParam, Double> CacheMap= new HashMap<GetParam, Double>();

    public Double getAnswer(GetParam obj) {
        Double answer = CacheMap.get(obj);
        return answer;
    }
    public void putAnswer(GetParam obj, double answer) {
        CacheMap.put(obj,answer);
    }

}
