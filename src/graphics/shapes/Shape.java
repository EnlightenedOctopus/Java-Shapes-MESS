package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;

abstract public class Shape {
	private Map<String, Attributes> attributes = new TreeMap<String, Attributes>();
	
	public void addAttributes(Attributes attr) {
		this.attributes.put(attr.getId(), attr);
	}
	
	public Attributes getAttributes(String attr) {
		return this.attributes.get(attr);
	}
	abstract public Point getLoc();
	abstract public void setLoc(Point loc);
	abstract public void translate(int x, int y);
	abstract public Rectangle getBounds();
	abstract public void accept(ShapeVisitor visitor);
	abstract public Shape copy();
}
