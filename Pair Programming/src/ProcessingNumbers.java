/*Caleb Ng
 * 10/6/19
 * Ask for numbers and returns the sum of even numbers, min , max, and max of the even numbers
 */
import java.util.*;
public class ProcessingNumbers {
	public static void main(String[]args) {
		int min = 2147483647;
		int max= -2147483648;
		Scanner userInput = new Scanner(System.in);
		int currentNumber = 0;
		int sumEven = 0;
		int maxEven = 0;
		System.out.print("How many numbers do you have? ");
		int times = userInput.nextInt();
		if(times > 0) {
			for(var i = 1; i <= times; i ++) {
				System.out.print("Whats your Number?");
				currentNumber = userInput.nextInt();
				if(currentNumber % 2 == 0) {
					sumEven += currentNumber;
					if(max < currentNumber) {
						maxEven = currentNumber; 
					}
				}
				if(max < currentNumber) {
					max = currentNumber;
				}
				if(min > currentNumber){
					min = currentNumber;
				}			
			}
		}else {
			throw new IllegalArgumentException("You can't have a negative amount of numbers");
		}
		if(maxEven == 0) {
			System.out.println("Max: " + max + "\nMin: " +  min + "\nSumeven: " + sumEven + "\nMaxEven: No even number" );
		}else {
			System.out.println("Max: " + max + "\nMin: " +  min + "\nSumeven: " + sumEven + "\nMaxEven: " + maxEven);
		}
		userInput.close();
	}
}
