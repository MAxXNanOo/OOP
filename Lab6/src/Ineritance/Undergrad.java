package Ineritance;

public class Undergrad extends Student{
	private String year;
	
	public Undergrad(int id, String name, double gpa, String year) {
		super(id,name,gpa);
		this.year = year;
	}
	
	public String toString() {
		return "Undergraduate Student :\n" + "ID: " + id + "\nName: " + name + "\nGPA: " + gpa + "\nYear: " + year  + "\n";	
	}
}
