package Eabstract;

public abstract class Person {
	protected String name;
	
	protected Person(String name) {
		this.name = name;
	}
	
	public abstract void displayInfo();
}
