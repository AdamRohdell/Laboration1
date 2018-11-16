package main.game.command;

import main.game.GameMap;

public abstract class Command{
	
	public String command;
	public String description;
	

	public abstract void execute(GameMap gameMap, String command);

}
