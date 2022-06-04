// 6.5

package hust.soict.dsai.lab01;

import java.util.Scanner;

public class SortAndCalculate {
	
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(double arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    private void sort(double arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
    /* A utility function to print array of size n */
    private static void printArray(double arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    private static void calculateSumAndAvarege(double arr[]) {
    	double sum = 0;
    	
    	for (int i=0; i < arr.length; i++) {
    		sum += arr[i];
    	}
    	
    	System.out.println("Sum of given array: " + sum);
    	System.out.println("Average of given array: " + sum / arr.length);
    }
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Input array length");
		int arrayLength = myScanner.nextInt();
		
		while (arrayLength <= 0) {
			System.out.println("Array length must be positive, try again");
			System.out.println("Input array length");
			arrayLength = myScanner.nextInt();
			
			if (arrayLength > 0) {
				break;
			}
		}
		
        double[] arr = new double[arrayLength];
        
        System.out.println("Input array elements");
        for (int i=0; i < arrayLength; i++) {
        	arr[i] = myScanner.nextDouble();
        }
        
        System.out.println("Given Array");
        printArray(arr);
  
        SortAndCalculate ob = new SortAndCalculate();
        ob.sort(arr, 0, arr.length - 1);
  
        System.out.println("Sorted array");
        printArray(arr);
        
        calculateSumAndAvarege(arr);
	}
}