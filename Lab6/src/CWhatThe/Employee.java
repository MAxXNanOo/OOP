package CWhatThe;


public abstract class Employee {
	protected String firstName;
	protected String lastName;
	protected String securityNumber;
	
	public Employee(String first, String last, String ssn) {
		firstName = first;
		lastName = last;
		securityNumber = ssn;
	}
	
	public String toString() {
		return String.format("%s employee :%s %s\nsocial security number: %s",getClass().getSimpleName(),firstName, lastName, securityNumber);
	}
	
	public abstract double earnings();
}
