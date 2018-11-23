package main.vehicles.transport;

import java.util.ArrayList;
import java.util.List;
import main.flatbeds.Ramp;
import main.vehicles.cars.Car;

import java.awt.*;


public class Transport {

    private int maxCars;
    private boolean unloadFirstCar = true;
    private Point point;
    private Ramp ramp;
    private List<Car> cars = new ArrayList<Car>();


    public Transport(int maxCars, boolean unloadFirstCar, Point point, Ramp ramp){
        this.maxCars = maxCars;
        this.unloadFirstCar = unloadFirstCar;
    }
    /**
     * Method to load the last car that was loaded. The car that will be loaded has to be within a distance of 1 unit.
     * @param c that shall be loaded
     */
    public void loadCar(Car c){
        if (c.getType() != Car.Type.TRUCK && cars.size() <= maxCars && (c.point.x - point.x <= 1) && (c.point.y - point.y <= 1) && ramp.getCurrentAngle() == 0) {
            cars.add(c);
        }
    }

    public void moveCars(){
        for (Car c : cars){
            c.point = point;
        }
    }

    /**
     * Method to unload car
     * Will not work if ramp is raised.
     */
    public void unloadCar(){
        int index = cars.size() - 1;
        if(unloadFirstCar){
            index = 0;
        }
        if (ramp.getCurrentAngle() == 0){
            Car c =  cars.get(index);
            c.point.x = point.x - 1;
        }
    }
}
