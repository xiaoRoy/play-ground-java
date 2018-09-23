package com.learn.playground.dependencyinjection.vehicle;

import com.learn.playground.dependencyinjection.model.Car;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {


    @Test
    public void test_build_car(){
        VehiclesComponent vehiclesComponent = DaggerVehiclesComponent.create();

        Car carA = vehiclesComponent.buildCar();
        Car carB = vehiclesComponent.buildCar();

        Assert.assertNotNull(carA);
        Assert.assertNotNull(carB);

        Assert.assertNotNull(carA.getEngine());
        Assert.assertNotNull(carB.getEngine());

        Assert.assertNotNull(carA.getBrand());
        Assert.assertNotNull(carB.getBrand());

        Assert.assertNotEquals(carA.getEngine(), carB.getBrand());

        Assert.assertEquals(carA.getBrand(), carB.getBrand());
    }
}
