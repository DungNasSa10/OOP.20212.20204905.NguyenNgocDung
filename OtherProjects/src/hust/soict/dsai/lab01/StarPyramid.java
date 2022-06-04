// 6.3

package hust.soict.dsai.lab01;

import java.util.Scanner;

public class StarPyramid {
	private static void printStarPyramid(int n) {
		int numChar = 2*n - 1;
		for (int row = 1; row <= n; row++) {
			int numStar = 2*(row - 1) + 1;
			int numSpace = (numChar - numStar) / 2;
			StringBuilder line = new StringBuilder();
			
			for (int space = 1; space <= numSpace; space++) {
				line.append(" ");
			}
			
			for (int star = 1; star <= numStar; star++) {
				line.append("*");
			}
			
			for (int space = 1; space <= numSpace; space++) {
				line.append(" ");
			}
			
			System.out.println(line);
		}
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter value of n:");
		int n = keyboard.nextInt();
		
		printStarPyramid(n);
	}
}