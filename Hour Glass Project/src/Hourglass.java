/*Caleb Ng
 * 10/9/19
 * Creates an hourglass
 */
import java.util.*;
public class Hourglass {
	public static void main(String[]args) {
		boolean flag = true;
		String quit = "";
		Scanner userInput = new Scanner(System.in);
		do {
			System.out.print("What size hourglass do you want?(Enter an integer) ");
			int size = userInput.nextInt();
			Top(size);
			Bottom(size);
			System.out.print("Do you want to stop(type stop to quit)");
			quit = userInput.nextLine();
		} while(quit.equals("stop")!= true);	
	public static void Top(int size) {
		String topHour = "";
		topHour += "|";
		for(int quote = 1; quote <= size; quote++) {
			topHour += ("\"");
		}
		topHour += ("|\n");
		int topNum = size;
		if(size%2!=0) {
			topNum++;
		}else {
			topNum++;
		}
		for(int line = 1; line < topNum/2; line++) { 
			for(int space = 0; space < line; space++) {
				topHour += (" ");
			}
				topHour+=("\\");
				for(int colon = 1; colon <= (-2*line+topNum)-1; colon++) {
					topHour += (":");
				}
				topHour += ("/\n");
		}
		System.out.print(topHour);
	}
	public static void Bottom(int size) {
		String bottomHour = "";
		int middleNum = size;
		int bottomNum = size;
		if(size%2!=0) {
			middleNum = size;
			bottomNum++;
		}else {
			bottomNum++;
		}
		for(int line = bottomNum/2 ; line > 0; line--) {
			for(int space = 0; space < line; space++) { 
				bottomHour +=(" ");
			}
			if(line == bottomNum/2) {
				if(middleNum % 2 == 0) {
					bottomHour += ("||\n");
				}else {
					bottomHour += ("|\n");
				}
			}else {
				bottomHour+=("/");
				for(int colon = 1; colon <= (-2*line+bottomNum)-1; colon++) {
					bottomHour+=(":");
				}
				bottomHour+= ("\\\n");
			}
		}
		bottomHour+=("|");
		for(int quote = 1; quote <= bottomNum-1; quote++) {
			bottomHour+=("\"");
		}
		bottomHour+=("|");
		System.out.println(bottomHour);
	}
}
