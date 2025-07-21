
public class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Position : " + position);
        System.out.println("Salary : " + salary);
        System.out.println("Annual Salary: " + calculateAnnualSalary());
        System.out.println("Is Manager : " + isManager());
    }

    double calculateAnnualSalary() {
        return salary * 12;
    }

    boolean isManager(){
        if(position.equals("Manager")){
            return true;
        }
        else{
            return false;
        }
    }

    public String getterPosition(){
        return position;
    }

    public void setterSalary(double salary){
        if(isManager()){
            this.salary = salary;
        }
    }


}
