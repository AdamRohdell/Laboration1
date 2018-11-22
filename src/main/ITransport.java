package main;

import main.cars.Car;

public interface ITransport {

     void raiseRamp();
     void lowerRamp();
     void loadCar(Car c);
     void unloadCar();

}
