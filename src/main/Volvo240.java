package main;
import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black);
        this.direction = new Perpendicular(0);
    }
    
    /**
     * Used to get current speedfactor
     * Depends on enginepower and trimfactor.
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Used to turn left
     */
    public void turnLeft(){
        this.direction.addAngle(3);
    }

    /**
     * Used to turn right
     */
    public void turnRight(){
        this.direction.addAngle(1);
    }
}