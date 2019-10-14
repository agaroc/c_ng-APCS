/*Caleb Ng
 * 10/9/19
 * Creates an hourglass
 */
import java.util.*;
public class Hourglass {
	public static void main(String[]args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("What size hourglass do you want?(Enter an integer) ");
		int size = userInput.nextInt();
		Top(size);
		Bottom(size);
		userInput.close();
	}
	public static void Top(int size) {
		System.out.print("|");
		for(int quote = 1; quote <= 10; quote++) {
			System.out.print ("\"");
		}
		System.out.print("|");
		for(int line = 1; line < 5; line++) {
			System.out.println();
			for(int space = 0; space < line; space++) {
				System.out.print(" ");
			}
				System.out.print("\\");
				for(int colon = 1; colon <= (-2*line+10); colon++) {
					System.out.print(":");
				}
				System.out.print("/");
		}
	}
	public static void Bottom(int size) {
		for(int line = 5; line > 0; line--) {
			System.out.println();
			for(int space = 0; space < line; space++) { 
				System.out.print(" ");
			}
			if(line == 5) {
				System.out.print("||");
			}else {
				System.out.print("/");
				for(int colon = 1; colon <= (-2*line+10); colon++) {
					System.out.print(":");
				}
				System.out.print("\\");
			}
		}
		System.out.println();
		System.out.print("|");
		for(int quote = 1; quote <= 10; quote++) {
			System.out.print ("\"");
		}
		System.out.println("|");
	}
}
