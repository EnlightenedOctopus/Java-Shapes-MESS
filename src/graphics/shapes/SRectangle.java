package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import visitor.ShapeVisitor;

public class SRectangle extends Shape{
	private Rectangle rect;
	
	public Rectangle getRect() {
		return this.rect;
	}

	@Override
	public Point getLoc() {
		return this.rect.getLocation();
	}

	@Override
	public void setLoc(Point loc) {
		this.rect.setLocation(loc);
	}

	@Override
	public void translate(int x, int y) {
		this.rect.translate(x, y);
	}

	@Override
	public Rectangle getBouds() {
		return rect.getBounds();
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
