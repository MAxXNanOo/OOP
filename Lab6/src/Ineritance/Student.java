package Ineritance;

public class Student {
	protected String name;
	protected int id;
	protected double gpa;
	
	public Student(int id, String name, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}
	
	public Student(int id, double gpa) {
		this.id = id;
		this.gpa = gpa;
	}
	
	private String getName() {
		return name;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName() {
		
	}
	
	public String toString() {
		if(name != null) {
			return "Student :\n" + "ID: " + id + "\nName: " + name + "\nGPA: " + gpa + "\n";	
		}
		else {
			return "Student :\n" + "ID: " + id + "\nName: "  + "\nGPA: " + gpa + "\n";
		}

	}
}
