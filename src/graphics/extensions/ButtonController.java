package graphics.extensions;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.ShapesController;
import graphics.shapes.ui.ShapesView;

public class ButtonController {
	private int DEFAULTWIDTHBUTTON=50;
	
	public void newSCircle(ShapesView sv) {
		SCollection mod = (SCollection)sv.getModel();
		SCircle c = new SCircle(new Point(150,150),20);
		c.addAttributes(new ColorAttributes(true,true,Color.WHITE,Color.DARK_GRAY));
		c.addAttributes(new SelectionAttributes());
		mod.add(c);
	}
	
	public void newSRect(ShapesView sv) {
		SCollection mod = (SCollection)sv.getModel();
		SRectangle r = new SRectangle(new Point(150,150),20,20);
		r.addAttributes(new ColorAttributes(true,true,Color.WHITE,Color.DARK_GRAY));
		r.addAttributes(new SelectionAttributes());
		mod.add(r);
	}
	
	public void newSText(ShapesView sv) {
		SCollection mod = (SCollection)sv.getModel();
		SText t = new SText(new Point(150,150),"Ajout");
		t.addAttributes(new ColorAttributes(true,true,Color.WHITE,Color.DARK_GRAY));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		mod.add(t);
	}
	
	public void deleteSelected(ShapesView sv) {
		SCollection mod = (SCollection)sv.getModel();
		SCollection del = new SCollection();
		for (Iterator<Shape> i = mod.iterator(); i.hasNext();) {
			Shape s = i.next();
			if(((SelectionAttributes) s.getAttributes("selection")).isSelected()) {
				del.add(s);
			}
		}
		for (Iterator<Shape> i = del.iterator(); i.hasNext();) {
			Shape s = i.next();
			mod.deleteShape(s);
		}
	}
	
	public ButtonController(MouseEvent e, ShapesView sv) {
		if (e.getPoint().x>sv.getBounds().width-DEFAULTWIDTHBUTTON+12) {
			if (e.getPoint().x<sv.getBounds().width-DEFAULTWIDTHBUTTON+37) {
				if (e.getPoint().y<DEFAULTWIDTHBUTTON+25 && e.getPoint().y>DEFAULTWIDTHBUTTON) {
					this.newSCircle(sv);
				}
				if (e.getPoint().y<2*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>2*DEFAULTWIDTHBUTTON) {
					this.newSRect(sv);
				}
				if (e.getPoint().y<3*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>3*DEFAULTWIDTHBUTTON) {
					this.newSText(sv);
				}
				if (e.getPoint().y<4*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>4*DEFAULTWIDTHBUTTON) {
					this.deleteSelected(sv);
				}
			}
		}
	}
}
