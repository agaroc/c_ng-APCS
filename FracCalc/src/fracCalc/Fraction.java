/*
 * Caleb Ng
 * 1/13/19
 * Creates the object fraction and can do calculations on two fractions
 */
package fracCalc;
import java.util.*;
public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;
	public void fractionString(String fraction) {
		String [] opperand =  fraction.split("_");
		this.whole = Integer.parseInt(opperand[0]); 
		String [] opperand2 = opperand[1].split("/");
		this.denominator = Integer.parseInt(opperand2[1]);
		this.numerator = Integer.parseInt(opperand2[0]);
	}
	public void fractionInt(int whole, int denominator, int numerator) {
		this.whole = whole;
		this.denominator = denominator;
		this.numerator = numerator;
	}
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
	public static String multiplyOrDivide(int[] arr1, int[] arr2, String operation) {
	   int [] fracArr = {0,0};
	   if(operation.equals("*")) {
		   fracArr[0] = arr1[0]* arr2[0];
	       fracArr[1] = arr1[1]* arr2[1];
	   }else {
	       fracArr[0] = (arr1[0] * arr2[1]);
	       fracArr[1] = (arr1[1] * arr2[0]);
	   }
	   int simplifyValue = FracCalc.gcf(fracArr);
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
	public static String arithmetic(int [] arr1, int [] arr2, String operation) {
	    int commonDenom = arr2[1] * arr1[1];
	    int [] fracArr = {0,commonDenom};
	    if(operation.equals("+")) {
	    	fracArr[0] = (arr1[0]*arr2[1]) + (arr2[0]*arr1[1]);
	    }else{
	    	fracArr[0] = (arr1[0]*arr2[1])-(arr1[1]*arr2[0]);
	    }
	    int simplifyValue = FracCalc.gcf(fracArr);
	    String newFrac = checkErrors(simplifyValue, fracArr);
	    if(fracArr[0] == 0) {
	    	newFrac = "0";
	    }else if(fracArr[0] == commonDenom) {
	    	String [] tempArr = newFrac.split("/");
	    	newFrac = tempArr[0];
	    }
	    return newFrac;
	}
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
