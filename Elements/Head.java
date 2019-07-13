package Elements;

import java.awt.Color;
import java.awt.Point;

public class Head extends Body {
	/*
	 * head of snek 
	 */
	
	private Point lp;
	final Color color;
	
	public Body next;
	
	Head(Point point, Color color) {
		super(point, color);
		this.lp = point;
		this.color = color;
	}

	@Override
	public void setX(int x) {
		this.lp.x = x;
	}

	@Override
	public void setY(int y) {
		this.lp.y = y;
	}

	@Override
	public Point getLoc() {
		return lp;
	}
	
}
