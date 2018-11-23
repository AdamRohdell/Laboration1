package main.vehicles.transport;

import main.vehicles.Vehicle;
import main.flatbeds.Ramp;
import main.vehicles.transport.Transport;

public class CarFerry extends Vehicle {

    private Ramp ramp = new Ramp(0, 1);
    private Transport transport;

    public CarFerry(){
        transport = new Transport(50, true ,this.point, this.ramp);
    }

    /**
     * Method to raise ramp
     */
    public void raiseRamp(){
        ramp.raiseRamp();
    }
    /**
     * Method to lower the ramp
     */
    public void lowerRamp() {
        if (currentSpeed == 0){
            ramp.lowerRamp();
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
