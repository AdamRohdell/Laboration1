package main.game;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import main.game.command.Command;
import main.game.command.DrawMap;
import main.game.command.MoveCarCommand;
import main.game.command.NewCarCommand;

public class CarGame extends Component{
	private GameMap gameMap;
	private ArrayList<Command> commands;
	boolean run = true;
	private Scanner sc;
	JFrame frame;
	DrawMap drawMap;
	
	
	
	public static void main(String[] args) {
		new CarGame();
	}
	
	CarGame(){
		frame = new JFrame("Game");
		frame.setSize(780,580);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		sc = new Scanner(System.in);
		initializeCommands();
		gameMap = new GameMap(60,5);
		drawMap = new DrawMap();
		gameLoop();
	
	}

	private void initializeCommands() {
		this.commands = new ArrayList<Command>();
		//commands.add(new DrawMap());
		commands.add(new NewCarCommand());
		commands.add(new MoveCarCommand());
		//commands.add(new Command("NEW_VOLVO_X_Y", "Adding a new Volvo ad set coordinates"));
		//commands.add(new Command("QUIT", "For exisiting the game"));
	}

	private void gameLoop() {
		String command;
		while(run) {
			printCommands();
			System.out.print("Enter your command:");
			command = sc.nextLine();
			executeCommand(command);
			
		}
	}

	private void executeCommand(String command) {
		String[] parsedCommand = command.split(":");
	
		if(command.toLowerCase().equals("quit")) {
			System.out.println("quitting....");
			run = false;
			return;
		}
		
		for(Command realCommand : commands) {
			if(realCommand.command.toLowerCase().equals(parsedCommand[0].toLowerCase())) {
				realCommand.execute(gameMap, command);
			}
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap.paint(gameMap, g);
	}

	private void printCommands() {
		System.out.println("List of commands..");
		for(Command command : commands) {
			System.out.println(command.command + " --- " + command.description);
		}
	}

}
