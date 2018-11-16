package main.cars;

import main.flatbeds.Flatbed;
import main.Perpendicular;

import java.awt.*;

public class Scania extends Car{

    private Flatbed flatbed;

    public Scania(){
        super(2, 100, Color.blue);
        this.direction = new Perpendicular(0);
        flatbed = new Flatbed(0,70);
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    public Flatbed getFlatbed(){
        return this.flatbed;
    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
    @Override
    public void startEngine(){
        tipFlatbed(0);
        super.startEngine();
    }

    public void tipFlatbed(int angle){
        if (getCurrentSpeed() == 0){
            flatbed.setCurrentAngle(angle);
        }
    }
}
