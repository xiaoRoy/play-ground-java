package com.learn.playground.rx.operator.repeat;

import com.learn.playground.rx.operator.model.Gift;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleTime {

    private List<Integer> giftCounts = Arrays.asList(100, 100, 100, 50, 60);

    private int index;

    private Observable<String> loadJwt() {
        return Observable.just("jwt");
    }

    private Observable<Gift> loadGift(String jwt) {
        return Observable
                .fromCallable(() -> jwt.isEmpty() ? "" : "response")
                .map(new Function<String, Gift>() {
                    @Override
                    public Gift apply(String response) throws Exception {
                        return new Gift(giftCounts.get(index++));
                    }
                });
    }



    private void repeatTakeUntil() {
        List<Gift> gifts = new ArrayList<>();
        loadJwt()
                .flatMap(new Function<String, ObservableSource<Gift>>() {
                    @Override
                    public ObservableSource<Gift> apply(String jwt) throws Exception {
                        System.out.println("before.loadGift");
                        return loadGift(jwt);
                    }
                })
                .repeat()
                .takeUntil(new Predicate<Gift>() {
                    @Override
                    public boolean test(Gift gift) throws Exception {
                        return gift.getCount() != 100;
                    }
                })
                .collectInto(gifts, new BiConsumer<List<Gift>, Gift>() {
                    @Override
                    public void accept(List<Gift> gifts, Gift gift) throws Exception {
                        gifts.add(gift);
                    }
                })
                .subscribe(giftsResult -> System.out.println(giftsResult.size()));
//                .subscribe(gift -> System.out.println(gift.getCount()));
    }

    public static void main(String[] args) {
        new MultipleTime().repeatTakeUntil();
    }

    private AtomicInteger offset = new AtomicInteger();

    private void where(){

        /*
        *  List<RegistryGift> allGifts = new ArrayList<>();
        AtomicInteger offset = new AtomicInteger(-100);
        return Observable
                .just(offset)
                .map(pageOffset -> {
                    pageOffset.getAndAdd(REGISTRY_PAGE_LIMIT);
                    return pageOffset;
                })
                .flatMap(pageOffset -> registryGiftApiRetrofit.loadRegistryGiftWithOffset(jwt, userUuid, pageOffset.get()))
                .repeat()
                .takeUntil(RegistryGiftList::isPageNotFull)
                .collectInto(allGifts, (gifts, registryGiftList) -> gifts.addAll(registryGiftList.getAllGifts()))
                .toObservable()
                .subscribeOn(Schedulers.io());
        * */
        /*Observable
                .just(offset);

        Observable.zip(Observable.just(offset), loadJwt(), )*/
    }


    /*
    * public Observable<Gift> getGift() {
        loadJwt()
                .flatMap(new Function<String, ObservableSource<Gift>>() {
                    @Override
                    public ObservableSource<Gift> apply(String jwt) throws Exception {
                        return loadGift(jwt);
                    }
                })
                .repeatWhen(new Function<Observable<Object>, ObservableSource<Gift>>() {
                    @Override
                    public ObservableSource<Gift> apply(Observable<Object> objectObservable) throws Exception {
                        return objectObservable.flatMap(new Function<Object, ObservableSource<Gift>>() {
                            @Override
                            public ObservableSource<Gift> apply(Object object) throws Exception {
                                System.out.println(object);
                                if (object instanceof Gift) {
                                    System.out.println(((Gift) object).getCount());
                                } else {
                                    return Observable.empty();
                                }
                                return Observable.empty();
                            }
                        });
                    }
                })
        ;
        return Observable.just(new Gift(1));
    }

    private void what() {
        AtomicInteger a = new AtomicInteger();

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .repeatWhen(notification -> {
                    return notification.flatMap(o -> {

                        System.out.println("'repeatWhen'");
                        if (a.getAndAdd(1) < 10) {
                            return Observable.just(o).delay(1, TimeUnit.SECONDS);
                        } else {
                            return Observable.empty();
                        }
                    });

                })//
                .subscribe(System.out::println);
    }*/
}
