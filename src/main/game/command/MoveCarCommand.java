package main.game.command;

import java.util.ArrayList;

import main.cars.Car;
import main.game.GameMap;

public class MoveCarCommand extends Command{

	public MoveCarCommand() {
		command = "MOVE_CARS";
		description = "Move cars =)";
	}
	
	@Override
	public void execute(GameMap gameMap, String command) {
		ArrayList<Car> cars = gameMap.getCars();
		if(cars != null && cars.size() != 0) {
			cars.forEach(car -> {
				car.gas(1);
				car.move();
			});
		}
	}

}
