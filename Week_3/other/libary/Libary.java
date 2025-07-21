import java.util.Scanner;

public class Libary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Book b1 = new Book("Niga", "mr.nig",2555);
        b1.displayInfo();
    }
}