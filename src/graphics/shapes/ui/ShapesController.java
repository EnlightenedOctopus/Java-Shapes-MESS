package graphics.shapes.ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller{
	Point mouseLoc;
    private static boolean shiftDown;
    private char t;
    private char p;
    private char r;
    private int id;
	
	public ShapesController(Object model) {
		super(model);
	}
	
	public Shape whereIs(float x, float y) {
		
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			if(s.getBounds().contains(x,y)) {
				return s;
			}
		}
		return null;
	}
	
	public void selectShape(Shape s) {
		if(s.getAttributes("selection") != null) {
			((SelectionAttributes) s.getAttributes("selection")).select();
		}
		else {
			s.addAttributes(new SelectionAttributes());
		}
	}
	
	public void toggleSelectShape(Shape s) {
		if(s.getAttributes("selection") != null) {
			((SelectionAttributes) s.getAttributes("selection")).toggleSelection();
		}
		else {
			s.addAttributes(new SelectionAttributes());
		}
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

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.whereIs(e.getX(), e.getY()) != null) {
			this.toggleSelectShape(this.whereIs(e.getX(), e.getY()));
		}
		this.mouseLoc=e.getPoint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		getSelected().translate(e.getPoint().x-this.mouseLoc.x, e.getPoint().y-this.mouseLoc.y);
		this.mouseLoc=e.getPoint();
		System.out.println(e.getPoint().x-this.mouseLoc.x);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("test");
	}

    public void keyTyped(KeyEvent evt)
    {
        id = evt.getID();
        if (id == KeyEvent.KEY_TYPED) {
            t = evt.getKeyChar(); 
        }
    }

    public void keyPressed(KeyEvent evt)
    {
        id = evt.getID();
        if (id == KeyEvent.KEY_PRESSED) {
            p = evt.getKeyChar(); 
        }
    }

    public void keyReleased(KeyEvent evt)
    {
        id = evt.getID();
        if (id == KeyEvent.KEY_RELEASED) {
            r  = evt.getKeyChar(); 
        }
    }

    public void shiftState(KeyEvent evt) {
        int id;
        id = evt.getKeyChar();
        if (id == KeyEvent.VK_SHIFT) {
            if (evt.getID() == KeyEvent.KEY_PRESSED) {
                this.shiftDown = true;
            }
            else {
                this.shiftDown = false;
            }
        }

    }

}
