package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;


public class SText extends Shape{
	private String text;
	private Point loc;
	
	public SText(Point p,String s) {
		this.loc=p;
		this.text=s;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String s) {
		this.text=s;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitText(this);
	}
}
