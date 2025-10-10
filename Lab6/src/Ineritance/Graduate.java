package Ineritance;

public class Graduate extends Student{
	private String thesisTitle;
	
	public Graduate(int id, String name, double gpa, String thesisTitle){
		super(id,name,gpa);
		this.thesisTitle = thesisTitle;
	}
	
	public String toString() {
		return "Undergraduate Student :\n" + "ID: " + id + "\nName: " + name + "\nGPA: " + gpa + "\nThesis: " + thesisTitle + "\n";	
	}
}
