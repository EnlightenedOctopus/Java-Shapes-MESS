package graphics.shapes;

public interface ShapeVisitor {
	
	public void visitRectangle(SRectangle rect);
	public void visitCircle(SCircle circ);
	public void visitText(SText text);
	public void visitCollection(SCollection col);
	public void visitImage(SImage sImage);
}
