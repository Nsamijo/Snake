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
	public boolean bump(Block food) {
		/*check if the location is the same*/
		return (head.getLoc() == food.getLoc());
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
	
	/*
	 * recursive function for score/length check
	 */
	public int getScore() {
		return this.getScore(getHead());
	}
	/*recursive fuunction for score/length check*/
	int getScore(Body head) {
		if(head.getNext() != null) {
			return getScore(head.getNext()) + 1;
		}else {
			return 1;
		}
	}
	
}
