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
		Head head = new Head(new Point(4, 6), Color.DARK_GRAY);
		
		Snake snake = new Snake(head);
		Body body = new Body(new Point(3, 6), Color.GREEN);
		
		snake.growSnakeGrow(body);
		
		/*game*/
		JFrame frame = new JFrame();
		Game game = new Game(snake);
		frame.add(game);
		frame.addKeyListener(game);
		frame.pack();
		frame.setVisible(true);
		
		task = new TimerTask() {

			@Override
			public void run() {
				snake.move();
				game.repaint();
			}
		};
		timer.scheduleAtFixedRate(task, 100, 100);
	}
}
