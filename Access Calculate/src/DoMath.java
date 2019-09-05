/*
 * Caleb Ng
 * 8/30/19
 * Calculates math expressions
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(12));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(7,  3));
		System.out.println(Calculate.average(7, 7, 7));
		System.out.println(Calculate.toDegrees(3.14));
		System.out.println(Calculate.toRadians(180.0));
		System.out.println(Calculate.discriminant(1, 6, 9));
		System.out.println(Calculate.toImproperFrac(2, 2, 3));
		System.out.println(Calculate.toMixedNum(8, 3));
		System.out.println(Calculate.foil(1, 3, 1, 3, "x"));
		System.out.println(Calculate.isDivisibleBy(4, 2));
		System.out.println(Calculate.absValue(5.0));
		System.out.println(Calculate.max(3, 7));
		System.out.println(Calculate.max(3, 11, 7));
		System.out.println(Calculate.min(11, 3));
	}
}
