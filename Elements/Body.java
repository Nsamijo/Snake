package Elements;

import java.awt.Point;

public class Body extends Block{
	
	public Body prev;
	public Body next;
	private Point lp;

	Body(Point p, Body next, Body prev) {
		super(p);
		this.lp = p;
		this.next = next;
		this.prev = prev;
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
	public Point setLoc() {
		// TODO Auto-generated method stub
		return null;
	}

}
