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
		String topHour = "";
		topHour += "|";
		for(int quote = 1; quote <= size; quote++) {
			topHour += ("\"");
		}
		topHour += ("|\n");
		if(size%2!=0) {
			size++;
		}
		for(int line = 1; line < size/2; line++) { 
			for(int space = 0; space < line; space++) {
				topHour += (" ");
			}
				topHour+=("\\");
				for(int colon = 0; colon <= (-2*line+size); colon++) {
					topHour += (":");
				}
				topHour += ("/\n");
		}
		System.out.print(topHour);
	}
	public static void Bottom(int size) {
		String bottomHour = "";
		for(int line = size/2 ; line > 0; line--) {
			for(int space = 0; space < line; space++) { 
				bottomHour +=(" ");
			}
			if(line == size/2) {
				if(size % 2 ==0) {
					bottomHour += ("||\n");
				}else {
					bottomHour += ("|||\n");
				}
			}else {
				bottomHour+=("/");
				for(int colon = 1; colon <= (-2*line+size); colon++) {
					bottomHour+=(":");
				}
				bottomHour+= ("\\\n");
			}
		}
		bottomHour+=("|");
		for(int quote = 1; quote <= size; quote++) {
			bottomHour+=("\"");
		}
		bottomHour+=("|");
		System.out.println(bottomHour);
	}
}
