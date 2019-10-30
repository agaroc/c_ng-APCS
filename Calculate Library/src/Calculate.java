/*Caleb Ng
 * 8/29/19
 * 4th Period
 * Does calculations from Access Calculate
 */
public class Calculate {
	/* returns the square of value passed
	 * Accepts and return int
	 */
	public static int square(int number) {
		return number*number;
	}
	/* returns the cube of value passed
	 * Accepted and returns int
	 */
	public static int cube(int number) {
		return number*number*number;
	}
	/* returns the average of two values passed
	 * Accepts two ints and returns an int
	 */
	public static double average(double number1, double number2) {
		return (number1 + number2)/2;
	}
	/* returns the average of three value passed
	 * Accepts three ints and returns an int
	 */
	public static double average(double number1, double number2, double number3) {
		return (number1+number2+number3)/3;
	}
	/* returns the degree of a radian passed
	 * Accept one double
	 */
	public static double toDegrees(double radian) {
		double pi = 3.14159;
		return radian*(180/pi);
	}
	
	/* returns the radian of a degree passed
	 * Accepts one double
	 */
	public static double toRadians(double degree) {
		double pi = 3.14159;
		return degree*(pi/180);
	}
	/*returns values of the discriminant of the coefficents a,b,c of a quadratic formula
	 * Accepts 3 doubles and returns one double
	 */
	public static double discriminant(double a, double b, double c) {
		return  (b*b)-(4*a*c);
	/*converts mixed number into a improper fraction
	 * accepts 3 ints(from the order of whole number, numerator, and denominator) and returns a string
	 */
	}
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int newNumerator = whole*denominator+numerator;
		return (newNumerator + "/" + denominator);
	}
	/*converts improper fraction into mixed number 
	 * accepts two integers(from the order of numerator and denominator and returns a string
	 */
	public static String toMixedNum(int numerator, int denominator) {
		int whole_number = numerator/ denominator;
		int newNumerator = numerator%denominator;
		return (whole_number + "_" + newNumerator + "/" + denominator);
	}
	/* converts binominal(form (ax+b)(cx+d)) into a quadratic form (ax^2 +bx+c)) 
	 * accepts four ints and a string, returns a string
	 */
	public static String foil(int a, int b, int c, int d, String variable) {
		int numberA = a * c;
		int numberB = (a*d) + (b*c);
		int numberC = d*b;
		return (numberA+variable+"^2" + " + " + numberB+variable + " + " + numberC);
	}
	/* takes two numbers and sees if it is divisble if it is return true otherwise false
	 * Accepts two integers and returns boolean
	 */
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
	/* takes one number and does the absolute value of the number
	 * takes one double and returns a double
	 */
	public static double absValue(double number) {
		if(number <=0 ) {
			return number *= -1;
		}else {
			return number;
		}
	}
	/* takes two numbers and determines the larger value of the two numbers
	 * takes two doubles and returns a double
	 */
	public static double max(double number1, double number2) {
		if(number1 >= number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/* takes three numbers and determines the larger value of the three numbers
	 * take three doubles and returns a double
	 */
	public static double max(double number1, double number2, double number3) {
		if(number1 >= number2 && number1 >=3){
			return number1;
		}else if(number2 >= number1 && number2 >= number3) {
			return number2;
		}else {
			return number3;
		}	
	}
	/* take two numbers and determines the lowest value of the two number
	 * take two integers and returns an int
	 */
	public static int min(int number1, int number2) {
		if(number1 <= number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/* takes one double and rounds it to the hundreth place
	 * Accepts one double and returns a double
	 */
	public static double round2(double number) {
		if(number >= 0) {
			number = (number*100)+0.5;
			number = (int)number;
			return number/100;
		}else {
			number = (number*100) - 0.5;
			number = (int) number;
			return number/100;
		}
	}
	/*raises a positive interger power.
	 * Accepts a double and an integer and reutrns double
	 */
	public static double exponent(double number, int powerNumber) {
		double result = number;
		if(number == 0) {
			throw new IllegalArgumentException("Base can't be 0");
		}
		if(powerNumber < 0) {
			for(int i = 1; i > (powerNumber); i--) {
				result /= number;
			}
		}else {
			if(powerNumber == 0) {
				result = 1;
			}else {
				for(int i = 1; i < powerNumber; i++) {
					result *= number;
				}
			}
		}
		return result;
	}
	/*returns factorial of value passed
	 * method accepts integer and returns a integer
	 */
	public static int factorial(int number) {
		int result = 1;
		if(number >= 0) {
			for (int i = 1; i <= number; i++) {
				result *= i;
			}
		}else {
			throw new IllegalArgumentException("Can't do factorial of a nergative number");
		}
		return result;
	}
	/* find if the number is prime or not
	 * accepts integer and returns boolean
	 */
	public static boolean isPrime(int number) {
		int times = number;
		boolean flag = true;
		if(number == 0) {
			return false;
		}
		for(int i = 1;i <= times/2; i++) {
			if(isDivisibleBy(number, i) && i != number && i != 1) {
				flag = false;
			}else {
				flag = true;
			}
		}
		return flag;
	}
	/* finds the greatest common factor of two integers
	 * accepts two integers and returns one integer
	 */
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
/* returns the square root of a given positive number and rounds to the 2 decimal
 * Accepts a double and returns a double
 */
	public static double sqrt(double number) {
		double guess = 1.0;
		if(number < 0) {
			throw new IllegalArgumentException("Can't square root negative");
		}
		if(number==0) {
			guess = 0.0;
		}else {
			while(absValue(guess*guess - number) > 0.005) {
				guess = (number/guess + guess)/2;
			}
		}
		return round2(guess);
	}
	/*Does the quadratic equation of the coeff of a quadratic in standard form. Helps to find roots of a quadratic
	 * Accepts 3 integers returns string 
	 */
	public static String quadForm(int a, int b, int c) {
		double root1 = 0;
		double root2 = 0;
		if(discriminant(a, b, c) < 0) {
			return "No real roots";
		}else if(discriminant(a,b,c) == 0) {
			root1 = round2((-b+(sqrt(discriminant(a,b,c))))/(2*a));
			return (""+root1);
		}else {
			root1 = round2((-b+(sqrt(discriminant(a,b,c))))/(2*a));
			root2 = round2((-b-(sqrt(discriminant(a,b,c))))/(2*a));
			double maxRoot = max(root1, root2);
			if(root1 == maxRoot) {
				return(root2 + " and " + maxRoot);
			}else {
				return(root1 + " and " + maxRoot);
			}
		}
	}
}
