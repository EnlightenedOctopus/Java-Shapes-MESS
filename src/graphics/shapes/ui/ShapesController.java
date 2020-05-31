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
    private boolean shiftDown;
    private char t;
    private char p;
    private char r;
    private int id;
	
	public ShapesController(Object model) {
		super(model);
	}
	
	public Shape getTarget(int x, int y) {
		int te=0;
		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
			Shape s = i.next();
			
			System.out.println(te);
			te++;
			if(s.getBounds().contains(x,y)) {
				System.out.println("test");
				return s;
			}
			
		}
		return null;
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
		super.mouseClicked(e);
		if(this.getTarget(e.getPoint().x, e.getPoint().y) != null) {
			this.selectShape(this.getTarget(e.getPoint().x, e.getPoint().y));
		}
		else {
			for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
				Shape s = i.next();
				this.unselectShape(s);
			}
		}
		this.mouseLoc=e.getPoint();
		this.getView().repaint();
		

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		getSelected().translate(e.getPoint().x-this.mouseLoc.x, e.getPoint().y-this.mouseLoc.y);
		this.mouseLoc=e.getPoint();
		this.getView().repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		this.mouseLoc=e.getPoint();
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
