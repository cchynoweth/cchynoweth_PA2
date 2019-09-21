package chynoweth_p3;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String[] topics = {"Climate Change", "Social Issues", "Deforestation", "Poverty", "Hunger"};
		int[][] responses = new int[5][10];
		double[] avg = new double[5];
		int count = 0;                         // counts how many people have responded
		
		int cont = 1;                          // initializes cont at 1 so that there will always be at least 1 user responding
		while (cont == 1) {                    // while loop checks that if cont is equal to 1, continue taking ratings
			for (int i = 0; i < 5; i++) {
				System.out.printf("Rate the importance of %s on a scale of 1 (least important) to 10 (most important): ", topics[i]);
				int rating = in.nextInt();
				responses[i][rating-1] ++;
			}
			count++;
			System.out.print("Type 1 for another person to respond, type 2 to end: ");         // asks if more people want to leave ratings
			cont = in.nextInt();
		}
		
		int highest = 0;                      // initializes highest and lowest positions for checking which topic has the highest ratings
		int lowest = 0;
		
		System.out.printf("                  " +  "1   2   3   4   5   6   7   8   9   10\n"); // prints top row of table, showing all the possible ratings
		for (int i = 0; i < 5; i++) {
			System.out.printf("%-15s", topics[i]);          // prints the topic names as row titles
			for (int j = 0; j < 10; j++) {
				System.out.printf("%4d", responses[i][j]);  // prints the number of each rating 1-10 each topic received, e.g. three 2's and five 7's
				avg[i] += (j+1)*responses[i][j];            // adds the value of all ratings for a certain topic, e.g. 2+2+7+7+7+7+7
			}
			avg[i] /= count;                                // completes average equation by dividing by number of ratings left
			if (i > 0) {
				if (avg[i] < avg[i-1]) {                    // checks if current average is the lowest
					lowest = i;
				}
				if (avg[i] > avg[i-1]) {                    // checks if current average is the highest
					highest = i;
				}
			}
			System.out.printf("%6.2f\n", avg[i]);           // prints out average rating for current topic to the right of the table
		}
		System.out.printf("\n%s is the highest rated topic with an average rating of %.2f\n", topics[highest], avg[highest]);  // under the table, prints topics with highest and lowest averages
		System.out.printf("%s is the lowest rated topic with an average rating of %.2f\n", topics[lowest], avg[lowest]);
		
		
		in.close();
	}

}
