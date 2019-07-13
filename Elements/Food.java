package Elements;

import java.awt.Color;
import java.awt.Point;

public class Food extends Block{
	/*
	 * food for snek
	 */
	private Point lp;
	private Color color;

	public Food(Point p, Color color) {
		super(p, color);
		this.lp = p;
		this.color = color;
	}

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

}
