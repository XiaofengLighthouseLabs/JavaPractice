
//Assignment2 Task1
// Run Assignment2Task1_Test.java to test class Assignment2Task1_Employee, class Assignment2Task1_Faculty, class Assignment2Task1_Person,
// 		class Assignment2Task1_Staff, class Assignment2Task1_Studemt and class MyDate.

package assignment2;

public class Assignment2Task1_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment2Task1_Person person1 = new Assignment2Task1_Person("Joseph", "3919 Gravida St.", "123-456-789", "joseph@100.com");		
		Assignment2Task1_Student student1 = new Assignment2Task1_Student
				("Edward", "3313 Vel Av.", "802-668-8240", "edward@200.com","Senior");
		Assignment2Task1_Employee employee1 = new Assignment2Task1_Employee("Kyla", "792 Dictum Av.", "654-393-5734", 
				"kyla@300.com", "#101", "$50000.00", 700000000000L);
		Assignment2Task1_Faculty faculty1 = new Assignment2Task1_Faculty("Potter", "208 Dolor Av.", "423-244-6306", "potter@400.com",
				"#B202", "$70000.00", 600000000000L, "9am to 5 pm", "Professor");
		Assignment2Task1_Staff staff1 = new Assignment2Task1_Staff("Hedy", "329 Viverra Av." , "608-265-2215", "hedy@500.com",
				"#721", "$56000.00", 830000000000L, "Tachnician");
		
		System.out.println(person1.toString());
		System.out.println(student1.toString());
		System.out.println(employee1.toString());
		System.out.println(faculty1.toString());
		System.out.println(staff1.toString());
	
	}

}
