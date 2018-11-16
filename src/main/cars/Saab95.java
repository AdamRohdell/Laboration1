package main.cars;
import main.Perpendicular;

import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, 125, Color.red);
	    turboOn = false;
	    this.direction = new Perpendicular(0);
    }

    /**
     * Used to enable turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Used to disable turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }
    
    /**
     * Used to get current speedfactor
     * Depends on whether turbo is activated or not and engine power.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
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

	public boolean getTurboStatus() {
		return turboOn;
	}
}