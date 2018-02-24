package com.learn.playground.rxtest;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryCountryRepository implements CountryRepository{

    private static List<Country> sCountryList;

    static {
        sCountryList = new ArrayList<>();
        sCountryList.addAll(Arrays.asList(new Country("China"), new Country("American"), new Country("England")));
    }

    @Override
    public Observable<Country> getCountry() {
        return Observable
                .fromIterable(sCountryList)
                .filter(country -> !"American".equals(country.getName()));
    }
}
