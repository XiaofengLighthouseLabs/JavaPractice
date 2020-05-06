
//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -status: string
// +Assignment2Task1_Student()
// +Assignment2Task1_Student(name: string, address: string, phoneNumber: string, emailAddress: string, status: string)
// +setStatus(status: string)
// +getStatus(): string
// +toString(): string


package assignment2;

public class Assignment2Task1_Student extends Assignment2Task1_Person{
	private String status;
	//default constructor
	public Assignment2Task1_Student() {}
	//constructor with parameters
	public Assignment2Task1_Student(String name, String address, 
			String phoneNumber, String emailAddress, String status) {
		setStatus(status);
		setName(name);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setEmailAddress(emailAddress);		
	}
	//set a new status
	public void setStatus(String status) {
		if(status.toLowerCase().equals("freshman") || status.toLowerCase() .equals("sophomore")
				|| status.toLowerCase().equals ("junior") || status.toLowerCase().equals ("senior")) {
			this.status = status;
		}else {
			this.status = "invalid enter";
		}
		
	}
	//get status
	public String getStatus() {		
		return status;
	}
	//override toString function
	public String toString() {
		return super.toString() + "\nStatus: " + getStatus();
	}
}
