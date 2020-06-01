package graphics.shapes;

public interface ShapeVisitor {
	
	public void visitRectangle(SRectangle rect);
	public void visitCircle(SCircle circ);
	public void visitText(SText text);
	public void visitCollection(SCollection col);
	//Ext Img
	public void visitImage(SImage sImage);
}
