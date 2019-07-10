package Elements;

import java.awt.Point;

public class Food extends Block{
	private Point lp;

	Food(Point p) {
		super(p);
		this.lp = p;
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
	
}
