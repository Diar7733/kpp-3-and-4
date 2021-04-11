package org.cheburek;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Interpritation {

    @JsonProperty("Perimetr")
    double per;

    @JsonProperty("Ploschad")
    double res;
    @JsonProperty("Count")
    AtomicInteger cout;

    public Interpritation(double perimetr, double result, AtomicInteger count)
    {
        per=perimetr;res=result;cout=count;
    }
}
