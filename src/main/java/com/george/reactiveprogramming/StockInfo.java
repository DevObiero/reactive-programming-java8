package com.george.reactiveprogramming;

/**
 * @author george
 */
public class StockInfo {
    private Double value;
    private String ticker;

    public StockInfo(String theTicker, Double theValue) {
        this.ticker = theTicker;
        this.value = theValue;
    }

    public static StockInfo fetch(String ticker) {
        return new StockInfo(ticker, YahooFinance.getPrice(ticker, true));
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return String.format("%s : %f", ticker, value);
    }
}
