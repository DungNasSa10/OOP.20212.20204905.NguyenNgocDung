package lab1;

// 2.2.6
import java.util.Scanner;

public class MathSolver {
	public static void FirstDegreeEquationSolver(double a, double b) {
		if (a == 0 && b == 0) {
			System.out.println("Infinite solutions");
		} else if (b == 0 && a != 0) {
			System.out.println("No solution");
		} else {
			System.out.println("Unique solution: " + -b/a);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Select mode: {1, 2, 3, 4}");
		System.out.println("1. First-degree equation with one variable");
		System.out.println("2. System of first-degree equations with rwo variables");
		System.out.println("3. Second-degree equation with one variable");
		System.out.println("4. Exit program");
		
		Scanner myScanner = new Scanner(System.in);
		String inputCommand = myScanner.nextLine();
		
		if (inputCommand == "1") {
			System.out.println("Input a:");
			int a = Integer.parseInt(myScanner.nextLine());
			
			System.out.println("Input b:");
			int b = Integer.parseInt(myScanner.nextLine());
			
			FirstDegreeEquationSolver(a, b);
		}
	}
}
