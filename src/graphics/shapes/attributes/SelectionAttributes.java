package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {
	private boolean selected=false;
	
	public String getId() {
		return "selection";
	}
	public boolean isSelected() {
		return this.selected;
	}
	public void select() {
		this.selected=true;
	}
	public void unselect() {
		this.selected=false;
	}
	public void toggleSelection() {
		this.selected= !this.selected;
	}
	@Override
	public SelectionAttributes copy() {
		return null;
	}

}
