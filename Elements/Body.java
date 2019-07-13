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
	final Color color;

	Body(Point p, Color color) {
		super(p, color);
		this.lp = p;
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
		return this.lp;
	}

	@Override
	public void setLoc(Point o) {
		this.lp = o;
	}

}
