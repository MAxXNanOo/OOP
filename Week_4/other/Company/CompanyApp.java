import java.util.Scanner;

public class CompanyApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n,i,j;
        String id,name,position;
        double salary;

        System.out.printf("\nEnter number MEMBER : ");
        n = scan.nextInt();

        Employee[] people = new Employee[n];

        for(i=0 ; i<n ; i++){
            System.out.printf("\nEnter : \n");
            scan.nextLine();
            System.out.printf("ID : ");
            id = scan.nextLine();
            System.out.printf("Name : ");
            name = scan.nextLine();
            System.out.printf("Position : ");
            position = scan.nextLine();
            System.out.printf("Salary : ");
            salary = scan.nextDouble();

            people[i] = new Employee(id,name,position,salary);
        }

        System.out.println();
        people[0].displayInfo();

        
    }
}
