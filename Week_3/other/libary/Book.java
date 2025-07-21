public class Book {
    String title;
    String author;
    int year;
    
    public Book() {
        title = " - ";
        author = " - ";
        year = 0;
    }

    public Book(String a, String b, int y) {
        title = a;
        author = b;
        year = y;
    }

    void displayInfo(){
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Year : " + year);
    }

    boolean isClassic(){
        if(2025 - year >= 20){
            return true;
        }
        else{
            return false;
        }
    }
}