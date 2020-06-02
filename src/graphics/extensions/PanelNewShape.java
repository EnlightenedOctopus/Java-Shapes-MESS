package graphics.extensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SImage;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class PanelNewShape extends JPanel implements MouseListener{
	private WindowNewShape win;
	private int rx;
	private int ry;
	private int rad;
	private String txt;
	private boolean badEntry=false;
	
	public PanelNewShape(WindowNewShape w) {
		this.win=w;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(30, 140, 50, 15);
		g.setColor(Color.GREEN);
		g.fillRect(100,140,50,15);
		g.setColor(Color.BLACK);
		g.drawString("CANCEL", 30, 152);
		g.drawString("NEW", 109,152);
		if (win.choice==0) {
			g.drawString("Entrer rayon", 10, 20);
		}
		if (win.choice==1) {
			g.drawString("Entrer tailles x puis y", 10, 20);
		}
		if (win.choice==2) {
			g.drawString("Entrer texte", 10, 20);
		}
		if (win.choice==3) {
			g.drawString("Mettre l'image dans img", 10, 20);
			g.drawString("Entrer nom.extension :", 10, 40);
		}
		if (this.badEntry) {
			g.setColor(Color.RED);
			g.drawString("Mauvaise entrée", 10, 40);
		}
	}
	public void exitWindow() {
		this.setEnabled(false);
		this.win.getSV().repaint();
		this.win.dispose();
	}
	
	public boolean goodEntry() {
		if (win.choice==0) {
			if (this.win.getf1().getText()!=null) {
				return true;
			}
		}
		if (win.choice==1) {
			if (this.win.getf1().getText()!=null && this.win.getf2().getText()!=null) {
				return true;
			}
		}
		if (win.choice==2) {
			if (this.win.getf3().getText()!=null) {
				return true;
			}
		}
		if (win.choice==3) {
			if (this.win.getf3().getText()!=null) {
				return true;
			}
		}
		return false;
	}
	
	public void createShape() {
		Shape s = null;
		if (win.choice==0){
			s = new SCircle(new Point(30,30),Integer.parseInt(this.win.getf1().getText()));
		}
		if (win.choice==1) {
			s = new SRectangle(new Point(30,30),Integer.parseInt(this.win.getf1().getText()),Integer.parseInt(this.win.getf2().getText()));
		}
		if (win.choice==2) {
			s = new SText(new Point(30,30),this.win.getf3().getText());
			s.addAttributes(new FontAttributes());
		}
		if (win.choice==3) {
			s = new SImage(new Point(30,30),this.win.getf3().getText());
		}
		s.addAttributes(new ColorAttributes(true,true,Color.WHITE,Color.BLACK));
		s.addAttributes(new SelectionAttributes());
		SCollection c = (SCollection) this.win.getSV().getModel();
		c.add(s);
	}
	
	public void mousePressed(MouseEvent e){
		if (e.getY()>140 && e.getY()<155) {
			if (e.getX()>30 && e.getX()<80) {
				this.exitWindow();
			}
			if (e.getX()>100 && e.getX()<150) {
				if (this.goodEntry()) {
					this.createShape();
					this.exitWindow();
				}
				else {
					this.badEntry=false;
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
}
