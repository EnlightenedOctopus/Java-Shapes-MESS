package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor {
	public ColorAttributes DEFAULTCOLORATTRIBUTES;
	public int DEFAULTSELECTIONSQUARE;
	private Graphics g;
	
	public ShapeDraftman(Graphics g) {
		super();
		this.g=g;
		this.DEFAULTCOLORATTRIBUTES=new ColorAttributes(true, true, Color.black, Color.white);
		this.DEFAULTSELECTIONSQUARE=3;
	}
	public void visitRectangle(SRectangle r) {
		ColorAttributes attri = (ColorAttributes)r.getAttributes("color");
		if (attri==null) attri=DEFAULTCOLORATTRIBUTES;
		if (attri.filled) {
			g.setColor(attri.filledColor);
			g.fillRect((int)r.getLoc().getX(), (int)r.getLoc().getY(), r.getRect().width,r.getRect().height);
		}
		if (attri.stroked) {
			g.setColor(attri.strokedColor);
			g.drawRect((int)r.getLoc().getX(), (int)r.getLoc().getY(), r.getRect().width,r.getRect().height);
		}
		SelectionAttributes attri2 = (SelectionAttributes)r.getAttributes("selection");
		if (attri2!=null && attri2.isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect((int)r.getLoc().getX()-DEFAULTSELECTIONSQUARE,(int)r.getLoc().getY()-DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
			g.drawRect((int)r.getLoc().getX()+r.getRect().width-DEFAULTSELECTIONSQUARE-1,(int)r.getLoc().getY()+r.getRect().height-DEFAULTSELECTIONSQUARE-1,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
		}
	}
	public void visitCircle(SCircle c) {
		ColorAttributes attri = (ColorAttributes)c.getAttributes("color");
		if (attri==null) attri=DEFAULTCOLORATTRIBUTES;
		if (attri.filled) {
			g.setColor(attri.filledColor);
			g.fillOval((int)c.getLoc().getX()-c.getRadius(), (int)c.getLoc().getY()-c.getRadius(), 2*c.getRadius(), 2*c.getRadius());
		}
		if (attri.stroked) {
			g.setColor(attri.strokedColor);
			g.drawOval((int)c.getLoc().getX()-c.getRadius(), (int)c.getLoc().getY()-c.getRadius(), 2*c.getRadius(), 2*c.getRadius());
		}
		SelectionAttributes attri2 = (SelectionAttributes)c.getAttributes("selection");
		if (attri2!=null && attri2.isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect((int)c.getLoc().getX()-c.getRadius()-DEFAULTSELECTIONSQUARE,(int)c.getLoc().getY()-c.getRadius()-DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
			g.drawRect((int)c.getLoc().getX()+c.getRadius()-DEFAULTSELECTIONSQUARE-1,(int)c.getLoc().getY()+c.getRadius()-DEFAULTSELECTIONSQUARE-1,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
		}
	}
	public void visitText(SText txt) {
		ColorAttributes attcolor = (ColorAttributes)txt.getAttributes("color");
		if (attcolor==null) attcolor=DEFAULTCOLORATTRIBUTES;
		FontAttributes attfont = (FontAttributes)txt.getAttributes("font");
		if (attfont==null) attfont= new FontAttributes();
		g.setColor(attcolor.filledColor);
		g.fillRect(txt.getBounds().x, txt.getBounds().y, txt.getBounds().width, txt.getBounds().height);
		
		g.setColor(attfont.fontColor);
		g.setFont(attfont.font);
		g.drawString(txt.getText(), txt.getLoc().x, txt.getLoc().y);
		SelectionAttributes attriselect = (SelectionAttributes)txt.getAttributes("selection");
		if (attriselect!=null && attriselect.isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(txt.getBounds().x-DEFAULTSELECTIONSQUARE,txt.getBounds().y-DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
			g.drawRect(txt.getBounds().x + txt.getBounds().width-DEFAULTSELECTIONSQUARE-1,txt.getBounds().y + txt.getBounds().height-DEFAULTSELECTIONSQUARE-1,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
		}
	}
	public void visitCollection(SCollection c) {
		SelectionAttributes attri = (SelectionAttributes)c.getAttributes("selection");
		if (attri!=null && attri.isSelected()) {
			int xmini=15000;
			int ymini=15000;
			int xmaxi=-1;
			int ymaxi=-1;
			for (Iterator<Shape> i = c.iterator(); i.hasNext();) {
				Shape s = i.next();
				if (s.getBounds().getX()<xmini) xmini=(int)s.getBounds().getX();
				if (s.getBounds().getY()<ymini) ymini=(int)s.getBounds().getY();
				if (s.getBounds().getX()+s.getBounds().getWidth()>xmaxi) xmaxi=(int)(s.getBounds().getX()+s.getBounds().getWidth());
				if (s.getBounds().getY()+s.getBounds().getHeight()>ymaxi) ymaxi=(int)(s.getBounds().getY()+s.getBounds().getHeight());
			}
			g.setColor(Color.BLACK);
			g.drawRect(xmini-DEFAULTSELECTIONSQUARE,ymini-DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
			g.drawRect(xmaxi-DEFAULTSELECTIONSQUARE-1,ymaxi-DEFAULTSELECTIONSQUARE-1,2*DEFAULTSELECTIONSQUARE,2*DEFAULTSELECTIONSQUARE);
		}
		Iterator<Shape> i = c.iterator();
		while (i.hasNext()) {
			i.next().accept(this);
		}
	}
}
