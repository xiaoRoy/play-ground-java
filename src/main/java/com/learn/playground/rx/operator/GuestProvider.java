package com.learn.playground.rx.operator;

import com.learn.playground.rx.operator.model.Guest;
import com.learn.playground.rx.operator.model.GuestRepository;
import io.reactivex.Observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class GuestProvider {

    private final GuestRepository guestRepository;

    public GuestProvider(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    private Observable<Guest> loadGuestFromLocal(){
        return loadDataWithEmptyPredicate(guestRepository.loadGuest(), guest -> guest == null);
    }

    private Observable<Guest> loadGuestFromRemote(){
        return Observable
                .timer(3, TimeUnit.SECONDS)
                .flatMap(aLong -> Observable.just(new Guest()));

    }

    public Observable<Guest> loadGuest(){
        return loadDataOptionally(loadGuestFromLocal(), loadGuestFromRemote());
    }

    private <T> Observable<T> loadDataOptionally(Observable<T> one, Observable<T> another){
        return Observable
                .concat(one, another)
                .take(1);
    }

    private static <T> Observable<T> loadDataWithEmptyPredicate(T data, Predicate<T> emptyPredicate){
        Observable<T> result;
        if(emptyPredicate.test(data)){
            result = Observable.empty();
        } else {
            result = Observable.just(data);
        }
        return result;
    }


    /*return Maybe.fromCallable(() -> {
            if(emptyPredicate.test(data)){
                return null;
            } else {
                return data;
            }
        }).toObservable();*/

    public static class PredicateCallable<T> implements Callable<T>{

        private T data;

        private Predicate<T> predicate;

        public PredicateCallable(T data, Predicate<T> predicate) {
            this.data = data;
            this.predicate = predicate;
        }

        @Override
        public T call() throws Exception {
            T result = data;
            if(predicate.test(data)){
                result = null;
            }
            return result;
        }
    }
}
