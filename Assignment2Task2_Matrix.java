//Assignment2 Task2
// Run Assignment2Task2_DriverClass.java for testing

// -nrow: int
// -ncol: int
// -mat: int[][]
// N: final static int
// counter: static int
// +Assignment2Task2_Matrix()
// +Assignment2Task2_Matrix(nrow: int, ncol: int)
// +Assignment2Task2_Matrix(mat: int[][])
// +Assignment2Task2_Matrix(A: Assignment2Task2_Matrix )
// +setNrow(nrow: int)
// +getNrow(): int
// +setNcol(ncol: int)
// +getNcol(): int
// +setMat(mat: int[][])
// +getMat(): int[][]
// +incrementCounter(A: Assignment2Task2_Matrix)
// +getCounter(): static int
// +sum(n: Assignment2Task2_Matrix): Assignment2Task2_Matrix 
// +isSymmetric(): boolean
// +displaySymmetric()
// +toString(name: string): string

package assignment2;

public class Assignment2Task2_Matrix {
	static int counter = 0;
	final static int N = 10;
	private int nrow = 2;
	private int ncol = 2;
	private int[][] mat;
	//no-argument constructor that sets all matrix values to zero
	//with default number of rows and column
	public Assignment2Task2_Matrix() {
		this.mat = new int[this.nrow][this.ncol]; 
	}
	//two-argument constructor that takes two arguments nrow and ncol to
	//initialize the instance variable nrow and ncol
	public Assignment2Task2_Matrix(int nrow, int ncol) {
		if(nrow < N) {
			this.nrow = nrow;
		}else {
			this.nrow = 0;
			System.out.println("Invalid nrow enter.");
		}
		if(ncol < N) {
			this.ncol = ncol;
		}	else {
			this.ncol = 0;
			System.out.println("Invalid ncol enter.");
		}
		this.mat = new int[this.nrow][this.ncol];	
	}
	//2d array constructor
	public Assignment2Task2_Matrix(int[][]mat) {
		if(mat.length < N) {
			this.nrow = mat.length;
		}else {
			this.nrow = 0;
			System.out.println("Invalid nrow.");
		}
		if(mat[0].length < N) {
			this.ncol = mat[0].length;
		}else {
			this.ncol = 0;
			System.out.println("Invalid ncol.");
		}	
		this.mat = new int [nrow][ncol];
		for(int i = 0; i < nrow; i++) {
			for(int j = 0; j < ncol; j++) {
				this.mat[i][j] = mat[i][j];
			}
		}		
	}
	//a copy constructor
	public Assignment2Task2_Matrix(Assignment2Task2_Matrix A) {
		this(A.mat);
	}
	
	//set a new nrow
	public void setNrow(int nrow) {
		if(nrow < N) {
			this.nrow = nrow;
		}else {
			this.nrow = 0;
			System.out.println("Invalid nrow enter.");
		}		
	}
	//get nrow
	public int getNrow() {
		return nrow;
	}
	//set a new ncol
	public void setNcol(int ncol) {
		if(ncol < N) {
			this.ncol = ncol;
		}	else {
			this.ncol = 0;
			System.out.println("Invalid ncol enter.");
		}
	}
	//get ncol
	public int getNcol() {
		return ncol;
	}
	//set mat
	public void setMat(int[][] mat) {
		if(mat.length < N) {
			this.nrow = mat.length;
		}else {
			this.nrow = 0;
			System.out.println("Invalid nrow.");
		}
		if(mat[0].length < N) {
			this.ncol = mat[0].length;
		}else {
			this.ncol = 0;
			System.out.println("Invalid ncol.");
		}	
		this.mat = new int [nrow][ncol];
		for(int i = 0; i < nrow; i++) {
			for(int j = 0; j < ncol; j++) {
				this.mat[i][j] = mat[i][j];
			}
		}		
	}
	//get mat
	public int[][] getMat(){
		return mat;
	}
	//get methods for static variables
	public static void incrementCounter(Assignment2Task2_Matrix A) {
		counter++;		
	}
	public static int getCounter() {
		return counter;
	}
	//sum function, makes the sum of current matrix object 
	//with a matrix object as parameter and returns the sum
	public Assignment2Task2_Matrix sum(Assignment2Task2_Matrix n) {
		Assignment2Task2_Matrix m = this;
		if((n.nrow != m.nrow) ||(n.ncol != m.ncol)) {
			System.out.println("can not sum to matices");
		}
		Assignment2Task2_Matrix sum = new Assignment2Task2_Matrix(nrow, ncol);
		for(int i = 0; i < nrow; i++) {
			for(int j = 0; j < ncol; j++) {
				sum.mat[i][j] = m.mat[i][j] + n.mat[i][j];
			}
		}
		return sum;
	}
	
	//IsSymmetric function returns true when the matrix is symmetric
	public boolean isSymmetric() {
		boolean symmetricMatrix = true;
		if(nrow != ncol) {
			symmetricMatrix = false;
		}else{
			
			for (int i = 0; i < nrow; i++) {
				for(int j = 0; j < ncol; j++) {
					if(mat[i][j] != mat[j][i]) {
						symmetricMatrix = false;
						break;
					}
				}
			}
		}
		return symmetricMatrix;
	}
	public void displaySymmetric() {
		
		if(isSymmetric()) {
			System.out.println(" is a symmetric matrix.");
		}else {
			System.out.println(" is not a symmetric matrix.");
		}
	}
	
	
	//toString() function to represent the matrix
	public String toString(String name) {
		String output = name + " =     \t";
		for(int i = 0; i < nrow; i++) {			
			for(int j = 0; j < ncol; j++) {
				output += (mat[i][j] + "  ");
			}			
			output += "\n";
			output += "        \t";
		}
		return output;
	}
}
