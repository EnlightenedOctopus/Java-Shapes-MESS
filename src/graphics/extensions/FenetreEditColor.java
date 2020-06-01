package graphics.extensions;

import java.awt.Dimension;

import javax.swing.JFrame;

import graphics.shapes.attributes.ColorAttributes;

public class FenetreEditColor extends JFrame{
	private PanneauEditColor pan;
	private ColorAttributes attri;
	
	public FenetreEditColor(ColorAttributes c) {
	    this.attri=c;
	    this.pan=new PanneauEditColor(attri);
		this.setTitle("Edition de Couleur");
	    this.setSize(500, 300);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
}
