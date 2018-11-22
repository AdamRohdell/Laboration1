package main.cars;

import main.flatbeds.Ramp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarTransport extends Car {

    private int maxCars = 10;
    private Stack<Car> cars = new Stack<Car>();
    private Ramp ramp = new Ramp(0, 1);

    public CarTransport() {
        super(2, 500, Color.green, Type.TRUCK);
    }

    @Override
    public void startEngine(){
        raiseRamp();
        super.startEngine();
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    @Override
    public void move(){
        super.move();
        for (Car c : cars){
            c.point = point;
        }
    }

    public void loadCar(Car c){
        if (c != this && cars.size() <= maxCars && (c.point.x - point.x <= 1) && (c.point.y - point.y <= 1)) {
          cars.push(c);
        }
    }

    public void unloadCar(){
        Car c =  cars.pop();
        c.point.x = point.x - 1;
    }

    public void lowerRamp(){
        if (getCurrentSpeed() == 0){
            ramp.lowerRamp();
        }
    }

    public void raiseRamp(){
        ramp.raiseRamp();
    }
}
