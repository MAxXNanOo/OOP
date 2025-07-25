import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        product[] p = new product[5];

        p[0] = new product(0,"Mama",5.5);
        p[1] = new product(10,"Lays",10.5);

        int i,x;
        String tmpS;
        double tmpD,sum=0;
        for(i=20,x=2 ; i<=40 ; i+=10,x++){
            System.out.printf("Product code %d\n",i);
            System.out.printf("name:");
            tmpS = sc.nextLine();
            System.out.printf("price:");
            tmpD = sc.nextDouble();
            sc.nextLine();
            p[x] = new product(i,tmpS,tmpD);
        }

        System.out.println("========== List of Products ==========");
        for(x=0 ; x<5 ; x++){
            System.out.printf("Product code %d\nName:%s , Price: %.1f\n",p[x].gCode(),p[x].gName(),p[x].gPrice());
        }

        System.out.println("==== What do you want to buy? ====\n");
        System.out.println("Enter product code (press -1 to exit)");
        int tmp1=0,tmp2=0;
        while(true){
            System.out.printf("Product Code:");
            tmp1 = sc.nextInt();

            i=0;
            while(i<5){
                if(p[i].gCode() == tmp1){
                    break;
                }
                i++;
            }

            if(tmp1 == -1)
                break;
            System.out.printf("Amount of %s:",p[i].gName());
            tmp2 = sc.nextInt();

            sum+=p[i].gPrice()*tmp2;
        }

        System.out.println("You have to pay " + sum + " Bath");
        
    }
}