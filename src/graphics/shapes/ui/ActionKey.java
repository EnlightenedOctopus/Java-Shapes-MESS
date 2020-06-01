package graphics.shapes.ui;

import java.awt.event.KeyEvent;
import graphics.shapes.Shape;
import graphics.shapes.ui.ShapesController;
public class ActionKey {

	private ShapesController sc;
	
	public ActionKey(ShapesController sc) {
		this.sc = sc;
	}
	
	public void action(KeyEvent evt) {
		int key = evt.getKeyCode();
		
		if (key == KeyEvent.VK_A && evt.isControlDown()) {
			sc.selectAll();
		}
		if (key == KeyEvent.VK_I && evt.isControlDown()) {
			sc.unelectelAll();
		}
	}
}
