package lab;

import annotations.ButtonGroup;
import annotations.CheckBox;
import annotations.TextPane;

public class UIModel 
{
	@TextPane
	private String name;
	
	@TextPane
	private String newPane;
	
	public String getNewPane() {
		return newPane;
	}
	public void setNewPane(String newPane) {
		this.newPane = newPane;
	}
	public boolean isStatus() {
		return status;
	}
	@CheckBox
	private boolean status;
	
	@ButtonGroup(options={"Beginner","Intermediate","Advanced"})  // HOW WOULD YOU ADD THIS?
	private String programmingLevel;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean setStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getProgrammingLevel() {
		return programmingLevel;
	}
	public void setProgrammingLevel(String programmingLevel) {
		this.programmingLevel = programmingLevel;
	}
	@Override
	public String toString() {
		return "UIModel [name=" + name + ", newPane=" + newPane + ", status=" + status + ", programmingLevel="
				+ programmingLevel + "]";
	}

	
	
}
