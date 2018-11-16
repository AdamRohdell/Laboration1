package main;

import java.awt.*;

public abstract class Car implements IMoveable {

	private int nrDoors; // Number of doors on the car
	protected double enginePower; // Engine power of the car
	private double currentSpeed; // The current speed of the car
	private Color color; // Color of the car
	public Point point;
	protected Direction direction;

	/**
	 * @param nrDoors
	 * @param enginePower enter in horsepower
	 * @param color
	 */
	public Car(int nrDoors, double enginePower, Color color) {
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		stopEngine();
	}

	/**
	 * @return current speed of car
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * @return color of car
	 */
	public Color getColor() {
		return color;
	}

	public void setColor(Color clr) {
		color = clr;
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

	/**
	 * Abstract method that has to be overriden by new classes that extends car.
	 * Each car should have its unique method to return speedfactor.
	 * @return current speedfactor.
	 */
	public abstract double speedFactor();

	/**
	 * Used to increment current speed
	 * @param amount 
	 */
	private void incrementSpeed(double amount) {
		currentSpeed = getCurrentSpeed() + speedFactor() * amount;
		if (currentSpeed > enginePower) { // currentSpeed can never exceed enginePower. Quick fix. Can probably be done
											// in a better way
			currentSpeed = enginePower;
		}
	}

	/**
	 * Used to decrement current speed
	 * 
	 * @param amount
	 */
	private void decrementSpeed(double amount) {
		currentSpeed = getCurrentSpeed() - speedFactor() * amount;
		if (currentSpeed < 0) { // currentSpeed can never be less then 0
			currentSpeed = 0;
		}
	}

	/**
	 * Method that returns current direction of the car
	 * @return direction
	 */
	public Direction getDirection() {
		return this.direction;
	}



	/**
	 * Shall be interpreted as the gas pedal of the car
	 * Check if the engine is on before allowing gas.
	 *  Do nothing if amount > 1 or amount < 0
	 * @param amount represents how deep down the pedal is pressed down
	 */
	public void gas(double amount) {
		if (currentSpeed > 0){
			if (amount <=1 && amount > 0) { //no negative values are accepted.
				incrementSpeed(amount);
			}
		}
	}
	/**
	 * Shall be interpreted as the brake pedal of the car
	 * Do nothing if amount > 1 or amount < 0
	 * @param amount represents how deep down the pedal is pressed down
	 */
	public void brake(double amount) {
		if (amount <=1 && amount > 0) { //no negative values are accepted.
			decrementSpeed(amount);
		}
	}
	
	
	public void move() {
		point = direction.move(point, currentSpeed);
	}

	public int getNrDoors() {
		return nrDoors;
	}
}
