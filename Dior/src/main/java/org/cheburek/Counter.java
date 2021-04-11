package org.cheburek;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {

    private static AtomicInteger counter=new AtomicInteger(0);;

    public static void increment() { counter.incrementAndGet(); }

    public AtomicInteger getCounter() { return  counter; }
}
