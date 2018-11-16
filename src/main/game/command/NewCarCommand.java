package main.game.command;

import java.awt.Point;

import main.cars.Car;
import main.cars.Volvo240;
import main.game.GameMap;

public class NewCarCommand extends Command {
	
	public Car car;
	
	public NewCarCommand() {
		command = "NEW_CAR";
		description = "Adds a new car at set coordinates. X & Y, enter the following format 'NEW_CAR:X:Y'";
	}
	

	
	public void execute(GameMap gameMap, String command) {
		String[] parsedCommand = command.split(":");
		int x = Integer.parseInt(parsedCommand[1]);
		int y = Integer.parseInt(parsedCommand[2]);
		car = new Volvo240();
		car.point = new Point(x,y);
		gameMap.addCar(car);
	}

}
