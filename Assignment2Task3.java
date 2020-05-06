
//Assignment2 Task3
// counter: int
// inputList: int[]  //Enter the input numbers into the array inputList
// distinctList: List<Integer>  //Filter the distinct numbers into the list distinctList

package assignment2;
import java.util.*;
import java.util.Scanner;

public class Assignment2Task3 {
	public static void main(String[] args) {
		//initialize counter
		int counter = 0;
		//create inputList array
		int[] inputList = new int[10];
		//create list named distinctList 
		List<Integer> distinctList = new ArrayList<Integer>();
		//input 10 numbers
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 integers: ");
		for(int i = 0; i < 10; i++) {
			inputList[i] = input.nextInt();
			//ignore numbers appear multiple times
			if(distinctList.contains(inputList[i])) {
				continue;
			}else {
				distinctList.add(inputList[i]);
				//increment
				counter++;
			}
		}
		//display counter
		System.out.println("Number of distinct numbers: " + counter);
		//display distinct numbers separated by one space
		System.out.println("Distinct integers are: ");
		for(int num : distinctList) {
			System.out.print(num + " ");
		}
		input.close();
	}
}
