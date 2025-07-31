public class test{
    int A;
    static int B;


    public test(){
        this.A=0;
        this.B=0;
    }


    public void plusA(){
        A++;
    }

    public void pulsB(){
        B++;
    }

    public void Display(){
        System.out.printf("\n\nA:%d  B:%d",A,B);
    }
}