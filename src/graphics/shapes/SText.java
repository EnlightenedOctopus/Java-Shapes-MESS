package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;


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
		Rectangle tempo = new Rectangle(this.loc.x,this.loc.y-((FontAttributes)this.getAttributes("font")).getBounds(this.text).height,((FontAttributes)this.getAttributes("font")).getBounds(this.text).width,((FontAttributes)this.getAttributes("font")).getBounds(this.text).height);
		return tempo;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitText(this);
	}

	@Override
	public SText copy() {
		SText text = new SText(this.loc.getLocation(), this.text);
		text.addAttributes(this.getAttributes("color").copy());
		text.addAttributes(this.getAttributes("font").copy());
		text.addAttributes(new SelectionAttributes());
		return text;
	}
}
