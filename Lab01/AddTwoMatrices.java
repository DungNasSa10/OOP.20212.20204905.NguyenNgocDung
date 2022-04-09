// 6.6

package Lab01;

import java.util.*;

public class AddTwoMatrices {
	private static int numRow, numCol;
	
	private static void printMatrix(double[][] matrix) {
		for (int row = 0; row < numRow; row++) {
			for (int col = 0; col < numCol; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Input numRow");
		numRow = myScanner.nextInt();
		System.out.println("Input numCol");
		numCol = myScanner.nextInt();
		
		double[][] matrix1 = new double[numRow][numCol];
		double[][] matrix2 = new double[numRow][numCol];
		double[][] sumMatrix = new double[numRow][numCol];
		
		System.out.println("Input matrix1");
		for (int row = 0; row < numRow; row++) {
			for (int col = 0; col < numCol; col++) {
				matrix1[row][col] = myScanner.nextDouble();
			}
		}
		
		System.out.println("Input matrix2");
		for (int row = 0; row < numRow; row++) {
			for (int col = 0; col < numCol; col++) {
				matrix2[row][col] = myScanner.nextDouble();
			}
		}
		
		for (int row = 0; row < numRow; row++) {
			for (int col = 0; col < numCol; col++) {
				sumMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
			}
		}
		
		System.out.println("Matrix1");
		printMatrix(matrix1);
		System.out.println();
		
		System.out.println("Matrix2");
		printMatrix(matrix2);
		System.out.println();
		
		System.out.println("Sum of two matrices");
		printMatrix(sumMatrix);
	}
}
