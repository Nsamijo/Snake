package Elements;

import java.awt.Point;

public class Head extends Block {
	
	private Point lp;
	public Body next;
	
	Head(Point p, Body next) {
		super(p);
		this.lp = p;
		this.next = next;
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
