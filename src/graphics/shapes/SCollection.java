package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class SCollection extends Shape {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point loc;
	public Iterator<Shape> iterator() {
		return this.shapes.iterator();
	}
	public void add(Shape shape) {
		this.shapes.add(shape);
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
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCollection(this);
		
	}
}
