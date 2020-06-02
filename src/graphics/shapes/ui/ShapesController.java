package graphics.shapes.ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.extensions.ButtonController;
import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller{
	Point mouseLoc;
    public boolean textMod=false;
    public boolean windowOpen=false;
    public SCollection copiedShapes;
	
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
		if (!this.windowOpen) {
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
		this.windowOpen=false;
	}

	@Override
    public void keyTyped(KeyEvent evt)
    {
 
        if(this.textMod) {
        	for (Iterator<Shape> i = ((SCollection) this.getSelected()).iterator(); i.hasNext();) {
        		Shape txt = i.next();
        		if(txt instanceof SText) {
        			if((int)evt.getKeyChar()==8) {
        				if(((SText)txt).getText().length() != 0) {
        					((SText)txt).setText(((SText)txt).getText().substring(0, ((SText)txt).getText().length()-1));
        				}
        			}
        			else {
        				((SText)txt).setText(((SText)txt).getText()+evt.getKeyChar());
        			}
        		
        		}
        	}
        	this.getView().repaint();
        }
        
    }

    public void keyPressed(KeyEvent evt){
    	//CTRL + A to select ALL
    	if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_A) {
    		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
				((SelectionAttributes) i.next().getAttributes("selection")).select();
			}
    	}
    	//CTRL + I to invertSelection
    	if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_I) { 
    		for (Iterator<Shape> i = ((SCollection) this.getModel()).iterator(); i.hasNext();) {
				((SelectionAttributes) i.next().getAttributes("selection")).toggleSelection();
			}
    	}
    	
    	//Ctrl+E to modify Text
    	if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_E) {
    		this.textMod=!this.textMod;
    	}
    	
    	//Ctrl + C to copy selected objetcs
    	if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C) {
			this.copy();
		}
    	
    	//Ctrl + V to paste selected objects
		if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
			this.paste();
		}
    	this.getView().repaint();
    }

    public void keyReleased(KeyEvent evt){
    	
    }
    
    
    public void copy() {
    	this.copiedShapes = getSelected().copy();
    }

	public void paste() {
		SCollection model = (SCollection) this.getModel();
		if (this.copiedShapes != null) {
			for (Iterator<Shape> i = this.copiedShapes.iterator(); i.hasNext();) {
				model.add(i.next());
			}
			
			getView().repaint();
		}
	}
		
		
	}

	


