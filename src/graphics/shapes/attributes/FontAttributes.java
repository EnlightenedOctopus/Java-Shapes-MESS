package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

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
		FontRenderContext frc = new FontRenderContext(new AffineTransform(),false,false);
		Rectangle2D r = font.getStringBounds(wtf,frc);
		Rectangle r2 = new Rectangle((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
		return r2;
	}
}
