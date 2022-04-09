// 2.2.6

package Lab01;

import java.util.Scanner;
import java.lang.Math;

public class MathSolver {
	
	private static void showMessage() {
		System.out.println();
		System.out.println("Select mode: {1, 2, 3, 4}");
		System.out.println("1. First-degree equation with one variable");
		System.out.println("2. System of first-degree equations with rwo variables");
		System.out.println("3. Second-degree equation with one variable");
		System.out.println("4. Exit program");
		System.out.println();
	}
	
	private static void FirstDegreeEquationSolver(double a, double b) {
		if (a == 0d && b == 0d) {
			System.out.println("Infinite solutions");
		} else if (a == 0d && b != 0d) {
			System.out.println("No solution");
		} else {
			System.out.println("Unique solution: " + -b/a);
		}
	}
	
	private static void SystemEquationsSolver(double a11, double a12, double a21, double a22,
											double b1, double b2) {
		double D = a11*a22 - a21*a12;
		double D1 = b1*a22 - b2*a12;
		double D2 = a11*b2 - a21*b1;
		
		if (D == 0d && (D1 != 0d || D2 != 0d)) {
			System.out.println("No solution");
		} else if (D == 0d && D1 == 0d && D2 == 0d) {
			System.out.println("Infinite solutions");
		} else {
			System.out.println("Unique solution: ");
			System.out.println("x1 = " + D1 / D + " and x2 = " + D2 / D);
		}
	}
	
	private static void SecondDegreeSolver(double a, double b, double c) {
		double delta = b*b - 4*a*c;
		
		if (a == 0) {
			System.out.println("a must be different from 0");
		} else if (delta < 0) {
			System.out.println("No root");
		} else if (delta == 0) {
			System.out.println("Double root: " + -b/2/a);
		} else if (delta > 0) {
			System.out.println("Two distince roots: " + "x1 = " + (-b + Math.sqrt(delta)) / 2 / a + 
								" and x2 = " + (-b - Math.sqrt(delta)) / 2 / a);
		}
	}
	
	public static void main(String[] args) {
		showMessage();
		
		Scanner myScanner = new Scanner(System.in);
		String inputCommand = myScanner.nextLine();
		
		while (true) {
			if (inputCommand.equals("1")) {
				System.out.println("Input a:");
				double a = Double.parseDouble(myScanner.nextLine());
	
				System.out.println("Input b:");
				double b = Double.parseDouble(myScanner.nextLine());
				
				FirstDegreeEquationSolver(a, b);
				
				showMessage();
				inputCommand = myScanner.nextLine();
			} else if (inputCommand.equals("2")) {
				System.out.println("Input a11:");
				double a11 = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input a12:");
				double a12 = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input a21:");
				double a21 = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input a22");
				double a22 = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input b1:");
				double b1 = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input b2:");
				double b2 = Double.parseDouble(myScanner.nextLine());

				SystemEquationsSolver(a11, a12, a21, a22, b1, b2);
				
				showMessage();
				inputCommand = myScanner.nextLine();
			} else if (inputCommand.equals("3")) {
				System.out.println("Input a:");
				double a = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input b:");
				double b = Double.parseDouble(myScanner.nextLine());
				System.out.println("Input c:");
				double c = Double.parseDouble(myScanner.nextLine());
				
				SecondDegreeSolver(a, b, c);
				
				showMessage();
				inputCommand = myScanner.nextLine();
			} else if (inputCommand.equals("4")) {
				System.out.println("End program");
				break;
			} else {
				System.out.println("Wrong command, try again");
				showMessage();
				inputCommand = myScanner.nextLine();
			}
		}
	}
}
