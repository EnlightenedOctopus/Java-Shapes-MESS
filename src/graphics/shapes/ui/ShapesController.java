package graphics.shapes.ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.extensions.ButtonController;
import graphics.shapes.SCollection;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller{
	Point mouseLoc;
    private boolean shiftDown;
    private char lastTyped;
    private char lastPressed;
    private char lastRealesed;
    public boolean textMod=false;
    public boolean colorMod=false;

	
	public ShapesController(Object model) {
		super(model);
	}
	
	public boolean getTargetSCollection(int x, int y, SCollection c) {
		for (Iterator<Shape> i = c.iterator(); i.hasNext();) {
			Shape s = i.next();
			if (s instanceof SCollection) {
				if (getTargetSCollection(x,y,(SCollection)s)) {
					return true;
				}
			}
			if (s.getBounds().contains(x,y)) {
				return true;
			}
		}
		return false;
	}
	
	public Shape getTarget(int x, int y) {
		Shape selected = null;
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			if (s instanceof SCollection) {
				if (getTargetSCollection(x,y,(SCollection)s)){
					selected = s;
				}
			}
			else {
				if(s.getBounds().contains(x,y)) {
					selected = s;
				}
			}
			
			
		}
		return selected;
	}
	
	public void selectShape(Shape s) {
		((SelectionAttributes) s.getAttributes("selection")).select();
	}
	
	public void unselectShape(Shape s) {
		((SelectionAttributes) s.getAttributes("selection")).unselect();
	}
	
	
	public void toggleSelectShape(Shape s) {
		((SelectionAttributes) s.getAttributes("selection")).toggleSelection();
	}
	
	public void translateSelection(int x, int y) {
		for (Iterator<Shape> i = this.getSelected().iterator(); i.hasNext();) {
			i.next().translate(x, y);
		}
		super.getView().repaint();
	}
	
	public SCollection getSelected() {
		SCollection selected = new SCollection();
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			if(((SelectionAttributes) s.getAttributes("selection")).isSelected()) {
				selected.add(s);
			}
			
		}
		return selected;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//extension buttons
		ButtonController bc = new ButtonController(e,(ShapesView)this.getView());
		//end
		if(e.getPoint().x < this.getView().getWidth()-bc.DEFAULTWIDTHBUTTON) {
		
			
			if(this.getTarget(e.getPoint().x, e.getPoint().y) != null) {
				if(!e.isShiftDown()) {
					for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
						((SelectionAttributes) i.next().getAttributes("selection")).unselect();
					}
				}
				this.toggleSelectShape(this.getTarget(e.getPoint().x, e.getPoint().y));
			}
			else {
				for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
					Shape s = i.next();
					this.unselectShape(s);
				}
			}
		}
		this.getView().repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (!this.colorMod) {
			getSelected().translate(e.getPoint().x-this.mouseLoc.x, e.getPoint().y-this.mouseLoc.y);
			this.mouseLoc=e.getPoint();
		}
		this.getView().repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.mouseLoc=e.getPoint();
	}
	public void mouseReleased(MouseEvent e) {
		this.colorMod=false;
	}

	@Override
    public void keyTyped(KeyEvent evt)
    {
        if (evt.getID() == KeyEvent.KEY_TYPED) {
            this.lastTyped = evt.getKeyChar(); 
        }
        if(this.textMod) {
        	for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
        		Shape txt = i.next();
        		if(txt instanceof SText) {
        			((SText)txt).setText(((SText)txt).getText()+evt.getKeyChar());
        		}
        	}
        	this.getView().repaint();
        }
        
    }

    public void keyPressed(KeyEvent evt)
    {
        if (evt.getID() == KeyEvent.KEY_PRESSED) {
            this.lastPressed = evt.getKeyChar(); 
        }
    }

    public void keyReleased(KeyEvent evt)
    {
        if (evt.getID() == KeyEvent.KEY_RELEASED) {
            this.lastRealesed  = evt.getKeyChar(); 
        }
    }


}
