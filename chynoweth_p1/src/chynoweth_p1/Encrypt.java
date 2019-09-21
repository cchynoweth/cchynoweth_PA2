package chynoweth_p1;

import java.util.Arrays;
import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int tempNumber = 0;
		String number = in.nextLine();                      // scan in number
		int[] newNumber = new int[number.length()];         // create an array newNumber that is as long as the number scanned in
		
		for (int i = 0; i < number.length(); i++) {         // for loop goes through number
			tempNumber = ((number.charAt(i) +7+2) % 10);    // apply first half of encryption. +7 then remainder of dividing by 10
			newNumber[i] = tempNumber;
		}
		for (int i = 0; i < number.length()/2; i++) {       // for loop goes through half the number (a number length 4 will go i=0, i=1, i=2)
			tempNumber = newNumber[i+2];                    // swap number in array with the number 2 places in front of it
			newNumber[i+2] = newNumber[i];
			newNumber[i] = tempNumber;
		}

		String printNumber = Arrays.toString(newNumber)     // convert array newNumber into a properly formatted string, ready for printing 
			.replace(",", "")
			.replace("[", "")
			.replace("]", "")
			.replace(" ", "");
		System.out.println(printNumber);                    // print out encrypted
		
		in.close();
	}

}
