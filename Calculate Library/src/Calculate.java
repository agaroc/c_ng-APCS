import java.lang.Math;
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
	public static double average(double number, double number2) {
		return (number + number2)/2;
	}
	/* returns the average of three value passed
	 * Accepts three ints and returns an int
	 */
	public static double average(double number, double number2, double number3) {
		return (number+number2+number3)/3;
	}
	/* returns the degree of a radian passed
	 * Accept one double
	 */
	public static double toDegrees(double number) {
		double pi = 3.14159;
		return number*(pi/180.00);
	}
	
	/* returns the radian of a degree passsed
	 * Accepts one double
	 */
	public static double toRadians(double number) {
		double pi = 3.14159;
		return number*(180.0/pi);
	}
	/*returns values of the discriminant of the coefficents of a quadradtic formula
	 * Accepts 3 doubles and returns one double
	 */
	public static double discriminant(double number1, double number2, double number3) {
		double root1 = -number2 + Math.sqrt((number2*number2-4*number1*number3))/(2*number1);
		return root1;
	/*converts mixed number into a improper fraction
	 * accepts 3 ints(from the order of whoe number, numerator, and denominator) and returns a string
	 */
	}
	public static String toImproperFrac(int number1, int number2, int number3) {
		int numerator = number1*number2+number3;
		return (numerator + "/" + number2);
	}
	/*converts improper fraction into mixed number 
	 * accepts two intergers(from the order of numerator and denominator and returns a string
	 */
	public static String toMixedNum(int number1, int number2) {
		int whole_number = number1/ number2;
		double denominator = number1%number2;
		return (whole_number + "_" + denominator);
	}
	/* converts binominal(form (ax+b)(cx+d)) into a quadratic(form (ax^2 +bx+c)) 
	 * accepts four ints and a string, returns a string
	 */
	public static String foil(int number1, int number2, int number3, int number4, char x) {
		int numberA = number1 * number3;
		int numberB = (number1*number4) + (number2*number3);
		int numberC = number4*number2;
		return (numberA+"x" + numberB+"x" + numberC);
	}
}
