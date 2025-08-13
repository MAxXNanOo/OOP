package Two;

public class Prisoner {
	private String name;
	private String caseId;
	
	public Prisoner(String name, String caseId) {
		this.name = name;
		this.caseId = caseId;
	}
	
	public String gName() {
		return name;
	}
	
	public String gCase() {
		return caseId;
	}
}
