package com.learn.playground.dependencyinjection.vehicle.fieldinjection;

import com.learn.playground.dependencyinjection.vehicle.DaggerVehiclesComponent;
import com.learn.playground.dependencyinjection.vehicle.VehiclesComponent;
import org.junit.Assert;
import org.junit.Test;

public class TestVehiclesApp {

    @Test
    public void test_get_user(){
        VehiclesApp vehiclesApp = new VehiclesApp();
        VehiclesComponent component = DaggerVehiclesComponent.create();
        component.injectUser(vehiclesApp);
        Assert.assertNotNull(vehiclesApp.getUser());
    }

    @Test
    public void test_get_user_second(){
        VehiclesComponent component = DaggerVehiclesComponent.create();
        VehiclesApp vehiclesApp = component.injectUserSecond();
        Assert.assertNotNull(vehiclesApp.getUser());
    }

}
