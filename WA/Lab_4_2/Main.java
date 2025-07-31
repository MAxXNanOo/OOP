import java.util.Scanner;

public class Main{
    public static void main(String[] arg){
        Product []a  = new Product[5];
        a[0]=new Product(0,"Mama",5.5); 
        a[1]=new Product(10,"Lays",10.5);
        Scanner n = new Scanner(System.in);
        for(int i=2;i<5;i++){
            System.out.println("Product Code "+i*10);
            System.out.printf("Name :");
            String name = n.nextLine();
            System.out.printf("Price :");
            double price = n.nextDouble();
            n.nextLine();
            a[i]=new Product(i*10,name,price);
        }
        System.out.printf("=============List============");
        for(int i=0;i<5;i++){
            System.out.println("Code :"+a[i].getcode());
            System.out.printf("Name :"+a[i].getname()+", ");
            System.out.println("Price :"+a[i].getprice());
        }
        System.out.println("===== What do you want to buy =====");
        System.out.println("Enter product code (press -1 to exit)");
        Scanner s = new Scanner(System.in);
        int c = 1;
        double sum=0;
        int amount;
        while(c!=-1){
            System.out.printf("Enter code : ");
            c = s.nextInt();
            if(c==-1)
                break;
            System.out.printf("Enter amount of "+a[c/10].getname()+" : ");
            amount = s.nextInt();
            sum+=a[c/10].getprice()*amount;
        } 
        System.out.printf("You have to pay : "+sum+" bath");
    }
}