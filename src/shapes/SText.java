package shapes;

import java.awt.Point;
import java.awt.Rectangle;

import visitor.ShapeVisitor;

public class SText extends Shape{
	private String text;
	private Point loc;
	
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
	public Rectangle getBouds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
