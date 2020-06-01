package graphics.extensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.shapes.ui.ShapesView;

public class ButtonPanel{
	private Graphics g;
	public int DEFAULTWIDTHBUTTON=40;
	private BufferedImage icon1,icon2,icon3,icon4,icon5,icon6;
	
	public ButtonPanel(Graphics g, ShapesView sv) {
		this.g=g;
		this.g.setColor(Color.GRAY);
		this.g.fillRect((int)this.g.getClipBounds().getWidth()-DEFAULTWIDTHBUTTON,0, DEFAULTWIDTHBUTTON, (int)this.g.getClipBounds().getHeight());
		try {
			icon1 = ImageIO.read(new File("data/addCircle.jpg"));
			icon2 = ImageIO.read(new File("data/addRect.jpg"));
			icon3 = ImageIO.read(new File("data/addText.jpg"));
			icon4 = ImageIO.read(new File("data/deleteAll.jpg"));
			icon5 = ImageIO.read(new File("data/editcolor.jpg"));
			icon6 = ImageIO.read(new File("data/editText.jpg"));
		}
		catch (IOException e) {
			System.out.println("Current working directory : " + System.getProperty("user.dir"));
		    e.printStackTrace();
		}
		//imag = ImageIO.read(new File("data/addCircle.jpg"));
		this.g.drawImage(this.icon1, (int)this.g.getClipBounds().getWidth()-(DEFAULTWIDTHBUTTON/2)-12,DEFAULTWIDTHBUTTON, sv);
		this.g.drawImage(this.icon2, (int)this.g.getClipBounds().getWidth()-(DEFAULTWIDTHBUTTON/2)-12,2*DEFAULTWIDTHBUTTON, sv);
		this.g.drawImage(this.icon3, (int)this.g.getClipBounds().getWidth()-(DEFAULTWIDTHBUTTON/2)-12,3*DEFAULTWIDTHBUTTON, sv);
		this.g.drawImage(this.icon4, (int)sv.getBounds().width-(DEFAULTWIDTHBUTTON/2)-12,4*DEFAULTWIDTHBUTTON, sv);
		this.g.drawImage(this.icon5, (int)sv.getBounds().width-(DEFAULTWIDTHBUTTON/2)-12,5*DEFAULTWIDTHBUTTON, sv);
		this.g.drawImage(this.icon6, (int)sv.getBounds().width-(DEFAULTWIDTHBUTTON/2)-12,6*DEFAULTWIDTHBUTTON, sv);
	}
}