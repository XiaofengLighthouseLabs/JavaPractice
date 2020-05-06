
//Assignment2 Task1
//run Assignment2Task1_Test.java for testing

// -year: int
// -month: int
// -day: int
// +MyDate()
// +MyDate(elapsedTime: long)
// +MyDate(year: int, month: int, day: int)
// +getYear(): string
// +getMonth(): string
// +getDay(): string
// +setDate(elapsedTime: long)

package assignment2;

import java.util.Calendar;

public class MyDate {
	private int year;
	private int month;
	private int day;
	//no-arg constructor
	public MyDate() {
		Calendar now = Calendar.getInstance();
		this.year = now.get(Calendar.YEAR);
		this.month = now.get(Calendar.MONTH);
		this.day = now.get(Calendar.DAY_OF_MONTH);
	}
	//constructor with a elapsed time
	public MyDate(long elapsedTime) {
		setDate(elapsedTime);
	}
	//constructor with year, month and day
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//get year
	public String getYear() {
		String y = String.valueOf(year);
		return y;
	}
	//get month
	public String getMonth() {
		String m = String.valueOf(month + 1);
		return ((month < 10) ? ("0" + m): m);
	}
	//get day
	public String getDay() {
		String d = String.valueOf(day);
		return ((day < 10) ? ("0" + d): d);
	}
	//set a new date for the object using the elapsed time
	public void setDate(long elapsedTime) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(elapsedTime);
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH);
		this.day = c.get(Calendar.DAY_OF_MONTH);
	}

}
