package lab9_2;



public class Student {
	public String name;
	public String grads;
	Student(String name,String grad){
		this.name = name;
		this.grads = grad;
	}
	double calGrade() {
		double total=0;
		for(char grad:this.grads.toCharArray()) {
			if(grad=='A') {
				total+=4;
			}
			if(grad=='B') {
				total+=3;
			}
			if(grad=='C') {
				total+=2;
			}
			if(grad=='D') {
				total+=1;
			}
			if(grad=='F') {
				total+=0;
			}
			
			
		}
		
		return total/(grads.length());
	}
	
	public void checkbeforeShow() throws Exception{
		
		if(this.name.matches(".*(\\d).*")) {
			throw new DigitException("(digit is not allowed in name) can not display.");
		}
		if(this.name.matches(".*(\\s).*")) {
			throw new SpaceException("(space is not allowed in name) can not display. ");
		}
		

		if(!this.grads.matches("^[ABCDFI]+$")) {
			throw new GradeException("(grade must be A B C D E F) can not display. ");
		}
		
		if (this.grads.indexOf('I')!=-1) {
			throw new IncompleteException("(grade I is incomplete) can not display.");
		}
		
	}
	public  void show() {
		try {
			checkbeforeShow();
			System.out.printf("%s registered %d  subjects and got GPA %.1f", this.name,this.grads.length(),calGrade());
		}catch(Exception e) {
			System.out.println("E:"+e);
		}
		
	}
}
