/*Caleb Ng
 * 10/9/19
 * Creates an hourglass
 */
public class Hourglass {
	public static void main(String[]args) {
		Top(10);
		Bottom();
	}
	public static void Top(int size) {
		System.out.print("|");
		for(int quote = 1; quote <= size; quote++) {
			System.out.print ("\"");
		}
		System.out.print("|");
		for(int line = 1; line <= 5; line++) {
			System.out.println();
			for(int space = 0; space < line; space++) {
				System.out.print(" ");
			}
			if(line == 5) {
				System.out.print("||");
			}else {
				System.out.print("\\");
				for(int colon = 1; colon <= (-2*line+10); colon++) {
					System.out.print(":");
				}
				System.out.print("/");
			}
		}
	}
	public static void Bottom() {
		for(int line = 1; line <= 5; line++) {
			System.out.println();
			for(int space = line; space >= line; space--) { // error
				System.out.print(" ");
			}
			System.out.print("/");
			for(int colon = 1; colon <= (2*line); colon++) {
				System.out.print(":");
			}
			System.out.print("\\");
		}
	}
}
