package attributes;

public class SelectionAttributes extends Attributes {
	private boolean selected;
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
	public void toggleSelected() {
		this.selected= !this.selected;
	}

}
