package graphics.extensions;

import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import graphics.shapes.ui.ShapesView;

public class WindowNewShape extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelNewShape pan;
	private ShapesView sv;
	public int choice;
	private JFormattedTextField f1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField f2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JTextField f3 = new JTextField();
	
	public WindowNewShape(ShapesView sv,int ch) {
	    this.sv=sv;
	    this.choice=ch;
	    this.pan=new PanelNewShape(this);
		this.setTitle("Nouveau Shape");
	    this.setSize(200, 200);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.setResizable(false);
	    pan.setLayout(null);
	    f1.setPreferredSize(new Dimension(100,30));
	    f1.setBounds(5, 40, 170, 30);
	    f2.setPreferredSize(new Dimension(100,30));
	    f2.setBounds(5, 75, 170, 30);
	    f3.setPreferredSize(new Dimension(100,30));
	    if (choice==0) {
	    	pan.add(f1);
	    }
	    if (choice==1) {
	    	pan.add(f1);
	    	pan.add(f2);
	    }
	    if (choice==2) {
	    	f3.setBounds(5, 40, 170, 30);
	    	pan.add(f3);
	    }
	    if (choice==3) {
	    	f3.setBounds(5, 60, 170, 30);
	    	pan.add(f3);
	    }
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
	public ShapesView getSV() {
		return this.sv;
	}
	public JFormattedTextField getf1() {
		return this.f1;
	}
	public JFormattedTextField getf2() {
		return this.f2;
	}
	public JTextField getf3() {
		return this.f3;
	}
}
