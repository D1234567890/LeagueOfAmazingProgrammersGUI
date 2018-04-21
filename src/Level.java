import java.util.ArrayList;

public class Level {

	private ArrayList<Student> students = new ArrayList<Student>();

	private byte levelNum;

	public Level(byte levelNum) {
		this.levelNum = levelNum;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public boolean hasStudent(Student student) {
		if (students.contains(student)) {
			return true;
		} else {
			return false;
		}
	}

	public byte getLevel() {
		return levelNum;
	}
}
