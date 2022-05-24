// 6.1

package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, 
				"Do yow want to change to the first class ticket?");
		
	    String result = "?";
	    switch (option) {
	    case JOptionPane.CANCEL_OPTION:
	      result = "Canceled";
	      break;
	    case JOptionPane.CLOSED_OPTION:
	      result = "Closed";
	      break;
	    case JOptionPane.NO_OPTION:
	      result = "No";
	      break;
	    case JOptionPane.YES_OPTION:
	      result = "Yes";
	      break;
	    default:
	      ;
	    }
		
		JOptionPane.showMessageDialog(null, "You've chosen: " + result);
		System.exit(0);
	}
}