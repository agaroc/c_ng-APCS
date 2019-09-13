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
	/*returns values of the discriminant of the coefficents a,b,c of a quadradtic formula
	 * Accepts 3 doubles and returns one double
	 */
	public static double discriminant(double a, double b, double c) {
		return (b*b)-(4*a*c);
	/*converts mixed number into a improper fraction
	 * accepts 3 ints(from the order of whole number, numerator, and denominator) and returns a string
	 */
	}
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int newNumerator = whole*denominator+numerator;
		return (newNumerator + "/" + denominator);
	}
	/*converts improper fraction into mixed number 
	 * accepts two intergers(from the order of numerator and denominator and returns a string
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
		return (numberA+variable + '+' + numberB+variable + '+' + numberC);
	}
	/* takes two numbers and sees if it is divisble if it is return true otherwise false
	 * Accepts two intgers and returns boolean
	 */
	public static boolean isDivisibleBy(int number1, int number2) {
		if(number1%number2 == 0 || number2%number1 == 0) {
			return true;
		}else {
			return false;
		}
	}
	/* takes one number and does the absolute value of the number
	 * takes one double and reutrns a double
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
	 * take two intergers and returns an int
	 */
	public static int min(int number1, int number2) {
		if(number1 <= number2) {
			return number1;
		}else {
			return number2;
		}
	}
	/* takes one double and rounds it to the hundereth place
	 * Accepts one double and returns a double
	 */
	public static double round2(double number) {
		double lastDigit = (number*1000)%10;
		double result = number*100;
		if(lastDigit>=5) {
			result+=0.5;
		}
		result = (int)result;
		return result/100;
	}
	/*raises a positive interger power.
	 * Accepts a double and an integer and reutrns double
	 */
	public static double exponent(double number, int powerNumber) {
		double result = number;
		if(powerNumber == 0) {
			result = 1;
		}else {
			for(int i = 1; i < powerNumber; i++) {
				result *= number;
			}
		}
		return result;
	}
	/*returns factorial of value passed
	 * method accepts integer and returns a integer
	 */
	public static int factorial(int number) {
		int startNumber = 1;
		for (int i = 1; i <= number; i++) {
			startNumber *= i;
		}
		return startNumber;
	}
	/* find if the number is prime or not
	 * njwnd
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
		int largestNum = 0;
		int largestFactor = 0;
		if(number1 > number2) {
			largestNum = number1;
		}else {
			largestNum = number2;
		}
		for(int i = 1;i < largestNum; i++) {
			if(isDivisibleBy(number1, i) &&  isDivisibleBy(i, number2)) {
				if(largestFactor < i) {
					largestFactor = i;
				}
			}
		}
		return largestFactor;
	}
	public static double sqrt(double number) {
		int guess = 1;
		double result = 1;
		while(absValue(result*result - number) < 0.005 != true) {
			result = 0.5*((number/ guess) + guess);
			guess++;
		}
		return round2(result);
	}
}
