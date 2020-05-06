//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -title: string
// +Assignment2Task1_Staff()
// +Assignment2Task1_Staff(name: string, address: string, phoneNumber: string, emailAddress: string, office: string, salary: string, elapsedTime: long, title: title)
// +setTitle(title: string)
// +getTitle(): string
// +toString(): string
	
package assignment2;

public class Assignment2Task1_Staff extends Assignment2Task1_Employee{
	private String title;
	//default constructor
	public Assignment2Task1_Staff() {}
	//constructor with parameters
	public Assignment2Task1_Staff(String name, String address, String phoneNumber, 
			String emailAddress, String office, String salary, long elapsedTime, String title) {
		super(name, address, phoneNumber, emailAddress, office, salary, elapsedTime);
		this.title = title;
	}
	//set title
	public void setTitle(String title) {
		this.title = title;
	}
	//get title
	public String getTitle() {
		return title;
	}
	//override toString function
	public String toString() {
		return(super.toString() + "\nTitle: " + getTitle());
	}

}
