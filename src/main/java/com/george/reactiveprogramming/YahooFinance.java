package com.george.reactiveprogramming;

import java.util.Random;

/**
 * @author george
 */
public class YahooFinance {
    public static Double getPrice(String ticker, boolean useMock) {
        if (useMock) {
            return 500 + new Random().nextDouble() * (1000 - 500);
        }

        return null;
    }
}
