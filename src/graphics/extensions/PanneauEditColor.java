package graphics.extensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import graphics.shapes.attributes.ColorAttributes;

public class PanneauEditColor extends JPanel implements MouseListener{
	
	ArrayList<Color> listColor=new ArrayList<Color>();
	ColorAttributes att;
	
	public PanneauEditColor(ColorAttributes attri){
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
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i =0; i<listColor.size();i++) {
			g.setColor(listColor.get(i));
			g.fillRoundRect(10+30*i, 50, 30, 30, 10, 10);
			g.fillRoundRect(10+30*i, 130, 30, 30, 10, 10);
		}
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
				att.filledColor=listColor.get(this.findColorButton((int)e.getX()));
			}
		}
		if (e.getY()<160 && e.getY()>130) {
			if (this.findColorButton((int)e.getX())!=listColor.size()+1) {
				att.strokedColor=listColor.get(this.findColorButton((int)e.getX()));
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