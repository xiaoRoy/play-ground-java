package com.learn.training.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable<WeatherData>{

    private WeatherData weatherData;

    public WeatherStation() {
    }

    private List<Observer<WeatherData>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<WeatherData> observer) {

    }

    @Override
    public void removeObserver(Observer<WeatherData> observer) {

    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer<WeatherData> observer : observers){
            observer.update(weatherData);
        }
    }
}
