package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
		
		/*draw entire snake except tail*/
		while(last.getNext() != null) {
			g.setColor(last.getColor());
			g.fillRect(last.getLoc().x * scale, last.getLoc().y * scale, scale, scale);
			last = last.getNext();
		}
		/*draw the snakes tail*/
		g.setColor(last.getColor());
		g.fillRect(last.getLoc().x * scale, last.getLoc().y * scale, scale, scale);
		
		/*draw food*/
		g.setColor(snake.food.getColor());
		g.fillRect(snake.food.getLoc().x, snake.food.getLoc().y, scale, scale);
		
		g.setColor(Color.BLACK);
		Font font = new Font("Terminal", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Sccore: " + snake.getScore(), 25, 25);
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
