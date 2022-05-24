//2.2.5

package hust.soict.dsai.lab01;

import java.util.Scanner;

public class OperationsOfTwoNumbers {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in); 
		
		System.out.println("Input the first number:");
		double num1 = Double.parseDouble(myScanner.nextLine());
		
		System.out.println("Input the second number:");
		double num2 = Double.parseDouble(myScanner.nextLine());
		
		System.out.print("Sum of two numbers: ");
		System.out.println(num1 + num2);
		
		System.out.print("Difference of two numbers: ");
		System.out.println(num1 - num2);
		
		System.out.print("Product of two numbers: ");
		System.out.println(num1 * num2);
		
		if (num2 == 0) {
			System.out.println("Can't devide by zero!");
		} else {
			System.out.print("Quotient of two numbers: ");
			System.out.println(num1 / num2);
		}
	}
	
}
