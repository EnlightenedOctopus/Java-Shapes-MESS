package graphics.extensions;

import javax.swing.JFrame;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.ui.ShapesView;

public class FenetreEditColor extends JFrame{
	private PanneauEditColor pan;
	private ColorAttributes attri;
	private ShapesView sv;
	
	public FenetreEditColor(ColorAttributes c, ShapesView sv, ButtonController bc) {
	    this.attri=c;
	    this.sv=sv;
	    this.pan=new PanneauEditColor(attri,this,bc);
		this.setTitle("Edition de Couleur");
	    this.setSize(500, 300);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.setResizable(false);
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
	public ShapesView getSV() {
		return this.sv;
	}
	
}
