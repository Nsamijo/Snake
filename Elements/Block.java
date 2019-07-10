package Elements;

import java.awt.Point;

abstract class Block {
	
	public Point lp;
	
	Block(Point p){
		this.lp = p;
	}
	
	public abstract void setX(int x);
	public abstract void setY(int y);
	public abstract Point setLoc();
	public abstract Point getLoc();
}
