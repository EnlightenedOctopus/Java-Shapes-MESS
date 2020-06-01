package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.extensions.ButtonPanel;
import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {
	
	public ShapesView(Shape c) {
		super(c);
		this.defaultController(c);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		new ShapeDraftman(g).visitCollection((SCollection)this.getModel());
		//extension buttons
		new ButtonPanel(g,this);
		//
	}
	
	@Override
	public Controller defaultController(Object model) {
		return new ShapesController((SCollection) model);
	}
}
