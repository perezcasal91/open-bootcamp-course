package com.perezcasal.designpatterns.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherObserverMain {
    public static void main(String[] args) {
        Weather weather = new Weather();

        Computer computer = new Computer();
        SmartPhone smartPhone = new SmartPhone();
        SmartWatch smartWatch = new SmartWatch();

        weather.addObserver(computer);
        weather.addObserver(smartPhone);
        weather.addObserver(smartWatch);

        weather.changeWeather(WeatherType.CLOUDY);

        weather.deleteObserver(smartWatch);

        weather.changeWeather(WeatherType.SUNSHINE);
    }
}

class Computer implements WeatherObserver {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("Computer the weather has change to: " + weatherType);
    }
}
class SmartPhone implements WeatherObserver {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("SmartPhone the weather has change to: " + weatherType);
    }
}
class SmartWatch implements WeatherObserver {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("SmartWatch the weather has change to: " + weatherType);
    }
}

interface WeatherObserver {
    void update(WeatherType weatherType);
}
class Weather {
    private final List<WeatherObserver> observers;
    private WeatherType weatherType;
    public Weather() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(WeatherObserver weatherObserver) {
        this.observers.add(weatherObserver);
        System.out.println("Observer added.");
    }

    public void deleteObserver(WeatherObserver weatherObserver) {
        this.observers.remove(weatherObserver);
        System.out.println("Observer deleted.");
    }

    public void changeWeather(WeatherType weatherType) {
        this.weatherType = weatherType;
        notifyObservers();
    }

    private void notifyObservers() {
        this.observers.forEach(observer-> observer.update(this.weatherType));
    }
}
enum WeatherType {
    SUNSHINE, CLOUDY, PARTY_CLOUDY, OVERCAST, RAINING, SNOWY, FOGGY, THUNDER_LIGHTNING, WINDY
}