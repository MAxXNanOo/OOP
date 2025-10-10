package Eabstract;

public class Main {
    public static void main(String[] args) {
        Employee m1 = new Manager("Anong", 75000, "IT");
        Employee c1 = new ContractEmployee("Boonmee", 30000, 12);

        
        
        m1.displayInfo();
        System.out.println();
        System.out.println();
        c1.displayInfo();
    }
}


