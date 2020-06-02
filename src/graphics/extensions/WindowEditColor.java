package graphics.extensions;

import javax.swing.JFrame;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.ui.ShapesView;

public class WindowEditColor extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelEditColor pan;
	private ColorAttributes attri;
	private ShapesView sv;
	
	public WindowEditColor(ColorAttributes c, ShapesView sv, ButtonController bc) {
	    this.attri=c;
	    this.sv=sv;
	    this.pan=new PanelEditColor(attri,this,bc);
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
