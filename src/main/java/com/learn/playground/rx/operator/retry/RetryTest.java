package com.learn.playground.rx.operator.retry;

import com.learn.playground.rx.operator.model.Gift;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetryTest {

    private int index = 0;

    private static List<Integer> counts = Arrays.asList(100, 100, 43, 100);

    private Observable<String> getJwt() {
        return Observable.just("jwt");
    }

    private Observable<Gift> getGift(String jwt) {
        return Observable.fromCallable(() -> jwt.isEmpty() ? 0 : counts.get(index++))
                .map(Gift::new);
    }


    public void loadGift() {
        getJwt().flatMap(jwt -> getGift(jwt))
                /*.flatMap(gift -> {
                    if (gift.getCount() == 100) {
                        return Observable.empty();
                    } else {
                        return Observable.just(gift);
                    }
                })*/
                .repeatWhen(new Function<Observable<Object>, ObservableSource<Gift>>() {
            @Override
            public ObservableSource<Gift> apply(Observable<Object> objectObservable) throws Exception {
                return Observable.just(new Gift(100 ));
            }
        })
                .subscribe(observer);

    }

    private Observer<Gift> observer = new Observer<Gift>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Gift gift) {
            System.out.println("onNext");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    };

    public static void main(String[] args) {
        new RetryTest().loadGift();
    }


}
