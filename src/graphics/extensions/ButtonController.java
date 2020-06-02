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
	public int DEFAULTWIDTHBUTTON=40;
	
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
	
	public Shape getoneshapeselected(SCollection c) {
		for (Iterator<Shape> i = c.iterator(); i.hasNext();) {
			Shape s = i.next();
			if(((SelectionAttributes) s.getAttributes("selection")).isSelected()) {
				return s;
			}
		}
		return null;
	}
	
	public void colorshapesinSCollection(SCollection c,ColorAttributes attri) {
		for (Iterator<Shape> i = c.iterator(); i.hasNext();) {
			Shape s = i.next();
			if (s instanceof SCollection) {
				this.colorshapesinSCollection((SCollection)s,attri);
			}
			else {
				if (s.getAttributes("color")!=null) {
					((ColorAttributes)s.getAttributes("color")).filled=attri.filled;
					((ColorAttributes)s.getAttributes("color")).stroked=attri.stroked;
					((ColorAttributes)s.getAttributes("color")).filledColor=attri.filledColor;
					((ColorAttributes)s.getAttributes("color")).strokedColor=attri.strokedColor;
				}
				else {
					s.addAttributes(attri);
				}
			}
				
		}
	}
	
	public void editColor(ShapesView sv) {
		SCollection mod = (SCollection)sv.getModel();
		Shape s = getoneshapeselected(mod);
		if (s!=null) {
			if (s.getAttributes("color")!=null) {
				new WindowEditColor((ColorAttributes)s.getAttributes("color"),sv,this);
			}
			else {
				s.addAttributes(new ColorAttributes(true,true,Color.WHITE,Color.BLACK));
				new WindowEditColor((ColorAttributes)s.getAttributes("color"),sv,this);
			}
		}
		else {
			System.out.println("Il faut sélectionner au moins un Shape.");
		}
	}
	
	public ButtonController(MouseEvent e, ShapesView sv) {
		ShapesController c = (ShapesController)sv.getController();
		if (e.getPoint().x>sv.getBounds().width-(DEFAULTWIDTHBUTTON/2)-12) {
			if (e.getPoint().x<sv.getBounds().width-(DEFAULTWIDTHBUTTON/2)+13) {
				if (e.getPoint().y<DEFAULTWIDTHBUTTON+25 && e.getPoint().y>DEFAULTWIDTHBUTTON) {
					new WindowNewShape(sv,0);
					c.windowOpen=true;
				}
				if (e.getPoint().y<2*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>2*DEFAULTWIDTHBUTTON) {
					new WindowNewShape(sv,1);
					c.windowOpen=true;
				}
				if (e.getPoint().y<3*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>3*DEFAULTWIDTHBUTTON) {
					new WindowNewShape(sv,2);
					c.windowOpen=true;
				}
				if (e.getPoint().y<4*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>4*DEFAULTWIDTHBUTTON) {
					this.deleteSelected(sv);
				}
				if (e.getPoint().y<5*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>5*DEFAULTWIDTHBUTTON) {
					this.editColor(sv);
					c.windowOpen=true;
				}
				if (e.getPoint().y<6*DEFAULTWIDTHBUTTON+25 && e.getPoint().y>6*DEFAULTWIDTHBUTTON) {
					if (c.textMod) {
						c.textMod=false;
					}
					else {
						c.textMod=true;
					}
				}
			}
		}
	}
}
