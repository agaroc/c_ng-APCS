/*
 * Caleb Ng
 * Started 2/5/2020
 * Practice for inheritence 
 */
import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) 
	{
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		Traveler[] party1 = {frodo, sam, gimli};
		for(Traveler character: party1) {
			character.travel(50);
			System.out.println(character.getName()+" has traveled "+ character.getDistanceTraveled()+" miles.");
		}
		// Then, use a loop to make all travelers go a distance of 50 miles  
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		//    traveled in miles.  (In the next piece, you'll do this in methods, but 
		//    for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		
		
		
		
		
		
		System.out.println();
		System.out.println("\n\n\nPART 2: \n");

		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin",
		"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};

		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		// Make a new Hobbit called "Bilbo" and add him to party2
		Hobbit bilbo = new Hobbit("Bilbo");
		ArrayList <Traveler> party2 = new ArrayList <Traveler>();
		party2.add(bilbo);
		Wizard gandalf = new Wizard("Gandalf", "Grey");
		party2.add(gandalf);
		// Make a new Wizard called "Gandalf" and add him to party2.
		createParty(party2, dwarfNames);
		allTravel(party2, 100);
		//write createParty
		// Call the createParty method and pass it party2 and the dwarfNames array.

		// create party should add all the new dwarves to party2,

		//Write allTravel
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.

		//Make sure your code prints out the name and distances party2 has traveled.
	}
	/* Accepts an arraylist of travelers and an integer
	 * Makes all travelers travel the integer amount of miles
	 */
	private static void allTravel(ArrayList<Traveler> party2, int i) {
		for(Traveler name: party2) {
			name.travel(i);
			System.out.println(name.getName() +" has traveled " + name.getDistanceTraveled()+ " miles.");
		}
	}
	/* Aceepts an arraylist of travelers and an arraylist of strings
	 * adds the strings to the arraylist of travlers
	 */
	private static void createParty(ArrayList<Traveler> party2, String[] dwarfNames) {
		ArrayList <Traveler> hobbitList = new ArrayList <Traveler>();
		for(String name: dwarfNames) {
			Dwarf temp1 = new Dwarf(name);
			hobbitList.add(temp1);
		}
		for(Traveler name: hobbitList) {
			party2.add(name);
		}
	}

	
}
