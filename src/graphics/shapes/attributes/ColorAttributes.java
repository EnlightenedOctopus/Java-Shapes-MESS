package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes{
	
	public String getId() {
		return "color";
	}
	public boolean filled;
	public boolean stroked;
	public Color filledColor;
	public Color strokedColor;
	
	public ColorAttributes(boolean f, boolean s, Color fc, Color sc) {
		this.filled=f;
		this.stroked=s;
		this.filledColor=fc;
		this.strokedColor=sc;
	}
	public ColorAttributes copy() {
		ColorAttributes ca = new ColorAttributes(this.filled, this.stroked, this.filledColor, this.strokedColor);
		return ca;
	}
	
}
