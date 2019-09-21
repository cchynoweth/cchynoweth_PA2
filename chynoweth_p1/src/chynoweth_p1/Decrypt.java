package chynoweth_p1;

import java.util.Arrays;
import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int tempNumber = 0;
		String number = in.nextLine();                      // scan in number
		int[] newNumber = new int[number.length()];         // create an array newNumber that is as long as the number scanned in
		
		for (int i = 0; i < number.length(); i++) {         // for loop goes through number
			tempNumber = ((number.charAt(i)-1-7) % 10);
			if (tempNumber < 7) {                           // check if number has wrapped around
				tempNumber += 3;                            // reverse wrap around by adding 10, reverse encryption by subtracting 7 (add 3)
			} 
			else {                                          // number has not wrapped around
				tempNumber -= 7;                            // reverse encryption by subtracting 7
			}
			
			newNumber[i] = tempNumber;
		}
		for (int i = number.length()/2; i < number.length(); i++) {       // for loop goes through half the number, starting at halfway point (a number length 4 will go i=2, i=3, i=4)
			tempNumber = newNumber[i-2];                    // reverse the swapping from encryption: swap number with the number 2 places behind it
			newNumber[i-2] = newNumber[i];
			newNumber[i] = tempNumber;
		}

		String printNumber = Arrays.toString(newNumber)     // convert array newNumber into a properly formatted string, ready for printing 
			.replace(",", "")
			.replace("[", "")
			.replace("]", "")
			.replace(" ", "");
		System.out.println(printNumber);                    // print out decrypted number
		
		in.close();
	}

}
