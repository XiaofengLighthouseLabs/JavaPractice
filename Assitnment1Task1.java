package assignment1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Assitnment1Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//user input loan amount, number of years and annual interest rate
		Scanner input = new Scanner(System.in);
		System.out.printf("%s","Loan Amount: ");
	    double loanAmount = input.nextDouble();
	    System.out.printf("%s", "Number of Years: ");
	    int year = input.nextInt();
	    System.out.printf("%s", "Annual Interest Rate: ");
	    double annualInterestRate = input.nextDouble();
	    
	    //calculate monthly interest rate
	    double monInterestRate = (annualInterestRate / 12) * 0.01;
	    //calculate pay times
	    int times = year * 12;
	    //calculate monthly interest
	    double monthlyPayment = 
	    		loanAmount * ((monInterestRate * Math.pow((1 + monInterestRate), times))/(Math.pow((1 + monInterestRate), times) - 1));
	    System.out.printf("\n%s%.2f\n","Monthly Payment: ", monthlyPayment);
	    //calculate total payment
	    double totalPayment = monthlyPayment * year * 12;
	    System.out.printf("%s%.2f\n\n", "Total Payment: ", totalPayment);
	    //display interest, principal, balance form
	    double interest, principal;
	    double balance = loanAmount;
	    System.out.println("payment#" + "\t" + "Interest" + "\t" + "Principal" + "\t" + "Balance");
	    DecimalFormat f = new DecimalFormat("#0.00");
	    for(int i = 1; i <= year * 12; i++) {
	    	interest = monInterestRate * balance;
	    	principal = monthlyPayment - interest;
	    	balance = balance - principal;
	    	System.out.println(i + "\t\t" + f.format(interest) + "\t\t" + f.format(principal) + "\t\t" + f.format(balance));
	    }
	    
	    input.close();
	}

}
