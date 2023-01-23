import java.util.*;
public class HouseInventoryApp {
	public static void main(String[] args) {
		
		HouseInventory inventory = new HouseInventory();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome!");
		int choice = 0;
		System.out.println();
		while (choice!=7) {
			System.out.println("------ MENU ------");
			System.out.println("1. Add a house");
			System.out.println("2. Edit a house");
			System.out.println("3. Delete a house");
			System.out.println("4. Display all houses below a certain price");
			System.out.println("5. Cheapest House");
			System.out.println("6. Display Houses with the Same Price (Duplicates)");
			System.out.println("7. Exit");
			System.out.print("Enter option: ");
			choice = input.nextInt();
			System.out.println();
			switch(choice) {
			case 1:
				boolean status;
				System.out.print("Enter House ID: #");
				int id = input.nextInt();
				System.out.print("Enter House Price: $");
				double price = input.nextDouble();
				System.out.print("Is the house available for sale (Y/N)? ");
				String available = input.next().toUpperCase();
				System.out.println();
				if (available.equals("Y")) { 
					status = true;
					inventory.Add(new House(price, id, status));
				}
				else {
					status = false;
					inventory.Add(new House(price, id, status));
				} 
				System.out.println("House succssfully added to inventory!");
				System.out.println();
				break;
			case 2: 
				System.out.print("Enter House ID: #");
				id = input.nextInt();
				System.out.print("Enter House Price: $");
				price = input.nextDouble();
				inventory.Edit(id, price);
				break;
			case 3:
				System.out.print("Enter House ID: #");
				id = input.nextInt();
				System.out.println();
				if (inventory.Delete(id) == 1) {
					System.out.println("House successfully deleted!");
					System.out.println();
				}
				break;
			case 4:
				System.out.print("Enter Price: $");
				price = input.nextDouble();
				System.out.println();
				House[] houses = inventory.HousesBelowPrice(price);
				for (int i = 0; i<houses.length; i++) {
					if (houses[i]!=null) {
						houses[i].tostring();
						System.out.println();
					} 
				}
				break;
			case 5:
				int cheapest = inventory.findMin();
				if (cheapest == 0) {
					System.out.println("There are currently no houses!");
					System.out.println();
				} else {
					System.out.println("Cheapest House ID: #" + cheapest);
					System.out.println();
				}
				break;
			case 6:
				inventory.housesWithSamePrice();
				break;
			case 7:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Try again!");
				System.out.println();
			}
		}
	}
}

	
