package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SCollection;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {
	private Controller controler;
	
	public ShapesView(SCollection c) {
		super(c);
		this.controler=new ShapesController(this.getModel());
	}
	
	public void paintComponent(Graphics g) {
		new ShapeDraftman(g).visitCollection((SCollection)this.getModel());
	}
}
