package Elements;

import java.awt.Color;
import java.awt.Point;

abstract class Block {
	/*
	 * abstract class for snake setup
	 */
	
	public Point lp;
	final Color color;
	
	Block(Point p, Color c){
		this.lp = p;
		this.color = c;
	}
	
	public abstract void setX(int x);
	public abstract void setY(int y);
	public abstract void setLoc(Point o);
	public abstract Point getLoc();
}
