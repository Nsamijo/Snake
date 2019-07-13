package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Elements.Body;
import Logic.*;

public class Game extends JPanel implements KeyListener{
	
	private static final int DEFAULT_SCALE = 25;
	private Snake snake;
	private int scale;
	
	public Game(Snake snake) {
		this(snake, DEFAULT_SCALE);
	}
	
	Game(Snake snake, int scale){
		this.snake = snake;
		this.scale = scale;
		
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(25 * scale, 25 * scale));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 25 * Game.DEFAULT_SCALE, 25 * Game.DEFAULT_SCALE);
		
		Body last = snake.getHead();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//unused functions
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// unused function
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			this.snake.setDirections(Directions.UP);
			break;
		case KeyEvent.VK_DOWN:
			this.snake.setDirections(Directions.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			this.snake.setDirections(Directions.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			this.snake.setDirections(Directions.LEFT);
			break;
		}
		
	}

}
