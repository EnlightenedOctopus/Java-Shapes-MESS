package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {
	private Controller controller;
	
	public ShapesView(Shape c) {
		super(c);
	}
	
	public void paintComponent(Graphics g) {
		new ShapeDraftman(g).visitCollection((SCollection)this.getModel());
	}
	
	@Override
	public Controller defaultController(Object model) {
		return new ShapesController((SCollection) model);
	}
}
