package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape{
	private int radius;
	private Point loc;
	
	public SCircle(Point p, int r) {
		this.loc=p;
		this.radius=r;
	}
	
	
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int i) {
		this.radius=i;
	}
	
	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point loc) {
		this.loc = loc;
		
	}

	@Override
	public void translate(int x, int y) {
		this.loc.translate(x, y);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(loc.x-radius,loc.y-radius,radius,radius);
	}

	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitCircle(this);
	}

}
