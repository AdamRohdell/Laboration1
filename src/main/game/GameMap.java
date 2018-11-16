package main.game;

import java.awt.Point;
import java.util.ArrayList;

import main.cars.Car;

public class GameMap {

	public int maxX;
	public int maxY;
	public ArrayList<Point> points;
	private ArrayList<Car> cars;
	
	public GameMap(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		points = new ArrayList<Point>();
		for(int i = 0; i <= maxY; i++) {
			for(int o = 0; o<= maxX; o++) {
				points.add(new Point(o,i));
			}
		}
		cars = new ArrayList<Car>();
	}
	
	
	public void addCar(Car car) {
		if(car.point.getX() > maxX) {
			car.point.x -= car.point.getX() - maxX;
		}
		if(car.point.getY() > maxY) {
			car.point.y -= car.point.getY() - maxY;
		}
		cars.add(car);
	}
	
	public ArrayList<Car> getCars(){
		return cars;
	}
	public String getSymbol(Point p) {
		for(Car car : cars) {
			if(car.point.equals(p)) {
				System.out.println("same");
				return "C";
			}
		}
		return "-";
	}
}
