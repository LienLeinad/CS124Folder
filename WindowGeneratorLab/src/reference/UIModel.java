package reference;

public class UIModel 
{
	private String name;
	private boolean status;
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
		return String.format("UIModel [name=%s, status=%s, programmingLevel=%s]", name, status, programmingLevel);
	}
	
	
}
