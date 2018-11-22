package main.cars;

import java.util.List;
import java.awt.*;

public class CarTransport extends Car {

    public CarTransport() {
        super(2, 500, Color.green, Type.TRUCK);
    }

    @Override
    public double speedFactor() {
        return 0;
    }

}
