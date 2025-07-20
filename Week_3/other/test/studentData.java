package other;
import java.util.Scanner;
import java.util.ArrayList;

public class studentData {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> age = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);

        System.out.print("numStudent : ");
        int numStudent = scan.nextInt();

        String tmpName;
        int tmpAge;

        for(int i=0 ; i<numStudent ; i++){
            scan.nextLine();
            System.out.printf("Enter name: ");
            tmpName = scan.nextLine();

            System.out.printf("Enter age: ");
            tmpAge = scan.nextInt();

            name.add(tmpName);
            age.add(tmpAge);
        }

        System.out.println("\n\nData Student : ");

        for(int i=0 ; i<name.size() && i<age.size() ; i++){
            System.out.println("name: " + name.get(i) + ", age: " + age.get(i));
        }

    }
}
