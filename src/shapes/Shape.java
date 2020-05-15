package shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import attributes.Attributes;
import visitor.ShapeVisitor;

abstract public class Shape {
	private Map<String, Attributes> attributes;
	public void addAttributes(Attributes attr) {
		this.attributes.put(attr.getId(), attr);
	}
	public Attributes getAttributes(String attr) {
		return this.attributes.get(attr);
	}
	abstract public Point getLoc();
	abstract public void setLoc(Point loc);
	abstract public void translate(int x, int y);
	abstract public Rectangle getBouds();
	abstract public void accept(ShapeVisitor visitor);
}
