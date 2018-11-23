package main.vehicles;

import main.Direction;
import main.IMoveable;

import java.awt.*;

public abstract class Vehicle implements IMoveable {
    protected double enginePower; // Engine power of the vehicle
    protected double currentSpeed; // Current speed of the vehicle
    protected Direction direction;
    public Point point;

    /**
     * @return current speed of vehicle
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Used to start the engine
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Used to stop the engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    /**
     * Method that returns current direction of the car
     * @return direction
     */
    public Direction getDirection() {
        return this.direction;
    }


    public void move() {
        point = direction.move(point, currentSpeed);
    }

    public void turnLeft(){
        direction.turnLeft();
    }

    public void turnRight(){
        direction.turnRight();
    }

    public abstract void gas(double amount);
    public abstract void brake(double amount);

}
