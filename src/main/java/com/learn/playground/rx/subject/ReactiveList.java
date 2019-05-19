package com.learn.playground.rx.subject;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

import java.util.ArrayList;
import java.util.List;

public class ReactiveList<T> {

    public static enum ChangeEvent {
        ADD, REMOVE, UPDATE
    }

    private final List<T> list = new ArrayList<>();

    private final PublishSubject<ChangeEvent> changeEvent = PublishSubject.create();

    private final BehaviorSubject<T> changedValues = BehaviorSubject.create();

    private final ReplaySubject<T> latestAdded = ReplaySubject.create(10);

    public PublishSubject<ChangeEvent> getChangeEvent() {
        return changeEvent;
    }

    public BehaviorSubject<T> getChangedValues() {
        return changedValues;
    }

    public ReplaySubject<T> getLatestAdded() {
        return latestAdded;
    }

    public void add(T item) {
        list.add(item);
        changeEvent.onNext(ChangeEvent.ADD);
        changedValues.onNext(item);
        latestAdded.onNext(item);
    }

    public void remove(T item) {
        if(list.remove(item)) {
            changeEvent.onNext(ChangeEvent.REMOVE);
            changedValues.onNext(item);
        }
    }

    public void replace(T oldValue, T newValue) {
        int index = list.indexOf(oldValue);
        if(index > -1) {
            list.set(index, newValue);
            changeEvent.onNext(ChangeEvent.UPDATE);
            changedValues.onNext(newValue);
        }
    }
}
