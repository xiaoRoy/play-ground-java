package com.learn.playground.rxtest;

import io.reactivex.Observable;

public class RemoteCountryRepository implements CountryRepository{

    @Override
    public Observable<Country> getCountry() {
        return null;
    }
}
