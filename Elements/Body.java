package Elements;

import java.awt.Color;
import java.awt.Point;

public class Body extends Block{
	/*
	 * body of snek
	 */
	
	public Body prev;
	public Body next;
	
	private Point lp;
	private Color color;

	Body(Point p, Color color) {
		super(p, color);
		this.lp = p;
		this.color = color;
	}
	
	/*
	 * getters and setters
	 */

	@Override
	public void setCol(Color color) {
		this.color = color;
	}

	@Override
	public void setLoc(Point point) {
		this.lp = point;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Point getLoc() {
		return this.lp;
	}
	/*
	 * getters and setters for the linkedlist
	 */
	
	public void setNext(Body next) {
		this.next = next;
	}
	
	public void setPrev(Body prev) {
		this.prev = prev;
	}
	
	public Body getNext() {
		return this.next;
	}
	
	public Body getPrev() {
		return this.prev;
	}

}
