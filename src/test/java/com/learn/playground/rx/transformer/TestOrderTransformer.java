package com.learn.playground.rx.transformer;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import java.util.Objects;

public class TestOrderTransformer {


    @Test
    public void test_orderTransformer() {
        TestObserver<Order> testObserver = new TestObserver<>();
        Observable.just(Order.JSON_EXAMPLE)
                .compose(new OrderTransformer())
                .subscribe(testObserver);
        testObserver.assertValueCount(1);
        testObserver.assertValue(order -> Objects.equals("123232", order.getId()));
    }

    @Test
    public void test_orderTransformer_anotherApproachToCreateTestObserver() {
        TestObserver<Order> testObserver =
                Observable.just(Order.JSON_EXAMPLE)
                        .compose(new OrderTransformer()).test();
        testObserver.assertValueCount(1);
        testObserver.assertValue(order -> Objects.equals("123232", order.getId()));
    }
}
