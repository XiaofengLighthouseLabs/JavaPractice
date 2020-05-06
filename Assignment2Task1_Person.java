//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -name: string
// -address: string
// -phoneNumber: string
// -emailAddress: string
// +Assignment2Task1_Person()
// +Assignment2Task1_Person(name: string, address: string, phoneNumber: string, emailAddress: string)
// +setName(name: string)
// +getName(): string
// +setAddress(address: string)
// +getAddress(): string
// +setPhoneNumber(phoneNumber: string)
// +getPhoneNumber(): string
// +setEmailAddress(emailAddress: string)
// +getEmailAddress(): string
// +toString(): string

package assignment2;

public class Assignment2Task1_Person {
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	//default constructor
	public Assignment2Task1_Person(){}
	//constructor with four parameters
	public Assignment2Task1_Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	//set a new name
	public void setName(String name) {
		this.name = name;
	}
	//get name
	public String getName() {
		return name;
	}
	//set a new address
	public void setAddress(String address) {
		this.address = address;
	}
	//get address
	public String getAddress() {
		return address;
	}
	//set a new phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//get phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}
	//set a new email address
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	//get email address
	public String getEmailAddress() {
		return emailAddress;
	}
	public String toString() {
		return "\nName: " + getName() + "\nAddress: " + getAddress() + "\nPhone Number: " + getPhoneNumber()
				+ "\nEmail Address: " + getEmailAddress() ;
	}
	 
}
 