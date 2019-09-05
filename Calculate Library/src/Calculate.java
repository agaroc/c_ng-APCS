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
	public static String foil(int a, int b, int c, int d, char x) {
		int numberA = a * c;
		int numberB = (a*d) + (b*c);
		int numberC = d*b;
		String variable = "" + x;
		return (numberA+variable + numberB+variable + numberC);
	}
	
}
