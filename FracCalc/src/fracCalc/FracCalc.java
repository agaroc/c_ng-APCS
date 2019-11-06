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
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){
    	String[] splitOpperands = input.split(" ");
    	String opperand1 = splitOpperands[0];
    	String opperand2 = splitOpperands[1];
    	String opperand3 = splitOpperands[2];
    	String[] checkWhole1 = opperand1.split("_");
    	String[] checkWhole2 = opperand3.split("_");
    	int whole2 = 0;
    	int denom2 = 0;
    	int whole1 = 0;
    	int denom1 = 0;
    	int numerator1 = 0;
    	String frac2[] = {};
    	String frac1[] = {};
    	int numerator2 = 0;
    	String[] checkFracLen = opperand3.split("/");
    	if(checkWhole2.length == 2) {
	    	whole2 = Integer.parseInt(checkWhole2[0]);
	    	frac2 = checkWhole2[1].split("/");
	    	numerator2 = Integer.parseInt(frac2[0]);
	    	denom2 = Integer.parseInt(frac2[1]);
	    }else if(checkFracLen.length == 2){
	    	frac2 = checkWhole2[0].split("/");
	    	denom2 = Integer.parseInt(frac2[1]);
	    	numerator2 = Integer.parseInt(frac2[0]);
	    }else {
	    	whole2 = Integer.parseInt(checkWhole2[0]);
	    	denom2 = 1;
	    	numerator2 = 0;
	    }						
    	String result = ("whole:"+whole2+ " numerator:"+numerator2+" denominator:"+denom2);
    	return result;
    }

        // TODO: Implement this function to produce the solution to the input
        
        
  

    // TODO: Fill in the space below with any helper methods that you think you will need

}
