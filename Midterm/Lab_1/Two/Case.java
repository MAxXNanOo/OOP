package Two;

public class Case {
	private String caseId;
	private Prisoner dataPrisoner;
	private Police dataPolice;
	private static int count=0;
	private Case []data = new Case[100];
	
	public Case(String caseId, Prisoner dataPrisoner, Police dataPolice) {
		this.caseId = caseId;
		this.dataPrisoner = dataPrisoner;
		this.dataPolice = dataPolice;
	}
}
