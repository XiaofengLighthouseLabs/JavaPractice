//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -office: string
// -salary: string
// -dateHired: MyDate
// +Assignment2Task1_Employee()
// +Assignment2Task1_Employee(name: string, address: string, phoneNumber: string, emailAddress: string, office: string, salary:string, elapsedTime: long)
// +setOffice(office: String)
// +getOffice() : string
// +setSalary(s: double)
// +getSalary(): string
// +setDateHired()
// +getDateHired(): string
// +toString(): string

package assignment2;

public class Assignment2Task1_Employee  extends Assignment2Task1_Person{
	private String office;
	private String salary;
	private MyDate dateHired;
	//default constructor
	public Assignment2Task1_Employee() {}
	//constructor with parameters
	public Assignment2Task1_Employee(String name, String address, 
			String phoneNumber, String emailAddress, String office, String salary, long elapsedTime) {
		super(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = new MyDate(elapsedTime);
	}
	//set office
	public void setOffice(String office) {
		this.office = office;
	}
	//return office
	public String getOffice() {
		return office;
	}
	//set salary
	public void setSalary(double s) {
		s = Math.round(s * 100.0) / 100.0;
		String salary = Double.toString(s);
		this.salary = salary;
	}
	//get salary
	public String getSalary() {
		return salary;
	}
	//set date hired
	public void setDateHired() {
		this.dateHired = new MyDate();
	}
	//return date hired
	public String getDateHired() {
		return (this.dateHired.getYear() + "-" + this.dateHired.getMonth() + "-" + this.dateHired.getDay());
	}
	//override toString function
	public String toString() {
		return (super.toString() + "\nOffice: " + getOffice() + "\nSalary: " + 
	getSalary() + "\nDate Hired: " + getDateHired());
	}
}
