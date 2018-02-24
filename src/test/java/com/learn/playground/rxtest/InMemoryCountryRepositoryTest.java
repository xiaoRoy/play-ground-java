package com.learn.playground.rxtest;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;
import org.junit.Assert;
import org.junit.Test;

public class InMemoryCountryRepositoryTest {

    @Test
    public void test_get_country(){
        InMemoryCountryRepository inMemoryCountryRepository =
                 new InMemoryCountryRepository();
        TestObserver<Country> testObserver = inMemoryCountryRepository.getCountry().test();
        testObserver.assertComplete();
        testObserver.assertValueCount(2);
    }
}
