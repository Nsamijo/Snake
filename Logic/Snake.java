package Logic;
import java.awt.Color;
import java.awt.Point;

import Elements.*;

public class Snake {
	/*
	 * this class contains the linked list
	 * and the functions to:
	 * -check the length
	 * -find it the snakes tail
	 * -check for cannibalism
	 */
	
	private Head head;
	private Directions dir = Directions.LEFT;
	private final int DEFAULT_SCALE = 25;
	
	public Food food = new Food(new Point(2, 6), Color.RED);
	
	/*give the snake a head*/
	public Snake(Head head) {
		this.head = head;
	}
	/*return the head of snake*/
	public Head getHead() {
		return head;
	}
	
	/*function to change position head of snake*/
	void setHead(int x, int y) {
		this.head.setLoc(new Point(x, y));
	}
	
	/*function to get the tail of the snake*/
	public Body findTail() {
		return findTail(this.getHead());
	}
	/*recursive function to find the rail*/
	Body findTail(Body head) {
		if(head.getNext() != null) {
			return findTail(head.getNext());
		}else {
			return head;
		}
	}
	
	/* collision check function*/
	boolean bump(Block food) {
		/*check if the location is the same*/
		return (head.getLoc() == food.getLoc());
	}
	
	boolean eaten() {
		return bump(food);
	}
	
	/*function to check if there is cannibalism */
	public boolean cannibalism() {
		return cannibalism(this.getHead());
	}
	/*recursive function for cannibalism check*/
	boolean cannibalism(Body head) {
		if(head != null) {
			if(!bump(head)) {
				return cannibalism(head.getNext());
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	/*recursive function for score/length check*/
	public int getScore() {
		return this.getScore(getHead()) -2 * 10;
	}
	/*recursive function for score/length check*/
	int getScore(Body head) {
		if(head.getNext() != null) {
			return getScore(head.getNext()) + 1;
		}else {
			return 1;
		}
	}
	
	/*makes the snake grow and if the snake grows he gets longer*/
	public void growSnakeGrow(Body bigger) {
		Body last = this.findTail();
		last.setNext(bigger);
		bigger.setPrev(last);
	}
	
	/*this function made me type less in the setDirections function and also sets the direction*/
	void changeDir(Directions dir) {
		this.dir = dir;
	}
	/*change the direction of the snake*/
	public void setDirections(Directions dir) {
		switch(dir) {
		case UP:
			/*this denies us from making a 180 turn and commit cannibalism*/
			if(this.dir != Directions.DOWN) {
				this.changeDir(dir);
			break;
			}
		case DOWN:
			if(this.dir != Directions.UP) {
				this.changeDir(dir);
			break;
			}
		case RIGHT:
			if(this.dir != Directions.LEFT) {
				this.changeDir(dir);
			break;
			}
		case LEFT:
			if(this.dir != Directions.RIGHT) {
				this.changeDir(dir);
			break;
			}
		
		}
	}
	
	boolean bumpWall() {
		return (head.getLoc().x < 0 || head.getLoc().x > DEFAULT_SCALE - 1 || head.getLoc().y < 0 || head.getLoc().y > DEFAULT_SCALE - 1) ;
	}
	
	public void move() {
		this.move(this.dir);
	}
	
	
	/*the muscles of the snake, this allows it to move*/
	void move(Directions dir) {
		Body last = this.findTail();
		Point loc = last.getLoc();
		
		while(last.getPrev() != null) {
			last.setLoc(last.getPrev().getLoc());
			last = last.getPrev();
		}
		/*this way we can move the snake*/
		int x = head.getLoc().x;
		int y = head.getLoc().y;
		
		switch(dir) {
		case UP:
			y -= 1;
			this.setHead(x, y);
			this.changeDir(dir);
			break;
		case DOWN:
			y += 1;
			this.setHead(x, y);
			this.setDirections(dir);
			break;
		case RIGHT:
			x += 1;
			this.setHead(x, y);
			this.setDirections(dir);
			break;
		case LEFT:
			x -= 1;
			this.setHead(x, y);
			this.setDirections(dir);
		}
		
		if(this.cannibalism()) {
			System.exit(0);
		}
		
		if(this.bumpWall()) {
			System.exit(0);
		}
		
		if(this.eaten()) {
			this.growSnakeGrow(new Body(loc, Color.GREEN));
		}
	}
	
}
