package graphics.extensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.shapes.attributes.ColorAttributes;

public class PanneauEditColor extends JPanel implements MouseListener{
	
	ArrayList<Color> listColor=new ArrayList<Color>();
	ColorAttributes att;
	FenetreEditColor win;
	
	public PanneauEditColor(ColorAttributes attri,FenetreEditColor jf){
		listColor.add(Color.BLACK);
		listColor.add(Color.BLUE);
		listColor.add(Color.CYAN);
		listColor.add(Color.DARK_GRAY);
		listColor.add(Color.GRAY);
		listColor.add(Color.GREEN);
		listColor.add(Color.LIGHT_GRAY);
		listColor.add(Color.MAGENTA);
		listColor.add(Color.ORANGE);
		listColor.add(Color.PINK);
		listColor.add(Color.RED);
		listColor.add(Color.WHITE);
		listColor.add(Color.YELLOW);
		this.addMouseListener(this);
		this.att=attri;
		this.win=jf;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i =0; i<listColor.size();i++) {
			g.setColor(listColor.get(i));
			g.fillRoundRect(10+30*i, 50, 30, 30, 10, 10);
			g.fillRoundRect(10+30*i, 130, 30, 30, 10, 10);
		}
		g.setColor(Color.GRAY);
		g.fillRect(250, 20, 60, 20);
		g.fillRect(250, 100, 60, 20);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(200, 200, 60, 20);
		g.setColor(Color.BLACK);
		g.drawString("Filled Color :", 100, 30);
		g.drawString("Stroked Color :", 100, 110);
		g.drawString("Enable",252,33);
		g.drawString("Enable",252,113);
		g.drawString("EXIT",217,215);
	}
	
	public int findColorButton(int x) {
		for (int i=0;i<listColor.size();i++) {
			if (x<40+30*i && x>10+30*i) {
				return i;
			}
		}
		return listColor.size()+1;
	}
	
	public void mousePressed(MouseEvent e){
		if (e.getY()<80 && e.getY()>50) {
			if (this.findColorButton((int)e.getX())!=listColor.size()+1) {
				System.out.println(listColor.get(this.findColorButton((int)e.getX())));
				att.filledColor=listColor.get(this.findColorButton((int)e.getX()));
			}
		}
		if (e.getY()<160 && e.getY()>130) {
			if (this.findColorButton((int)e.getX())!=listColor.size()+1) {
				att.strokedColor=listColor.get(this.findColorButton((int)e.getX()));
			}
		}
		if (e.getX()>250 && e.getX()<310) {
			if (e.getY()>20 && e.getY()<40) {
				if (att.filled==true) {
					att.filled=false;
				}
				else {
					att.filled=true;
				}
			}
			if (e.getY()>100 && e.getY()<120) {
				if (att.filled==true) {
					att.filled=false;
				}
				else {
					att.filled=true;
				}
			}
		}
		if (e.getX()>200 && e.getX()<260) {
			if (e.getY()>200 && e.getY()<220) {
				this.setEnabled(false);
				this.win.getSV().repaint();
				this.win.dispose();
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
