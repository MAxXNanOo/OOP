

public class Student{
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    public Student(String studentId,String name, int age, double gpa){
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public boolean isPassed(){
        if(gpa>=2.00){
            return true;
        }
        else {
        	return false;
        }
    }
    
    public String gStudentId() {
    	return studentId;
    }
    
    public String gName() {
    	return name;
    }
    
    public int gAge() {
    	return age;
    }
    
    public double gGpa() {
    	return gpa;
    }

}