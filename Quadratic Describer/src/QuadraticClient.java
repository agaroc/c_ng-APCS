/*Caleb Ng
 * 9/25/19
 * Ask for user input for coefficents of a quadratic equation, and using class quadratic describes the graph
 */
import java.util.Scanner;
public class QuadraticClient {
	public static void main(String[] args) {
		double a = 0;
		double b = 0;
		double c = 0;
		String stringResume = "";
		String stop = "quit";
		Scanner inputScanner = new Scanner(System.in);
		do {
			System.out.println("Welome to the Quadratic Describer");
			System.out.println("Provide values for coefficients a,b,and c");
			System.out.print("a:");
			a = inputScanner.nextDouble();
			System.out.print("b:");
			b = inputScanner.nextDouble();
			System.out.print("c: ");
			c = inputScanner.nextDouble();
			System.out.println(Quadratic.QuadraticDescriber(a, b, c));
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			stringResume = inputScanner.next();
		}while(stringResume.equals(stop) != true); 	
	}	
}
