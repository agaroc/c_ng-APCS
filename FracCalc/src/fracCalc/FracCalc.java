package fracCalc;
import java.util.*;
public class FracCalc {

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
    	String displayNums = ("whole:"+valueFrac1[0]+ " numerator:"+valueFrac1[1]+" denominator:"+valueFrac1[2] +"\nwhole:"+valueFrac2[0]+ " numerator:"+valueFrac2[1]+ " denominator:"+valueFrac2[2]);
    	String [] improper1 = toImproperFrac(valueFrac1[0], valueFrac1[1], valueFrac1[2]);
    	String [] improper2 = toImproperFrac(valueFrac2[0], valueFrac2[1], valueFrac2[2]);
    	if(opperand2.equals("*") || opperand2.equals("/")) {
        	result = multiplyOrDivide(Integer.parseInt(improper1[0]), Integer.parseInt(improper1[1]), Integer.parseInt(improper2[0]), Integer.parseInt(improper2[1]), opperand2);

    	}else {
    		result = arithmetic(Integer.parseInt(improper1[0]), Integer.parseInt(improper1[1]), Integer.parseInt(improper2[0]), Integer.parseInt(improper2[1]), opperand2);
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
    public static String [] toImproperFrac(int whole, int numerator, int denominator) {
		int newNumerator = whole*denominator+numerator;
		String frac = (newNumerator + "/" + denominator);
		String [] splitFrac = frac.split("/");
		return splitFrac;
	}
    public static String arithmetic(int numerator1, int denominator1, int numerator2, int denominator2, String operation) {
    	int commonDenom = denominator2 * denominator1;
    	int simplifyValue = 0;
    	int newNumerator = 0;
    	int commonMultiplier1 = gcf(denominator1, commonDenom);
    	int commonMultiplier2 = gcf(denominator2, commonDenom);
    	String newFrac = "";
    	if(operation.equals("+")) {
    		newNumerator = (numerator1*commonMultiplier2) + (numerator2*commonMultiplier1);
    		simplifyValue = gcf(newNumerator, commonDenom);
    		newFrac = checkSimplifyValue(simplifyValue, newNumerator, commonDenom);
    	}else{
    		newNumerator = (numerator1*commonMultiplier2)-(commonMultiplier1*numerator2);
    		simplifyValue = gcf(newNumerator, commonDenom);
    		newFrac = checkSimplifyValue(simplifyValue, newNumerator, commonDenom);
    	}
    	if(Math.abs(newNumerator)> Math.abs(commonDenom)) {
    		newFrac = toMixedNum(newNumerator/simplifyValue, commonDenom/simplifyValue);
    	}
    	return newFrac;
    }
    public static String multiplyOrDivide(int numerator1, int denominator1, int numerator2, int denominator2, String operation) {
    	String newFrac = "";
    	int newNumerator = 0;
    	int newDenominator = 0;
    	int simplifyValue = 0;
    	if(operation.equals("*")) {
    		newNumerator = numerator1* numerator2;
    		newDenominator = denominator1*denominator2;
    		simplifyValue = gcf(newNumerator, newDenominator);
    		newFrac = checkSimplifyValue(simplifyValue, newNumerator, newDenominator);
    	}else {
    		newNumerator = numerator1 * denominator2;
    		newDenominator = denominator1 * numerator2;
    		simplifyValue = gcf(newNumerator, newDenominator);
    		newFrac = checkSimplifyValue(simplifyValue, newNumerator, newDenominator);
    	}
    	if(Math.abs(newNumerator)> Math.abs(newDenominator)) {
    		String fracArr[] = checkSimplifyValue(simplifyValue, newNumerator, newDenominator).split("/");
    		newFrac = toMixedNum(Integer.parseInt(fracArr[0]), Integer.parseInt(fracArr[1]));
    		String mixedArr[] = newFrac.split("_");
    		if(Integer.parseInt(fracArr[0]) == 0){
    			newFrac = mixedArr[0];
    		}
    	}
    	return newFrac;
    }
    public static int gcf(int number1, int number2) {
		int smallestNum = 0;
		int largestFactor = 0;
		if(number1 == 0) {
			largestFactor = number2;
		}else if(number2 == 0) {
			largestFactor = number1;
		}else {
		 smallestNum = min(number1, number2);
			for(int i = 1;i <= smallestNum; i++) {
				if(isDivisibleBy(number1, i) &&  isDivisibleBy(i, number2)) {
					if(largestFactor < i) {
						largestFactor = i;
					}
				}
			}
		}
		return largestFactor;
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
    public static int min(int number1, int number2) {
		if(number1 <= number2) {
			return number1;
		}else {
			return number2;
		}
	}
    public static String toMixedNum(int numerator, int denominator) {
		int whole_number = numerator/ denominator;
		int newNumerator = numerator%denominator;
		return (whole_number + "_" + newNumerator + "/" + denominator);
	}
    public static String checkSimplifyValue(int simplifyValue, int numerator, int denominator) {
    	String newFrac = "";
    	if(simplifyValue != 0) {
    		newFrac = (numerator/simplifyValue+"/"+denominator/simplifyValue);
		}else {
			newFrac = (numerator+"/"+denominator);
		}
    	return newFrac;
    }
    public static String checkMixed(int simplifyValue)
	    if(Math.abs(newNumerator)> Math.abs(newDenominator)) {
			String fracArr[] = checkSimplifyValue(simplifyValue, newNumerator, newDenominator).split("/");
			newFrac = toMixedNum(Integer.parseInt(fracArr[0]), Integer.parseInt(fracArr[1]));
			String mixedArr[] = newFrac.split("_");
			if(Integer.parseInt(fracArr[0]) == 0){
				newFrac = mixedArr[0];
			}
		}
}