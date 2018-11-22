package main.cars;

import main.flatbeds.Ramp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarTransport extends Car {

    private Stack<Car> cars = new Stack<Car>();
    private Ramp ramp = new Ramp(0, 1);

    public CarTransport() {
        super(2, 500, Color.green);
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
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    public void loadCar(Car c){
        cars.push(c);
    }

    public Car unloadCar(){
        return cars.pop();
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
