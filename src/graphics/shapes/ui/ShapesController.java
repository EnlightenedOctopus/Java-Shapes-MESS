package graphics.shapes.ui;

import java.awt.Point;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller{
	public ShapesController(Object model) {
		super(model);
	}
	
	public Shape whereIs(int x, int y) {
		
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			if(s.getBounds().contains(x,y)) {
				return s;
			}
		}
		return null;
	}
	
	public void selectShape(Shape s) {
		((SelectionAttributes) s.getAttributes("selection")).select();
	}
	
	public void translateSelection(int x, int y) {
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			i.next().translate(x, y);
		}
		super.getView().repaint();
	}
	
	public SCollection getSelected() {
		SCollection selected = new SCollection();
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			if(s.getAttributes("selection") != null) {
				if(((SelectionAttributes) s.getAttributes("selection")).isSelected()) {
					selected.add(s);
				}
			}
			
		}
		return selected;
	}
	
	
	

}
