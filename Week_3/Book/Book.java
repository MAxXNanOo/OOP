import java.util.Scanner;

public class Book{
    String name;
    int price;
    int year;
    String author;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Book book1 = new Book();

        System.out.printf("Enter Book name : ");
        book1.name = scan.nextLine();
        System.out.print("Enter Book price : ");
        book1.price = scan.nextInt();

        book1.year = 2542;
        book1.author = "J.K. Rowling";
        
        System.out.printf("\nBook: %s \nWritten by %s in %d \nPrice is %d Bath",book1.name,book1.author,book1.year,book1.price);
    }
}