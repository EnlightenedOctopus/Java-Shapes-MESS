package graphics.shapes;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import graphics.shapes.attributes.SelectionAttributes;


public class SImage extends Shape{
	private BufferedImage image;
	private Point loc;
	private String IMG_FOLDER="img/";
	private String imagename;
	
	public SImage(Point loc, String image) {
		this.loc=loc;
		this.imagename = image;
		try{
		    this.image = ImageIO.read(new File(IMG_FOLDER+image));
		}
		catch (IOException e){
		    System.out.println("Current working directory : " + System.getProperty("user.dir"));
		    e.printStackTrace();
		}
		
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public void setimage(BufferedImage image) {
		this.image=image;
	}
	
	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point loc) {
		this.loc = loc;
		
	}

	@Override
	public void translate(int x, int y) {
		this.loc.translate(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.getLoc().x, this.getLoc().y, this.image.getWidth(), this.image.getHeight());
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitImage(this);
		
	}

	@Override
	public SImage copy() {
		SImage img = new SImage(this.loc.getLocation(), this.imagename);
		img.addAttributes(new SelectionAttributes());
		return img;
	}
	
}
