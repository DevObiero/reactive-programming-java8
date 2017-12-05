package com.george.reactiveprogramming;

import java.util.List;

import rx.Observable;
import rx.Subscriber;


/**
 * @author george
 */
public class StockServer {

    private StockServer() {
    }

    public static Observable<StockInfo> getFeed(List<String> symbols) {
        System.out.println("Observable created....");
        return Observable.create(emitter -> emitPrice(emitter, symbols));
    }

    private static void emitPrice(Subscriber<? super StockInfo> emitter, List<String> symbols) {
        System.out.println("Ready to emit price...");
        int count = 0;
        while (count < 5) {
            symbols.stream()
                    .map(StockInfo::fetch)
                    .forEach(emitter::onNext);

            sleep(1000);
            count++;
        }

        emitter.onCompleted();
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
