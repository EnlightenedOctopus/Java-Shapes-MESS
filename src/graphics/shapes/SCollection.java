package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Iterator;

import visitor.ShapeVisitor;

public class SCollection extends Shape {
	private Collection<Shape> shapes;
	private Point loc;
	public Iterator<Shape> iterator() {
		return null;
	}
	public void add(Shape shape) {
		
	}
	@Override
	public Point getLoc() {		
		return this.loc;
	}
	@Override
	public void setLoc(Point loc) {
		this.loc=loc;
		
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
