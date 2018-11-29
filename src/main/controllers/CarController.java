package main.controllers;

import main.vehicles.cars.*;
import main.vehicles.transport.Scania;
import main.views.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        Saab95 saab = new Saab95();
        saab.point.setLocation(0,100);
        cc.cars.add(saab);

        Scania scania = new Scania();
        scania.point.setLocation(0,200);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                System.out.println(frame.getWidth());
                car.move();
                int x = (int) Math.round(car.point.x);
                int y = (int) Math.round(car.point.y);
                if (calculateIfOutOfBounds(car)) {
                    changeDirection(car);
                }

                // repaint() calls the paintComponent method of the panel
                frame.getDrawPanel().repaint();
            }
        }
    }

    private void changeDirection(Car c){
        c.getDirection().addAngle(2);
    }


    private boolean calculateIfOutOfBounds(Car car){
        System.out.println(frame.getWidth());
        int carWidth = frame.getDrawPanel().getImage(car).getWidth();
        if (car.point.x + carWidth>= frame.getWidth() || car.point.x < 0){
            return true;
        }
        return false;
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    public void brake(int amount){
        double brake = (double) amount / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }

    public void startCars(){
        for (Car car : cars){
            car.startEngine();
        }
    }

    public void stopCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }

    public ArrayList<Car> getCars(){
        return cars;
    }
}