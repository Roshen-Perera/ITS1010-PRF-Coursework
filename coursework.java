import java.util.*;
public class coursework {
	private static Scanner input = new Scanner(System.in);
	private static String[] cred = {"roshen","1234"};
	private static String[][] suppliers = {};
	private static String[] itemCategory = {};	
	private static String[][] items = {};
	private static double[][] doubleItems = {};
	
	public static void clearConsole() {
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // For Unix/Linux/Mac
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            // Exception handling
            ex.printStackTrace();
        }
    }
	public static void loginPage() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                        LOGIN PAGE                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		while(true) {
			System.out.print("User Name : ");
			String userName = input.next();
			boolean isMatched = cred[0].equals(userName);
			if(isMatched) {
				while(true) {
					System.out.println();
					System.out.print("Password : ");
					String userPw = input.next();
					boolean isCorrect = cred[1].equals(userPw);
					if(isCorrect) {
						clearConsole();
						homePage();
						break;
					}else{
						System.out.println("Password is incorrect. Please try again !");
						System.out.println();
					}
				}
				break;
			}else{
				System.out.println("User name is invalid. Please try again !");
				System.out.println();
			}
		}
	}
	public static void homePage() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                       WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                         |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("[1] Change the Credentials                                            [2] Supplier Manage");
		System.out.println("[3] Stock Manage                                                      [4] Log out");
		System.out.println("[5] Exit the System");
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int op = input.nextInt();
		switch(op) {
			case 1:
				clearConsole();
				changeCred();
				break;
			case 2:
				clearConsole();
				supplierManage();
				break;
			case 3:
				clearConsole();
				stockManagement();
				break;
			case 4:
				clearConsole();
				loginPage();
				break;
			case 5:
				clearConsole();
				System.exit(0);
				break;
			default:
				clearConsole();
				System.out.println("Invalid Option");
				break;		
			}
	}
	public static void changeCred() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                 CREDENTIAL MANAGE                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		while(true) {
			System.out.print("Please enter the user name to verify it's you : ");
			String userName = input.next();
			boolean isMatched = userName.equals(cred[0]);
			if(isMatched) {
				System.out.println("Hey danujav");
				while(true) {
					System.out.print("Enter your current password : ");
					String userPw = input.next();
					boolean isCorrect = userPw.equals(cred[1]);
					if(isCorrect) {
						System.out.print("Enter your new password : ");
						String userPw2 = input.next();
						cred[1] = userPw2;
						System.out.println();
						System.out.print("Password changed successfully ! Do you want to go home page ? (Y/N) : ");
						char op = input.next().charAt(0);
						if(op=='Y'|| op=='y') {
							clearConsole();
							homePage();
						}else if(op=='N'|| op=='n') {
							break;
						}
						break;
					}else{
						System.out.println("Incorrect Password. Try again !");
						System.out.println();
					}
				}
				break;
			}else{
				System.out.println("Invalid user name. Try again");
				System.out.println();
			}
		}
	}
	public static void supplierManage() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                   SUPPLIER MANAGE                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("[1] Add Supplier                                            [2] Update Supplier");
		System.out.println("[3] Delete Supplier                                         [4] View Suppliers");
		System.out.println("[5] Search Supplier                                         [6] Home Page");
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int op = input.nextInt();
		switch(op) {
			case 1:
				clearConsole();
				addSupplier();
				break;
			case 2:
				clearConsole();
				updateSupplier();
				break;
			case 3:
				clearConsole();
				deleteSupplier();
				break;
			case 4:
				clearConsole();
				viewSupplier();
				break;
			case 5:
				clearConsole();
				searchSupplier();
				break;
			case 6:
				clearConsole();
				homePage();
				break;	
			default:
				clearConsole();
				System.out.println("Invalid Option");
				break;		
			}
	}
	public static void addSupplier() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                      ADD SUPPLIER                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		L1:
		do {
			System.out.print("Supplier Id : ");
			String supId = input.next();
			for (int i = 0; i < suppliers.length; i++){
				if(supId.equals(suppliers[i][0])) {
					System.out.println("id already exists");
					continue L1;
				}
			}
			System.out.print("Supplier Name : ");
			String supName = input.next();
			
			suppliers = grow();
			suppliers[suppliers.length - 1][0] = supId;
			suppliers[suppliers.length - 1][1] = supName;
			
			System.out.print("Added successfully ! Do you want to add another supplier ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				addSupplier();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				supplierManage();
			}	
		}while(true);
	}
	public static String[][] grow () {
		String[][] temp = new String [suppliers.length+1][2];
		for (int i = 0; i < suppliers.length; i++) {
			temp[i] = suppliers[i];
		}
		return temp;	
	}
	public static void updateSupplier() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                   UPDATE SUPPLIER                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		boolean supplierFound = false;
		do{
			System.out.print("Supplier Id: ");
			String supId = input.next();
		
			for (int i = 0; i < suppliers.length; i++) {
				if (supId.equals(suppliers[i][0])) {
					supplierFound = true;
					System.out.println("Supplier name: " + suppliers[i][1]);
					System.out.print("Enter a new supplier name: ");
					String newName = input.next();
					suppliers[i][1] = newName;
				}	
			}
			if(!supplierFound){
					System.out.println("can't find supplier. Please try again!");
			}
			System.out.print("Do you want to update another supplier (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				updateSupplier();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				supplierManage();
			}
		}while(true);			
	}
	public static void deleteSupplier() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                   DELETE SUPPLIER                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		boolean supplierFound = false;
		do{
			System.out.print("Supplier Id: ");
			String supId = input.next();
			supplierFound = false;
		
			for (int i = 0; i < suppliers.length; i++) {
				if (supId.equals(suppliers[i][0])) {
					supplierFound = true;
					suppliers = remove();
				}	
			}
			if(!supplierFound){
					System.out.println("Can't find supplier. Please try again !");
			}
			System.out.print("Do you want to delete another supplier ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				deleteSupplier();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				supplierManage();
			}
		}while(true);			
	}
	public static String[][] remove() {	
		String[][] temp = new String[suppliers.length - 1][suppliers[0].length];	
		for (int i = 0, j = 0; i < suppliers.length; i++) {	
			if(i == j) {
				continue;
			}
			temp[j++] = suppliers[i];
		}
		return temp;	
	}
	public static void viewSupplier() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                     VIEW SUPPLIER                                     |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("+-----------------------+------------------------+");
		System.out.println("|      SUPPLIER ID      |      SUPPLIER NAME     |");
		System.out.println("+-----------------------+------------------------+");
		L1:
		for (int i = 0; i < suppliers.length; i++){
			L2:
			for (int j = 0; j < suppliers[i].length; j++){
				System.out.print("|\t"+suppliers[i][j]+"\t\t");
				System.out.print("|\b");	
			}
			System.out.println(" |");
		}
		System.out.println("+-----------------------+------------------------+");
		System.out.println();
		System.out.print("Do you want to go to supplier manage page(Y/N) ? : ");
						char op = input.next().charAt(0);
						if(op=='Y'|| op=='y') {
							clearConsole();
							supplierManage();
						}else if(op=='N'|| op=='n') {
							clearConsole();
						}	
	}
	public static void searchSupplier() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                     SEARCH SUPPLIERS                                    |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		boolean supplierFound = false;
		do{
			System.out.print("Supplier ID : ");
			String supId = input.next();
			
			for (int i = 0; i < suppliers.length; i++){
				if(supId.equals(suppliers[i][0])) {
					supplierFound = true;
					System.out.println("Supplier name: " + suppliers[i][1]);
					break;
				}	
			}
			if(!supplierFound) {
					System.out.println("Can't find supplier. Please try again !");
			}
			System.out.print("Searched successfully ! Do you want to search another supplier ? (Y/N) : ");
						char op = input.next().charAt(0);
						if(op=='Y'|| op=='y') {
							clearConsole();
							searchSupplier();
						}else if(op=='N'|| op=='n') {
							clearConsole();
							supplierManage();
						}
		}while(true);
	}
	public static void stockManagement() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                   STOCK MANAGEMENT                                    |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("[1] Manage Item Categories                                          [2] Add Item");
		System.out.println("[3] Get Items Supplier Wise                                         [4] View Items");
		System.out.println("[5] Rank Items Per Unit Price                                       [6] Home Page");
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int op = input.nextInt();
		switch(op) {
			case 1:
				clearConsole();
				manageItem();
				break;
			case 2:
				clearConsole();
				addItem();
				break;
			case 3:
				clearConsole();
				getItemSupplierWise();
				break;
			case 4:
				clearConsole();
				viewItem();
				break;
			case 5:
				clearConsole();
				rankedItemsPerUnitPrice();
				break;
			case 6:
				clearConsole();
				homePage();
				break;	
			default:
				clearConsole();
				System.out.println("Invalid Option");
				break;		
			}
	}
	public static void manageItem() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                 MANAGE ITEM CATEGORY                                  |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		System.out.println("[1] Add New Item Category                                       [2] Delete Item Category");
		System.out.println("[3] Update Item Category                                        [4] Stock Management");
		System.out.println();
		System.out.print("Enter an option to continue > ");
		int op = input.nextInt();
		switch(op) {
			case 1:
				clearConsole();
				addItemCategory();
				break;
			case 2:
				clearConsole();
				deleteItemCategory();
				break;
			case 3:
				clearConsole();
				updateItemCategory();
				break;
			case 4:
				clearConsole();
				stockManagement();
			default:
				clearConsole();
				System.out.println("Invalid Option");
				break;		
			}
	}
	public static void addItemCategory() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                    ADD ITEM CATEGORY                                  |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		L1:
		do {
			System.out.print("Enter the new item Category : ");
			String itemCat = input.next();
			
			itemCategory = extend();
			itemCategory[itemCategory.length - 1] = itemCat;
			
			System.out.print("Added successfully ! Do you want to add another item category ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				addItemCategory();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				manageItem();
			}	
		}while(true);
	}
	public static String[] extend () {
		String[] temp = new String [itemCategory.length+1];
		for (int i = 0; i < itemCategory.length; i++) {
			temp[i] = itemCategory[i];
		}
		return temp;	
	}		
	public static void deleteItemCategory() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                  DELETE ITEM CATEGORY                                 |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		boolean itemCatFound = false;
		do{
			System.out.println("Enter the Item Category : ");
			String itemCat = input.next();
			for (int i = 0; i < itemCategory.length; i++){
				if(itemCat.equals(itemCategory[i])) {
					itemCatFound = true;
					itemCategory = remove2();
				}
			}
			if(!itemCatFound){
					System.out.println("can't find supplier. Please try again!");
			}
			System.out.print("Deleted successfully ! Do you want to delete another item category ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				deleteItemCategory();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				manageItem(); 
			}
		}while(true);
	}
	public static String[] remove2() {
		String temp[] = new String [itemCategory.length - 1];
		for (int i = 0, j = 0; i < itemCategory.length; i++){
			if(i == j) {
				continue;
			}
			temp[j++] = itemCategory[i];
		}
		return temp;
	}
	public static void updateItemCategory() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                  UPDATE ITEM CATEGORY                                 |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		boolean itemCatFound =	false;
		do{
			System.out.println("Enter the Item Category : ");
			String itemCat = input.next();
			for (int i = 0; i < itemCategory.length; i++){
				if(itemCat.equals(itemCategory[i])) {
					itemCatFound = true;
					System.out.print("Enter the Updated Item Category : ");
					String newItem = input.next();
					itemCategory[i] = newItem;
					break;
				}
			}
			if(!itemCatFound){
					System.out.println("can't find supplier. Please try again!");
			}
			System.out.print("Updated successfully ! Do you want to update another item category ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				updateItemCategory();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				manageItem();
			}
			
		}while(true);
	}
	public static void addItem() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                       ADD ITEM                                  |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		if(itemCategory.length == 0) {
			System.out.println("OOPS ! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				addItemCategory();
			}else if(op=='N'|| op=='n') {
				System.exit(0);
			}
		}
		if(suppliers.length == 0) {
			System.out.println("OOPS ! It seems that you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				addSupplier();
			}else if(op=='N'|| op=='n') {
				System.exit(0);
			}
		}
		L1:
		do {
			System.out.print("Item Code : ");
			String itemCode = input.next();
			for (int i = 0; i < items.length; i++){
				if(itemCode.equals(items[i][0])) {
					System.out.println("id already exists");
					continue L1;
				}
			}	
			System.out.println();
			System.out.println("Suppliers list : ");
			System.out.println("+-----------------------+------------------------+-----------------------+");
			System.out.println("|          #            |      SUPPLIER ID       |     SUPPLIER NAME     |");
			System.out.println("+-----------------------+------------------------+-----------------------+");
				
			for (int i = 0; i < suppliers.length; i++){
				System.out.print("| ");
				System.out.print("\t" + (i+1) + "\t\t");
				for (int j = 0; j < suppliers[i].length; j++){
					System.out.print("|\t"+suppliers[i][j]+"\t\t");
					System.out.print(" |\b");	
				}
				System.out.println("|");
			}
			System.out.println("+-----------------------+------------------------+-----------------------+");
		
			System.out.print("Enter the supplier number > ");
			int supNum = input.nextInt();
		
			System.out.println();
			System.out.println("Item Categories : ");
			System.out.println("+-----------------------+------------------------+");
			System.out.println("|            #          |      CATEGORY NAME     |");
			System.out.println("+-----------------------+------------------------+");
			
			for (int i = 0; i < itemCategory.length; i++){
				System.out.print("| ");
				System.out.print("\t" + (i+1) + "\t\t");
				System.out.print("|\t"+itemCategory[i]+"\t\t");	
				System.out.println(" |");
			}
			System.out.println("+-----------------------+------------------------+");
			
			System.out.print("Enter the category number > ");
			int catNum = input.nextInt();
			
			System.out.print("Description: ");
			String description = input.next();
			System.out.print("Unit Price: ");
			double unitPrice = input.nextDouble();
			System.out.print("Qty On Hand: ");
			double qtyOnHand = input.nextDouble();
			
			items = itemgrow();
			items[items.length - 1][0] = itemCode;
			items[items.length - 1][1] = description;
			items[items.length - 1][2] = suppliers[supNum - 1][0];
			items[items.length - 1][3] = itemCategory[catNum - 1];
			
			doubleItems = doubleItemgrow();
			doubleItems[doubleItems.length - 1][0] = unitPrice;
			doubleItems[doubleItems.length - 1][1] = qtyOnHand;
			
			System.out.println("Item Added Successfully!");
			System.out.print("Do you want to add another item ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				addItem();
			}else if(op=='N'|| op=='n') {
				clearConsole();
				stockManagement();
			}
		}while(true);
	}
	public static String[][] itemgrow () {
		String[][] temp = new String [items.length+1][4];
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++){
				temp[i][j] = items[i][j];
			}
		}
		return temp;	
	}
	public static double[][] doubleItemgrow () {
		double[][] temp = new double [doubleItems.length+1][2];
		for (int i = 0; i < doubleItems.length; i++) {
			for (int j = 0; j < doubleItems[i].length; j++){
				temp[i][j] = doubleItems[i][j];
			}
		}
		return temp;	
	}
	public static void getItemSupplierWise() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                              SEARCH ITEMS SUPPLIER WISE                               |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		
		boolean supplierFound = false;
		
		L1:
		do{
			System.out.print("Supplier ID : ");
			String supId = input.next();
			
			for (int i = 0; i < suppliers.length; i++){
				if(supId.equals(suppliers[i][0])) {
					supplierFound = true;
					System.out.println("Supplier name: " + suppliers[i][1]);
					System.out.println();
					System.out.println("+---------------+-----------------+-----------------+-----------------+-----------------+");
					System.out.println("|    ITEM CODE  |   DESCRIPTION   |    UNIT PRICE   |   QTY ON HAND   |     CATEGORY    |");
					System.out.println("+---------------+-----------------+-----------------+-----------------+-----------------+");
					
					for (int j = 0; j < items.length; j++){
						if(supId.equals(items[j][2])) {
							System.out.print("|\t" + items[j][0] + "\t|\t" + items[j][1] + "\t|\t" + doubleItems[j][0] + "\t|\t" + doubleItems[j][1] + "\t|\t" + items[j][3] + "\t");
						}
						System.out.println("|");
					}
					System.out.println("+---------------+-----------------+-----------------+-----------------+-----------------+");
					break L1;
				}	
			}
			if(!supplierFound) {
					System.out.println("can't find supplier. Please try again!");
			}
		}while(true);	
		
		System.out.print("Searched successfully ! Do you want to do another search(Y/N) : ");
		char op = input.next().charAt(0);
		if(op=='Y'|| op=='y') {
			clearConsole();
			getItemSupplierWise();
		}else if(op=='N'|| op=='n') {
			clearConsole();
			stockManagement();
		}	
	}
	public static void viewItem() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                      VIEW ITEMS                                       |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();
		for (int i = 0; i < itemCategory.length; i++)	{
				System.out.println(itemCategory[i]+" : ");
				System.out.println("+-------------+-------------+-------------+-------------+-------------+");
				System.out.println("|     SID     |     CODE    |     DESC    |     PRICE   |     QTY     |");
				System.out.println("+-------------+-------------+-------------+-------------+-------------+");
				for (int j = 0; j < items.length; j++){
					if (itemCategory[i].equals(items[j][3])){
						System.out.println("|\t"+items[j][2]+"\t|\t"+items[j][0]+"\t|\t"+items[j][1]+"\t|\t"+doubleItems[j][0]+"\t|\t"+doubleItems[j][1]+"\t");
					}	
				}
				System.out.println("+-------------+-------------+-------------+-------------+-------------+");
				System.out.println();
		}
		
		System.out.print("Do you want to go back to the stock manage ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				stockManagement();
			}else if(op=='N'|| op=='n') {
				clearConsole();
			}
	}
	public static void sortByPrice() {
		String[][] tempItems = new String[items.length][4];
		double[][] tempDoubleItem = new double[items.length][2];
		
		for (int i = 0; i < items.length; i++) {
			tempItems[i][0] = items[i][0];
			tempItems[i][1] = items[i][1];
			tempItems[i][2] = items[i][2];
			tempItems[i][3] = items[i][3];
			
			tempDoubleItem[i][0] = doubleItems[i][0];
			tempDoubleItem[i][1] = doubleItems[i][1];
		}
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (tempDoubleItem[j][0] > tempDoubleItem[j + 1][0]) {
					
					double tempPrice = tempDoubleItem[j][0];
					tempDoubleItem[j][0] = tempDoubleItem[j + 1][0];
					tempDoubleItem[j + 1][0] = tempPrice;

					String[] tempDetails = tempItems[j];
					tempItems[j] = tempItems[j + 1];
					tempItems[j + 1] = tempDetails;
				}
			}
		}
		items = tempItems;
		doubleItems = tempDoubleItem;
	}
	public static void rankedItemsPerUnitPrice() {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                   RANKED UNIT PRICE                                   |");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println();

		sortByPrice();

		System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
		System.out.println("|       SID       |      CODE       |      DESC       |      PRICE      |       QTY       |        CAT      |");
		System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
		
		for (int i = 0; i < items.length; i++){
			System.out.println("|\t"+items[i][2]+"\t|\t"+items[i][0]+"\t|\t"+items[i][1]+"\t|\t"+doubleItems[i][0]+"\t|\t"+doubleItems[i][1]+"\t|\t"+items[i][3]);
		}
		System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+----------------+");
		System.out.print("Do you want to go stock manage page ? (Y/N) : ");
			char op = input.next().charAt(0);
			if(op=='Y'|| op=='y') {
				clearConsole();
				stockManagement();
			}else if(op=='N'|| op=='n') {
				clearConsole();
			}
	}
	public static void main(String args[]) {
		loginPage();
	}
}

