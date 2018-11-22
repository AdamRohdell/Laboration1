package main;

import main.cars.Car;
import main.cars.Vehicle;
import main.flatbeds.Ramp;

import java.util.ArrayList;
import java.util.List;

public class CarFerry extends Vehicle implements ITransport {

    private int maxCars = 50;
    private List<Car> cars = new ArrayList<Car>();
    private Ramp ramp = new Ramp(0, 1);

    @Override
    public void raiseRamp() {
        ramp.raiseRamp();
    }

    @Override
    public void lowerRamp() {
        if (currentSpeed == 0){
            ramp.lowerRamp();
        }
    }

    @Override
    public void loadCar(Car c) {
        if (cars.size() <= maxCars && (c.point.x - point.x <= 1) && (c.point.y - point.y <= 1) && ramp.getCurrentAngle() == 0) {
            cars.add(c);
        }
    }

    @Override
    public void unloadCar() {
        if (ramp.getCurrentAngle() == 0){
            Car c =  cars.remove(0);
            c.point.x = point.x - 1;
        }
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + 1 * amount;
        if (currentSpeed > enginePower) { // currentSpeed can never exceed enginePower. Quick fix. Can probably be done
            // in a better way
            currentSpeed = enginePower;
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() -  1 * amount;
        if (currentSpeed < 0) { // currentSpeed can never be less then 0
            currentSpeed = 0;
        }
    }

    @Override
    public void gas(double amount) {
        if (currentSpeed > 0){
            if (amount <=1 && amount > 0) { //no negative values are accepted.
                incrementSpeed(amount);
            }
        }
    }

    @Override
    public void brake(double amount) {
        if (amount <=1 && amount > 0) { //no negative values are accepted.
            decrementSpeed(amount);
        }
    }
}
