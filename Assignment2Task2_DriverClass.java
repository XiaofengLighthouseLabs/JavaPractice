
//Assignment2 Task2
// Run Assignment2Task2_DriverClass to test class Assignment2Task2_Matrix

package assignment2;

public class Assignment2Task2_DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create matrix M
		Assignment2Task2_Matrix M = new Assignment2Task2_Matrix(3, 3);
		System.out.println(M.toString("M"));
		//create first matrix A		
		int[][] a = {{1, 2, 3},{4, 2, 7},{9, 0, 7}};
		Assignment2Task2_Matrix A = new Assignment2Task2_Matrix(a);
		System.out.println("The first Matrix is: ");
		System.out.println(A.toString("A"));
		Assignment2Task2_Matrix.incrementCounter(A);
		//create second matrix B
		int[][] b = {{1, 3, 5},{3, 2, 1},{5, 1, 7}};
		Assignment2Task2_Matrix B = new Assignment2Task2_Matrix(b);
		System.out.println("The second Matrix is: ");
		System.out.println(B.toString("B"));
		Assignment2Task2_Matrix.incrementCounter(B);
		//sum matrix A and matrix M	
		System.out.println("The sum of matrix A and matrix M is: ");
		System.out.println(A.sum(M).toString("Sum_AM"));
		Assignment2Task2_Matrix.incrementCounter(A.sum(M));
		//sum matrix A and matrix B	
		System.out.println("The sum of matrix A and matrix B is: ");
		System.out.println(A.sum(B).toString("Sum_AB"));
		Assignment2Task2_Matrix.incrementCounter(A.sum(B));
		//check if matrix A is symmetric
		System.out.printf("A");
		A.displaySymmetric();
		//check if matrix B is symmetric
		System.out.printf("B");
		B.displaySymmetric();
		//print out the counter
		System.out.println("The counter of not_zero matrices is: " + Assignment2Task2_Matrix.getCounter());
		
	}

}
