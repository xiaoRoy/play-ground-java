package com.learn.playground.rxtest;

import io.reactivex.Observable;

public interface CountryRepository {
    Observable<Country> getCountry();
}
