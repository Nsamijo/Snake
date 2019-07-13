package Logic;
import java.awt.Color;
import java.awt.Point;

import Elements.*;

public class Snake {
	/*
	 * this class contains the linked list
	 * and certain recursive functions
	 */
	
	private Head head;
	private Directions dir = Directions.LEFT;
	
	public Food food = new Food(new Point(2, 6), Color.RED);
	
	public Snake(Head head) {
		this.head = head;
	}
	
	public Head getHead() {
		return head;
	}
	
	/*
	 * collision check
	 */
	public boolean bump(Block food) {
		/*check if the location is the same*/
		return (head.getLoc() == food.getLoc());
	}
	
	public boolean cannibalism(Body part) {
		if(part != null) {
			if(!bump(part)) {
				return cannibalism(part.getNext());
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	/*
	 * score check, loop through entire snake and count the block then multiply by 10
	 */
	public int getScore() {
		int length = 0;
		
		/*loop through the snake*/
		Body last = head;
		while(last.getNext() != null) {
			last = last.getNext();
			length++;
		}
		/*return score multiplied by ten*/
		return length * 10;
	}
}
