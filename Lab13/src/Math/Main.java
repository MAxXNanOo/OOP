package Math;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = new String[input.split(" ").length];
//        char [] arr = new char[input.length()];
//        arr = input.toCharArray();

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        String mark = new String();

        input = input.trim().replace("[", "").replace("]", "").trim().replace(" ", "");
        input = input.replace("+", ",+,").replace("*", ",*,").replace("-", ",-,");
        arr= input.split(",");

        int round=0;
        for(String s : arr){
            if(s.equals("+")){
                mark = "+";
                round++;
            }
            else if(s.equals("*")){
                mark = "*";
                round++;
            }
            else if(s.equals("-")){
                mark = "-";
                round++;
            }else{
                if(round==0){
                    A.add(Integer.parseInt(s));
                }
                else if(round==1){
                    B.add(Integer.parseInt(s));
                }
            }
        }


        if(mark.equals("+")){
            for(int a : A){
                C.add(a);
            }

            for(int b : B){
                if(eq(b, C)){
                    continue;
                }
                else{
                    C.add(b);
                }
            }
        }
        else if(mark.equals("*")){
            for(int a : A){
                if(eq(a, B)){
                    C.add(a);
                }
            }
        }
        else if(mark.equals("-")){
            for(int a : A){
                if(eq(a, B)){
                    continue;
                }
                else{
                    C.add(a);
                }
            }
        }

        System.out.print("[");
        for(int i=0 ; i<C.size() ; i++){
            System.out.print(C.get(i));

            if(i!=C.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");

    }

    public boolean eq(int data, ArrayList<Integer> arr){
        for(int a : arr){
            if(a==data){
                return true;
            }
        }
        return false;
    }
}
