/*Caleb Ng
 * 1/10/19
 * Frac Calc but using object orientation  
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args){
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
    public static int[] produceSplit(String[]arr, int length) {
    	String frac[] = {};
    	int result[] = {0, 0, 1};
    	if(arr.length == 2) {
	    	result[0] = Integer.parseInt(arr[0]);
	    	frac = arr[1].split("/");
	    	result[1] = Integer.parseInt(frac[0]);
	    	result[2] = Integer.parseInt(frac[1]);
	    }else if(length == 2){
	    	frac = arr[0].split("/");
	    	result[2] = Integer.parseInt(frac[1]);
	    	result[1] = Integer.parseInt(frac[0]);
	    }else {
	    	result[0] = Integer.parseInt(arr[0]);
	    }
    	return result;
    }
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
    public static int min(int number1, int number2) {
		if(number1 <= number2) {
			return number1;
		}else {
			return number2;
		}
	}
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
}
