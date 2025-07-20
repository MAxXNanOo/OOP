package other.store;

import java.util.Scanner;

public class Product {
    String name;
    double price;
    int quantity;

    public Product(){
        name = "Unknow";
        price = 0.0;
        quantity = 0;
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display(){
        System.out.printf("\nProduct 1:\nName: %s, Price: %.1f, Quantity: %d\n\n",name,price,quantity);
    }

    public static void main(String[] arge){
        Scanner scan = new Scanner(System.in);
        Product p1 = new Product();

        System.out.printf("Enter product name: ");
        String tmpName = scan.nextLine();
        System.out.printf("Enter product price: ");
        double tmpPrice = scan.nextDouble();
        System.out.printf("Enter product quantity: ");
        int tmpQuantity = scan.nextInt();

        Product p2 = new Product(tmpName, tmpPrice, tmpQuantity);

        p1.display();
        p2.display();
    }
}
