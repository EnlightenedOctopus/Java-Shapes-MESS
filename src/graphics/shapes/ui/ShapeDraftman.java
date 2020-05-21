package graphics.shapes.ui;

import java.awt.Color;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;

public class ShapeDraftman implements ShapeVisitor {
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	
	public ShapeDraftman() {
		super();
		this.DEFAULTCOLORATTRIBUTES=new ColorAttributes(true, true, Color.black, Color.white);
	}
	public void visitRectangle(SRectangle r) {
		
	}
	public void visitCircle(SCircle c) {
		
	}
	public void visitText(SText txt) {
		
	}
	public void visitCollection(SCollection c) {
		
	}	
}
