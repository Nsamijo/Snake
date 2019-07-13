package Elements;

import java.awt.Color;
import java.awt.Point;

public class Head extends Body {
	/*
	 * head of snek 
	 */
	
	private Point lp;
	private Color color;
	
	public Body next;
	
	public Head(Point point, Color color) {
		super(point, color);
		this.lp = point;
		this.color = color;
	}
	
	/*
	 * getters and setters for color, location and next block
	 * no previous block since this is the head, first in the list
	 */
	
	public void setCol(Color color) {
		this.color = color;
	}
		
	public void setLoc(Point point) {
		this.lp = point;
	}
	
	public Color getCol() {
		return this.color;
	}
	
	public Point getLoc() {
		return this.lp;
	}
	
	/*
	 * getters and setters for the linkedlist
	 */
	
	public void setNext(Body next) {
		this.next = next;
	}
	
	public Body getNext() {
		return next;
	}

}
