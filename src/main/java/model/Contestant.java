package model;

public class Contestant {

	private int contestant_number;
	private String contestant_name;
	
	public Contestant() {
		
	}

	public Contestant(int contestant_number, String contestant_name) {
		this.contestant_number = contestant_number;
		this.contestant_name = contestant_name;
	}
	
	public int getContestant_number() {
		return contestant_number;
	}
	public void setContestant_number(int contestant_number) {
		this.contestant_number = contestant_number;
	}
	public String getContestant_name() {
		return contestant_name;
	}
	public void setContestant_name(String contestant_name) {
		this.contestant_name = contestant_name;
	}
	
	public String toString() {
		return (contestant_name + " is #" + contestant_number);
	}
	
}
