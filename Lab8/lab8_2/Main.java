package lab8_2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 //NameRepository namesRepository = new NameRepository();
		
		 Containers namesRepository = ()->{
			 String[] names = {"John","May","Ryan"};
			 return new Iterator() {

				 int index = 0 ;
				 public boolean hasNext() {
					 if(index < names.length)
						 return true ;
					 return false;
				 }
				 public Object next() {
				 return names[index++];
				 }

				 public void remove() {

				 }
				 
			 };
			 
		 };
		 for (Iterator iter = namesRepository.getIterator(); iter.hasNext();){
		 String name = (String) iter.next();
		 System.out.println("Name : " + name);
		}
		} 

}
