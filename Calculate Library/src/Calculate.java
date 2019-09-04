
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
	public static double toDegrees(double number) {
		double pi = 3.14159;
		return number*(pi/180.00);
	}
	public static double toRadians(double number) {
		double pi = 3.14159;
		return number*(180.0/pi);
	}
}
