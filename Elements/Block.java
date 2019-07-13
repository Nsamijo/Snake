package Elements;

import java.awt.Color;
import java.awt.Point;

public abstract class Block {
	/*
	 * abstract class for snake setup
	 */
	
	public Point lp;
	final Color color;
	
	Block(Point p, Color c){
		this.lp = p;
		this.color = c;
	}
	
	/*
	 * getters and setters
	 * very important for frame drawing
	 */
	public abstract void setCol(Color color);
	public abstract void setLoc(Point point);
	public abstract Color getColor();
	public abstract Point getLoc();
}
