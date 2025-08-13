package Two;
import java.util.Scanner; 

public class PoliceOffice {
	 public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 
		 int num,tmpCase=0;
		 do {
			 System.out.print("[1] New Case\n"
			 				+ "[2] New Police\n"
					 		+ "[3] Visitor\n"
					 		+ "[0] /Exit/\n"
			 				+ "Enter number : ");
			 num = scan.nextInt();
			 System.out.printf("\n\n");
			 
			 switch(num) {
			 case 1:
				 String prisonerName,policeName,caseId;
				 
				 System.out.printf("  Police Name : ");
				 policeName = scan.nextLine();
				 System.out.printf("  caseId : ");
				 caseId = scan.nextLine();
				 System.out.printf("  Prisoner Name : ");
				 prisonerName = scan.nextLine();
				 
				 Police policeN = new Police(policeName);
				 Prisoner prisonerN = new Prisoner(prisonerName,caseId);
				 Case 
				 
				 break;
				 
			 case 2:
				 System.out.printf("  Name : ");
				 String name = scan.nextLine();
				 
				 Police 
				 
			 }
		 }while(num!=0);
	 }
}