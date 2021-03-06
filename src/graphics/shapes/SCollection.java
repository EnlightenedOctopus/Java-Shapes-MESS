package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.attributes.SelectionAttributes;


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
		for (Iterator<Shape> i = this.iterator(); i.hasNext();) {
			i.next().translate(x,y);
		}
	}
	@Override
	public Rectangle getBounds() {
		Rectangle rect = new Rectangle(this.shapes.get(0).getBounds());
		for (Iterator<Shape> i = this.iterator(); i.hasNext();) {
			rect.add(i.next().getBounds());
		}
		return rect;
	}
	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCollection(this);
	}
	//extension buttons
	public void deleteShape(Object s) {
		this.shapes.remove(s);
	}
	//
	@Override
	public SCollection copy() {
		SCollection colec=new SCollection();
		for(Iterator<Shape> i = this.iterator(); i.hasNext();){
			colec.add(i.next().copy());
		}
		colec.addAttributes(new SelectionAttributes());
		return colec;
	}
}
