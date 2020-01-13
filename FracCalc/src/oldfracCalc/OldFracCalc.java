/*Caleb Ng
 * 12/17/19
 * Frac Calc: Does calculations on fractions
 *  */
package oldfracCalc;
import java.util.*;
public class OldFracCalc {
	// Client Code that constantly ask user to input a fraction unless they type quit
    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	String stop = "";
    	do {
    		System.out.println("Enter your fractions:");
    		String input = userInput.nextLine();
    		System.out.println(produceAnswer(input));
    		System.out.println("Do you want to continue? Type (quit) to exit");
    		stop = userInput.nextLine();
    	}while(!stop.equals("quit"));	
    	userInput.close();
    }
    //Asks for a string and returns a String
    //Code that creates the answer for the user's computation 
    public static String produceAnswer(String input){
    	String result = "";
    	String[] splitOpperands = input.split(" ");
    	String opperand1 = splitOpperands[0];
    	String opperand2 = splitOpperands[1];
    	String opperand3 = splitOpperands[2];
    	String[] checkWhole1 = opperand1.split("_");
    	String[] checkWhole2 = opperand3.split("_");
    	int valueFrac1[] = {0,0,1};
    	int valueFrac2[] = {0,0,1};
    	String[] checkFracLen2 = opperand3.split("/");
    	String[] checkFracLen1 = opperand1.split("/");
    	int length1 = checkFracLen1.length;
    	int length2 = checkFracLen2.length;
    	valueFrac1 = produceSplit(checkWhole1, length1);
    	valueFrac2 = produceSplit(checkWhole2, length2);
    	int [] improper1 = toImproperFrac(valueFrac1[0], valueFrac1[1], valueFrac1[2]);
    	int [] improper2 = toImproperFrac(valueFrac2[0], valueFrac2[1], valueFrac2[2]);
    	if(opperand2.equals("*") || opperand2.equals("/")) {
        	result = multiplyOrDivide(improper1, improper2, opperand2);
        	if(improper1[0] == 0 || improper1[1] == 0 || improper2[0] == 0 || improper2[1] == 0) {
        		result = "0";
        	}
    	}else {
    		result = arithmetic(improper1, improper2, opperand2);
    	}
    	return result;
    }
    //Accepts a string of arrays and an integers returns an array integer
    //Splits the fraction into an array of integers
    
    //Accetps two array of integer and a string
    //Does subtraction or addition on the fractions
    public static String arithmetic(int [] arr1, int [] arr2, String operation) {
    	int commonDenom = arr2[1] * arr1[1];
    	int [] fracArr = {0,commonDenom};
    	if(operation.equals("+")) {
    		fracArr[0] = (arr1[0]*arr2[1]) + (arr2[0]*arr1[1]);
    	}else{
    		fracArr[0] = (arr1[0]*arr2[1])-(arr1[1]*arr2[0]);
    	}
    	int simplifyValue = gcf(fracArr);
    	String newFrac = checkErrors(simplifyValue, fracArr);
    	if(fracArr[0] == 0) {
    		newFrac = "0";
    	}else if(fracArr[0] == commonDenom) {
    		String [] tempArr = newFrac.split("/");
    		newFrac = tempArr[0];
    	}
    	return newFrac;
    }
    //Accetps two array of integer and a string
    //Does multiplication and divisions on the fractions
    public static String multiplyOrDivide(int[] arr1, int[] arr2, String operation) {
    	int [] fracArr = {0,0};
    	if(operation.equals("*")) {
    		fracArr[0] = arr1[0]* arr2[0];
    		fracArr[1] = arr1[1]* arr2[1];

    	}else {
    		fracArr[0] = (arr1[0] * arr2[1]);
    		fracArr[1] = (arr1[1] * arr2[0]);
    		
    	}
    	int simplifyValue = gcf(fracArr);
    	if(fracArr[1] < 0) {
    		fracArr[1] *= -1;
    		fracArr[0] *= -1;
    	}
    	String newFrac = checkErrors(simplifyValue, fracArr);
    	if(fracArr[0] == fracArr[1]) {
    		String [] tempArr = newFrac.split("/");
    		newFrac = tempArr[0];
    	}
    	return newFrac;
    }
    //Accepts an array of integers returns an integer
    // Find commoan factor betwene numbers
    public static int gcf(int [] arr) {
		int largestFactor = 0;
		if(Math.abs(arr[0]) == 0) {
			largestFactor = Math.abs(arr[1]);
		}else if(Math.abs(arr[1]) == 0) {
			largestFactor = Math.abs(arr[0]);
		}else {
		int smallestNum = min(Math.abs(arr[0]), Math.abs(arr[1]));
			for(int i = 1;i <= smallestNum; i++) {
				if(isDivisibleBy(Math.abs(arr[0]), i) &&  isDivisibleBy(i, Math.abs(arr[1]))) {
					if(largestFactor < i) {
						largestFactor = i;
					}
				}
			}
		}
		return largestFactor;
	}
    //Accepts two integers and returns a boolean
    //Find out of two numbers are divisible 
    public static boolean isDivisibleBy(int number1, int number2) {
		if(number2 ==0) {
			throw new IllegalArgumentException("Can't divide by 0");
		}else {
			if(number1%number2 == 0 || number2%number1 == 0) {
				return true;
			}else {
				return false;
			}
		}
	}
    //Accepts two integers and returns an integer
    //Find the min of the two numbers
    public static int min(int number1, int number2) {
		if(number1 <= number2) {
			return number1;
		}else {
			return number2;
		}
	}
    //Accepts two integers and returns a string
    //Creates a mixed fraction from improper fraction
    public static String toMixedNum(int numerator, int denominator) {
		int whole_number = numerator/ denominator;
		int newNumerator = 0;
		if(whole_number <0 ) {
			newNumerator = Math.abs(numerator%denominator);
		}else if(whole_number > 0){
			newNumerator = Math.abs(numerator%denominator);
		}else {
		    newNumerator = numerator%denominator;
		}
		return (whole_number + "_" + newNumerator + "/" + Math.abs(denominator));
	}
    //Accepts an integer and an array of integers and returns a string
    //Checks error of a fraction to simplify and avoid other errors 
    public static String checkErrors(int simplifyValue, int []arr) {
    	String newFrac = "";
    	if(simplifyValue != 0) {
    		newFrac = (arr[0]/simplifyValue+"/"+arr[1]/simplifyValue);
		}else {
			newFrac = (arr[0]+"/"+arr[1]);
		}
    	if(Math.abs(arr[0])> Math.abs(arr[1])) {
    		String fracArr[] = newFrac.split("/");
    		newFrac = toMixedNum(Integer.parseInt(fracArr[0]), Integer.parseInt(fracArr[1]));
    		String mixedArr[] = newFrac.split("_");
    		String fracArr2[] = mixedArr[1].split("/");
    		if(Integer.parseInt(fracArr2[0]) == 0){
    			newFrac = mixedArr[0];
    		}
    	}
    	return newFrac;
    }
}