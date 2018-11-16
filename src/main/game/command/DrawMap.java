package main.game.command;

import java.awt.Graphics;
import java.awt.Point;

import main.game.GameMap;

public class DrawMap{


	public void paint(GameMap gameMap, Graphics g) {
		String map = "";
		int startX = 50;
		int startY = 50;
		
		for(Point point : gameMap.points) {
			
			g.drawString(gameMap.getSymbol(point), startX + (int) point.getX() * 5, startY + (int) point.getY() * 5);
		}	
	}

}
