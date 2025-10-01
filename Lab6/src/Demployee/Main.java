package Demployee;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Somchai", 50000);
        Manager mgr1 = new Manager("Anong", 75000, "IT");

        
        System.out.print(emp1);
        System.out.println();
        System.out.print(mgr1);
        
    }
}

