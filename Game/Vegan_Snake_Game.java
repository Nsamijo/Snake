package Game;

import Graphics.Game;
import Logic.Snake;
import Elements.Body;
import Elements.Head;

import java.awt.Color;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Vegan_Snake_Game {
	static Timer timer = new Timer();
	static TimerTask task;
	
	public static void main(String[]args) {
		/*all the elements that have to be added*/
		Head head = new Head(new Point(4, 6), Color.DARK_GRAY);
		Snake snake = new Snake(head);
		Body body = new Body(new Point(3, 6), Color.GREEN);
		
		snake.growSnakeGrow(body);
		
		/*game*/
		JFrame frame = new JFrame();
		Game game = new Game(snake);
		frame.setTitle("Vegan Snake Game");
		frame.add(game);
		frame.addKeyListener(game);
		frame.pack();
		frame.setVisible(true);
		
		/*timer that redraws the snake, this way the snake can move*/
		task = new TimerTask() {

			@Override
			public void run() {
				snake.move();
				game.repaint();
			}
		};
		timer.schedule(task, 100, 90);
	}
}
