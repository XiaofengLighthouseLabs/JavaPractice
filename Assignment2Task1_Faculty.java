
//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -officeHours: string
// -rank: string
// +Assignment2Task1_Faculty()
// +public Assignment2Task1_Faculty(name: string, address: string, phoneNumber: string, emailAddress: string, office: string, salary: string, elapsedTime: long, officeHours: string, rank: string)
// +setOfficeHours(officeHours: string)
// +getOfficeHours(): string
// +setRank(rank: string)
// +getRank(): string
// +toString(): string


package assignment2;

public class Assignment2Task1_Faculty extends Assignment2Task1_Employee{
	private String officeHours;
	private String rank;
	//default constructor
	public Assignment2Task1_Faculty() {};
	//constructor with parameters
	public Assignment2Task1_Faculty(String name, String address, String phoneNumber, 
			String emailAddress, String office, String salary, long elapsedTime, String officeHours, String rank) {
		super(name, address, phoneNumber, emailAddress, office, salary, elapsedTime);
		this.officeHours = officeHours;
		this.rank = rank;
		
	}
	//set officeHours;
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	//get officeHours
	public String getOfficeHours() {
		return officeHours;
	}
	//set rank
	public void setRank(String rank) {
		this.rank = rank;
	}
	//get rank
	public String getRank() {
		return rank;
	}
	//override toString function
	public String toString() {
		return(super.toString() + "\nOffice Hours: " + getOfficeHours() + "\nRank: " + getRank());
	}
	
}
