package viewui;

import java.util.Scanner;

import model.Inventory;
import model.IEmployeeDAO;
import model.datastore.mysql.InventoryDAO;

/**
 * @author John Phillips
 * @version 20151015
 * 
 */
public class InventoryApp {

	IEmployeeDAO invenList = new InventoryDAO();
	Scanner sc = new Scanner(System.in);

	public InventoryApp() {
		menuLoop();
	}

	private void menuLoop() {
		int id, quantity;
		String item, last, first, phone;
		double price;
		String choice = "1";
		while (!choice.equals("0")) {
			System.out.println("\nInventory App");
			System.out.println("0 = Quit");
			System.out.println("1 = List All Records");
			System.out.println("2 = Create New Record");
			System.out.println("3 = Retrieve Record");
			System.out.println("4 = Update Record");
			System.out.println("5 = Delete Record");
			choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

			switch (choice) {
			case "1":
				System.out.println(invenList.toString());
				break;
			case "2":
				id = Validator.getInt(sc, "New item ID: ");
				item = Validator.getLine(sc, "Item name: ");
				last = Validator.getLine(sc, "Last name: ");
				first = Validator.getLine(sc, "First name: ");
				phone = Validator.getLine(sc, "Home phone number: ");
				quantity = Validator.getInt(sc, "Quantity: ");
				price = Validator.getDouble(sc, "Price of Item: ");
				invenList.createRecord(new Inventory(id, item, last, first, phone, quantity, price));
				break;
			case "3":
				id = Validator.getInt(sc, "Employee id to retrieve: ");
				System.out.println(invenList.retrieveRecordById(id));
				break;
			case "4":
				id = Validator.getInt(sc, "Item ID to update: ");
				item = Validator.getLine(sc, "Item name: ");
				last = Validator.getLine(sc, "Last name: ");
				first = Validator.getLine(sc, "First name: ");
				phone = Validator.getLine(sc, "Home phone number: ");
				quantity = Validator.getInt(sc, "Quantity: ");
				price = Validator.getDouble(sc, "Price of Item: ");
				invenList.updateRecord(new Inventory(id, item, last, first, phone, quantity, price));
				break;
			case "5":
				id = Validator.getInt(sc, "Item ID to delete: ");
				System.out.println(invenList.retrieveRecordById(id));
				String ok = Validator.getLine(sc, "Delete this record? (y/n) ", "^[yYnN]$");
				if (ok.equalsIgnoreCase("Y")) {
					invenList.deleteRecord(id);
				}
				break;
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new InventoryApp();
	}
}
