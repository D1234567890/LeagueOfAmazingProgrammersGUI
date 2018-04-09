
public class Student {
	
	private String name;
	private String location;
	private byte levelNum;
	
	public Student(String name, String location, byte levelNum) {
		this.name = name;
		this.location = location;
		this.levelNum = levelNum;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public byte getLevelNum() {
		return levelNum;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setLocation(String newLocation) {
		location = newLocation;
	}
	
	public void setLevelNum(byte newLevelNum) {
		levelNum = newLevelNum;
	}
	
	public void display() {
		
	}
}
