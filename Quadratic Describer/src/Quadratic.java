/*Caleb Ng
 * 9/25/19
 * 
 *  Takes in the coef of a quadratic standard equation and returns the direction it opens, vertex, and intercepts, and the equation
 * Takes in 3 doubles returns a string
 */
public class Quadratic {
	public static String QuadraticDescriber(double a, double b, double c ) {
		String direction = "";
		if(a > 0) {
			direction = "Opens: Up";
		}else if(a < 0) {
			direction = "Opens: Down";
		}else {
			direction = "This is not a quadratic";
		}
		double xVertex = round2((-b) / (2 * a));
		double yVertex = round2((a*(xVertex*xVertex)) + (b*xVertex) + c);
		String vertex = ("(" + xVertex +',' + yVertex +')');
		String roots = quadForm(a,b,c);
		String yIntercept = ("y-intercept: " + c);
		String equation = ("y= " +a+ "x^2" + '+' + b+'x' + '+' + c);
		String output = ("Description of the graph \n" + equation + "\n" + "\n" + direction + "\n" + "Axis of Symmetry: " + xVertex + "\n" + "Vertex: " + vertex + "\n" + 
				"x-intercept(s): " + roots + "\n" + yIntercept);
		return output;
	}

	public static double discriminant(double a, double b, double c) {
		return  (b*b)-(4*a*c);
	}
	public static double absValue(double number) {
		if(number <=0 ) {
			return number *= -1;
		}else {
			return number;
		}
	}
	public static double round2(double number) {
		if(number >= 0) {
			number = (number*100)+0.5;
			number = (int)number;
			return number/100;
		}else {
			number = (number +100) - 0.5;
			number = (int) number;
			return number/100;
		}
	}
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
	public static String quadForm(double a, double b, double c) {
		double root1 = round2((-b+(sqrt(discriminant(a,b,c))))/(2*a));
		double root2 = round2((-b-(sqrt(discriminant(a,b,c))))/(2*a));
		if(discriminant(a, b, c) < 0) {
			return "No real roots";
		}else if(discriminant(a,b,c) == 0) {
			return (root1 + "");
		}else {
			return (root1 + "and" + root2);
		}
	}
}
