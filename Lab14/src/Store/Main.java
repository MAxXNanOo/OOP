package Store;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ArrayList<item> arr = new  ArrayList<item>();
        String name;
        double price;
        int quantity;
        String choice;
        double sum=0;

        while(true){
            System.out.print("Enter the name of the item: ");
            name = sc.nextLine();

            System.out.print("Enter the unit price: ");
            price = sc.nextDouble();

            System.out.print("Enter the quantity: ");
            quantity = sc.nextInt();

            arr.add(new item(name, price, quantity));

            System.out.print("Contunue shopping (y/n) ?");
            choice = sc.next();

            sc.nextLine();
            if(choice.equals("n")){
                break;
            }
        }

        System.out.printf("\nFinal Shopping Cart totals\n");
        for(item item : arr){
            System.out.printf("%s \t $%.2f \t %d \t \t $%.2f\n", item.getName(), item.getPrice(), item.getQuantity(), item.getPrice()*item.getQuantity());

            try{
                Writer writer = new FileWriter("F:\\WORK\\OOP\\Lab14\\src\\Store\\sell.txt", true);
                writer.write(item.getName() + ", " + item.getPrice() + ", " + item.getQuantity() + "\n");
                writer.close();
            }catch(Exception e){
                e.getMessage();
            }
            sum += item.getPrice()*item.getQuantity();
        }

        System.out.printf("Total Amount in Cart:  $%.2f\n", sum);
    }
}
