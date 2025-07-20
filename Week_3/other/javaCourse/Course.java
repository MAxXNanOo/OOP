import java.util.ArrayList;


public class Course {
    String courseName,instructor;
    int maxStudent;
    private ArrayList<String> student;

    public Course(String c, String i, int m){
        courseName = c;
        instructor = i;
        maxStudent = m;
        student = new ArrayList<>();
    }

    void addStudent(String studentName){
        if(student.size() < maxStudent){
            student.add(studentName);
        }
        else{
            System.out.printf("\nFull");
        }
    }

    void display(){
        System.out.printf("\n\n");
        for(String a : student){
            System.out.printf("%s \n",a);
        }
    }

    public static void main(String[] args){
        Course jCourse = new Course("JavaCourse","Nig",2);
        jCourse.addStudent("max");
        jCourse.addStudent("Wa");
        jCourse.addStudent("boss");
        jCourse.display();
        
    }
}
