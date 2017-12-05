package com.george.reactiveprogramming;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

/**
 * Observable - a continuous stream of data
 *
 * @author george
 */
public class Sample {

    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("INTC", "BABA", "TSLA", "AIR.PA", "YHOO");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("Got observable...");

        feed
                .filter(stockInfo -> stockInfo.getValue() > 500)
                .subscribe(
                        stockInfo -> System.out.println(stockInfo),
                        System.out::println,
                        () -> System.out.println("DONE"));
    }

}
