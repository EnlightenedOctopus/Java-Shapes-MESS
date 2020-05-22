package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class FontAttributes extends Attributes{
	@Override
	public String getId() {
		return "font";
	}
	
	public Font font;
	public Color fontColor;
	
	public FontAttributes() {
		font= new Font("Arial", Font.PLAIN, 10);
		fontColor = Color.BLACK;
	}
	
	public FontAttributes(Font f, Color c) {
		font=f;
		fontColor=c;
	}
	
	public Rectangle getBounds(String wtf) {
		return null;
	}
}
