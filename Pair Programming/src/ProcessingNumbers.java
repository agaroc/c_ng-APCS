/*Caleb Ng
 * 10/6/19
 * Ask for numbers and returns the evben numbers, min , max, and max of the even numbers
 */
import java.util.*;
public class ProcessingNumbers {
	public static void main(String[]args) {
		Scanner userInput = new Scanner(System.in);
		int max = 0;
		int currentNumber = 0;
		String evenNum = "";
		int maxEven = 0;
		System.out.print("How many numbers do you have? ");
		int times = userInput.nextInt();
		System.out.print("Whats your Number?");
		int min = userInput.nextInt();
		for(var i = 1; i < times; i ++) {
			System.out.print("Whats your Number?");
			currentNumber = userInput.nextInt();
			if(currentNumber % 2 ==0) {
				evenNum += (currentNumber + ",");
				if(maxEven < currentNumber) {
					maxEven = currentNumber; 
				}
			}
			if(max < currentNumber) {
				max = currentNumber;
			}else if(min > currentNumber){
				min = currentNumber;
			}			
		}
		System.out.println("Max: " + max + "\nMin: " +  min + "\nEvens: " + evenNum + "\nMaxEven: " + maxEven);
		userInput.close();
	}
}
