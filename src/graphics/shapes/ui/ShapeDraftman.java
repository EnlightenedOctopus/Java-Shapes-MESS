package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;

public class ShapeDraftman implements ShapeVisitor {
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	private Graphics g;
	
	public ShapeDraftman(Graphics gr) {
		super();
		this.g=gr;
		this.DEFAULTCOLORATTRIBUTES=new ColorAttributes(true, true, Color.black, Color.white);
	}
	public void visitRectangle(SRectangle r) {
		ColorAttributes attri = (ColorAttributes)r.getAttributes("color");
		if (attri.filled) {
			g.setColor(attri.filledColor);
			g.fillRect((int)r.getLoc().getX(), (int)r.getLoc().getY(), r.getRect().width,r.getRect().height);
		}
		if (attri.stroked) {
			g.setColor(attri.strokedColor);
			g.drawRect((int)r.getLoc().getX(), (int)r.getLoc().getY(), r.getRect().width,r.getRect().height);
		}
	}
	public void visitCircle(SCircle c) {
		ColorAttributes attri = (ColorAttributes)c.getAttributes("color");
		if (attri.filled) {
			g.setColor(attri.filledColor);
			g.fillOval((int)c.getLoc().getX(), (int)c.getLoc().getY(), c.getRadius(), c.getRadius());
		}
		if (attri.stroked) {
			g.setColor(attri.strokedColor);
			g.drawOval((int)c.getLoc().getX(), (int)c.getLoc().getY(), c.getRadius(), c.getRadius());
		}
	}
	public void visitText(SText txt) {
		
	}
	public void visitCollection(SCollection c) {
		Iterator<Shape> i = c.iterator();
		while (i.hasNext()) {
			i.next().accept(this);
		}
	}
}
