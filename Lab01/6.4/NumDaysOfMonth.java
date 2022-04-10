// 6.4

package Lab01;

import java.util.*;

public class NumDaysOfMonth {
	private static String[] _days31 = {"January", "Jan.", "Jan", "1",
			"March", "Mar.", "Mar", "3",
			"May", "5",
			"July", "Jul", "7",
			"August", "Aug.", "Aug", "8",
			"October", "Oct.", "Oct", "10",
			"December", "Dec.", "Dec", "12"
		};
	private static ArrayList<String> days31 = new ArrayList<>(Arrays.asList(_days31));
	
	private static String[] _days30 = {"April", "Apr.", "Apr", "4",
								"June", "Jun", "6",
								"September", "Sept.", "Sep", "9",
								"November", "Nov.", "Nov", "11",
								
							};
	private static ArrayList<String> days30 = new ArrayList<>(Arrays.asList(_days30));
	
	private static String[] _Feb = {"February", "Feb.", "Feb", "2"};
	private static ArrayList<String> Feb = new ArrayList<>(Arrays.asList(_Feb));
	
	
	private static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
	
	private static String getNumDays(String month, int year) {
		if (Feb.contains(month)) {
			if (isLeapYear(year)) {
				return "29";
			} else return "28";
		} else if (days30.contains(month)) {
			return "30";
		} else if (days31.contains(month)) {
			return "31";
		} else {
			return "Invalid month, try again";
		}
	}
	
	private static void showMessage() {
		System.out.println();
		System.out.println("Input Command:");
		System.out.println("1. Query");
		System.out.println("2. End program");
		System.out.println();
	}
	
	public static void main(String[] args) {
		showMessage();
		
		Scanner myScanner = new Scanner(System.in);
		String inputCommand = myScanner.nextLine();
		
		while (true) {
			if (inputCommand.equals("1")) {
				System.out.println("Input year");
				int year = Integer.parseInt(myScanner.nextLine());
				while (year < 0) {
					System.out.println("Invalid yaer, try again");
					System.out.println("Input year");
					year = Integer.parseInt(myScanner.nextLine());
					
					if (year >= 0) {
						break;
					}
				}
				System.out.println("Input month");
				String month = myScanner.nextLine();
				
				String info = getNumDays(month, year);
				if (info.length() > 2) {
					System.out.println(info);
				} else {
					System.out.println("The number of days in " + month + "/" + year 
							+ " is " + info);
				}

				showMessage();
				inputCommand = myScanner.nextLine();
			} else if (inputCommand.equals("2")) {
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
