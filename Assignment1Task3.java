package assignment1;

import java.util.Scanner;

public class Assignment1Task3 {
	
	//store distinct number in the array, ignore repeated number
	public static int isDistinct (int[] array, int num) {
		int distinct = 1;
		for(int i = 0; i < array.length; i++) {
			if(num == array[i]) {
				distinct = 0;
				break;
			}
		}		
		return distinct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] distinctArray = new int[10];
		System.out.println("Please enter 10 non-zero integers");
		System.out.printf("%s", "Enter the number: ");
		//user input ten numbers, store and count distinct numbers
		Scanner input = new Scanner(System.in);
		int num;
		int count = 0;
		for(int i = 0; i < 10; i++) {
			num = input.nextInt();
			if(isDistinct(distinctArray, num) == 1) {
				distinctArray[count] = num;
				count++;
			}
		}
		//display count
		System.out.println("Number of distinct numbers: " + count);
		//display distinct numbers
		System.out.printf("%s", "Numbers: ");
		for(int i = 0; i < count; i++) {
			System.out.printf("%d%s", distinctArray[i], " ");
		}		
		input.close();
	}

}
