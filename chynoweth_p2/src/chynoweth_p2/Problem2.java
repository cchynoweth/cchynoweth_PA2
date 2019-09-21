package chynoweth_p2;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int weight = 0;
		int height = 0;
		double BMI = 0;
		
		System.out.println("Type 1 for pounds/inches, type 2 for kilograms/meters");
		int choice = in.nextInt();
		
		switch(choice) {                                           // choose between imperial or metric
		case 1:
			System.out.print("Enter weight in pounds: ");
			weight = in.nextInt();
			System.out.print("Enter height in inches: ");
			height = in.nextInt();
			BMI = ((703 * weight)/Math.pow(height, 2));            // Math.pow(base, exponent) for calculating exponents
			System.out.printf("BMI is %.1f\n", BMI);
			break;
		case 2:
			System.out.print("Enter weight in kilograms: ");
			weight = in.nextInt();
			System.out.print("Enter height in meters: ");
			height = in.nextInt();
			BMI = ((weight)/Math.pow(height, 2));
			System.out.printf("BMI is %.1f", BMI);
			break;
		}
		
		System.out.print("\nBMI Categories:\n" +                  // print out BMI categories
				"Underweight = <18.5\n" + 
				"Normal weight = 18.5–24.9\n" + 
				"Overweight = 25–29.9\n" + 
				"Obesity = BMI of 30 or greater");
		
		in.close();
	}

}
