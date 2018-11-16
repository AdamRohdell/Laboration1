package main.flatbeds;

public class Flatbed {

    protected int currentAngle,minAngle,maxAngle;


    public Flatbed(int minAngle, int maxAngle){
        this.currentAngle = minAngle;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }

    public int getCurrentAngle(){
        return this.currentAngle;
    }

    public void setCurrentAngle(int angle){
        if (angle >= minAngle && angle <= maxAngle){
            this.currentAngle = angle;
        }
    }
}
