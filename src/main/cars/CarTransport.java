package main.cars;

import java.awt.*;

public class CarTransport extends Car {

    public CarTransport() {
        super(2, 500, Color.green);
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


}
