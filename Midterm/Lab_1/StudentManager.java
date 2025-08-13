
public class StudentManager {
    private Student []students = new Student[50];
    private static int countStudent;

    public void addStudent(Student stu){
        students[countStudent++] = stu;
    }

    public void showAllStudents() {
    	int i;
    	System.out.printf("\n--- Student Information ---\n");
    	for(i=0 ; i<countStudent ; i++) {
    		System.out.print(
	    						"ID : " + students[i].gStudentId() +
	    						"\nName : " + students[i].gName() +
	    						"\nAge : " + students[i].gAge() +
	    						"\nGPA : " + students[i].gGpa() +
	    						"\nResult : "
	    					);
    		if(students[i].isPassed()) {
    			System.out.println("Passed");
    		}
    		else {
    			System.out.println("NOT Passed");
    		}
    		
    		System.out.printf("---------------------------\n");
    		
    	}
    	
    }
    
    public int countPassedStudents() {
    	int i,Pass=0;
    	for(i=0 ; i<countStudent ; i++) {
    		if(students[i].isPassed()) {
    			Pass++;
    		}
    	}
    	return Pass;
    }
}
