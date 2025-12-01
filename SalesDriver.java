package ec2;
import java.util.Scanner;

public class SalesDriver {
	static Scanner in = new Scanner(System.in);
	
	public SalesDriver() {
		//Default Constructor
	}

	public static void main(String[] args) {
		username = "name";
		path = "/Users/" + username + "/GitHub/Sales_Analysis/Salesdata.txt"
		SalesDriver s1 = new SalesDriver(); 
		FileIO a1 = new FileIO(path);
		Franchise f = a1.readData();
		
		System.out.printf("Welcome back, [user1] \n");
		System.out.printf("The Franchise App has been updated. \n");
		System.out.printf("The app now has the sales data for 6 stores for the last 5 weeks. \n");
		System.out.printf("Would you like to view the data? (\"yes\" or \"y\" to continue) ");
		switch (in.next().toLowerCase()) {
			case "yes":
			case "y":
				f.calc();
				s1.app(f); break;
			default: 
				System.out.printf("Affirmative. Thank you for choosing our app! Have a nice day.");
				break;
		}
	}
	
	public void app(Franchise f) {
		boolean run = true;
		Store store = null;
		int storeNum, selection;
		
		while (run) {
			storeNum = selectStore();
			switch (storeNum) {
				case -1: return;
				default: break;
			}
			store = f.getStores(storeNum-1); 
			selection = Options();
			
			store.print(selection);
			if (selection == 0) {
				return;
			}
			
			System.out.printf("Would you like to continue? (\"yes\" or \"y\" to continue) ");
			switch (in.next().toLowerCase()) {
				case "yes":
				case "y":
					break;
				default:
					System.out.printf("Affirmative. Thank you for choosing our app! Have a nice day.");
					run = false;
					return;
			}
		}
	}
	
	public int selectStore() {
		boolean selecting = true;
		int storeNum;
		
		while (selecting) {
			System.out.printf("Select a store # (1-6) you want to see analytics for");
			System.out.printf("(enter 0 to quit): ");
			storeNum = in.nextInt();
			if (storeNum == 0) {
				System.out.printf("Affirmative. Thank you for choosing our app! Have a nice day.");
				return -1;
			} else if (storeNum >= 1 && storeNum <= 6) {
				return storeNum;
			} else {
				System.out.printf("Error, invalid store #\n");
			}
		}
		return -1;
	}
	
	public int Options() {
		int selection = 0;
		
		System.out.printf("Operations: \n");
		System.out.printf("\tEnter 1 for all uncalculated data. \n");
		System.out.printf("\tEnter 2 for total sales for each week. \n");
		System.out.printf("\tEnter 3 for average daily sales for each week. \n");
		System.out.printf("\tEnter 4 for total sales for all weeks. \n");
		System.out.printf("\tEnter 5 for average weekly sales. \n");
		System.out.printf("\tEnter 6 for week with the highest amount in sales. \n");
		System.out.printf("\tEnter 7 for week with the lowest amount in sales. \n");
		System.out.printf("\tEnter 8 for all analytical data. \n");
		System.out.printf("\tEnter 0 to quit. \n");
		System.out.printf("Selection: ");
		selection = in.nextInt();
		
		while (selection != 0) {
			if (selection >= 0 && selection <= 8) {
				return selection;
			} else {
				System.out.printf("Invalid response. Please select an operation: ");
				selection = in.nextInt();
			}
		}
		return selection;
	}
}
