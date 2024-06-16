import java.util.Scanner;

public class driver {

	public static void displayMenu() {
        System.out.println("\nWhat do you want to do ?");
        System.out.println("\t1. Enter new book (password required)");
        System.out.println("\t2. Change information of a book (password required)");
        System.out.println("\t3. Display all books by a specific author");
        System.out.println("\t4. Display all books under a certain price.");
        System.out.println("\t5. Quit");
        System.out.print("Please enter your choice >");
    }
	
	public static void displayChange() {
		 System.out.println("\nWhat information would you like to change ?");
	        System.out.println("\t1. author");
	        System.out.println("\t2. title");
	        System.out.println("\t3. ISBN");
	        System.out.println("\t4. price");
	        System.out.println("\t5. Quit");
	        System.out.print("Please enter your choice >");
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the bookstore tracking system !");
		System.out.println("What is the maximum number of books your bookstore can contain ?");
		int maxBooks = kb.nextInt();
		Book[] inventory = new Book[maxBooks];
		final int password = 249;
		
		// menu
		displayMenu();
		
		int choice = kb.nextInt();
		int passswordCount=0;
		
		while (choice != 5) {
			switch (choice) {
			case 1:{
				System.out.print("\nPlease enter password: ");
				int input = kb.nextInt();
				
				int passwordTries = 0;
				boolean breakLoop = false;
				
				while (passswordCount<3 && !breakLoop) {
					while (passwordTries<2) {
						// if password is true it will break out of both loops
						if (input == password) {
							breakLoop = true;
							break;
						}
						// password not true, will allow to repeat 3 times before displaying again the menu
						else  {
							System.out.print("Wrong password. Please enter again :");
							input = kb.nextInt();
							passwordTries++;
						} 
					}
					
					// wrong password entered 3 time : menu displayed and choice is re-entered
					if (passwordTries==2) {
						passswordCount++;
						displayMenu();
						choice = kb.nextInt();
						break;
					}
				}
				
				// Check if process has been repeated more than 4 times. if it was then exit the program
				if (passswordCount==3) {
					System.out.println("\nProgram detected suspicous activities and will terminate immediately!");
					System.exit(0);
				}
				
				if (input == password) {
					System.out.println("How many books do you want to add ?");
					int addBook = kb.nextInt();
					kb.nextLine();
					
					if (addBook + Book.findNumberOfCreatedBooks() <= maxBooks) {
						for (int i = Book.findNumberOfCreatedBooks(); i<addBook; i++ ) {
							System.out.println("\nPlease enter book title, author name, ISBN and price:");
							
							System.out.print("title: ");
							String bookTitle = kb.nextLine();
							
							System.out.print("author: ");
							String authorName = kb.nextLine();
							
							System.out.print("ISBN: ");
							long isbnNumber = kb.nextLong();
							
							System.out.print("price: ");
							double bookPrice = kb.nextDouble();
							
							kb.nextLine();
							
							inventory[i] = new Book(bookTitle, authorName, isbnNumber, bookPrice);
						}	
						System.out.println("Successfully added books to the library !");
						displayMenu();
						choice = kb.nextInt();
						break;
					}
					else {
						System.out.println("There isn't enough place in the library for " + addBook + " books.");
						System.out.println("The maximum remaining books you can add to the library is " + (maxBooks-Book.findNumberOfCreatedBooks()) + " books.");
						displayMenu();
						choice = kb.nextInt();
						break;
					}
						
				}
				break;
			}
			case 2:	{
				System.out.print("\nPlease enter password: ");
				int input = kb.nextInt();
				
				int passwordTries = 0;
			
					while (passwordTries<2) {
						// if password is true it will break out of the loop
						if (input == password) {
							break;
						}
						// password not true, will allow to repeat 3 times before displaying again the menu
						else  {
							System.out.print("Wrong password. Please enter again :");
							input = kb.nextInt();
							passwordTries++;
						} 
					}
					
					// wrong password entered 3 time : menu displayed and choice is re-entered
					if (passwordTries==2) {
						passswordCount++;
						displayMenu();
						choice = kb.nextInt();
						break;
					}
					
					boolean validBook = false;
					int index = 0;
					
					while (validBook == false) {
						System.out.println("Which book do you wish to update?");
						index = kb.nextInt();
						
						for (int i=0; i<Book.findNumberOfCreatedBooks(); i++) {
							if (inventory[i].getISBN() == index) {
								validBook = true;
								break;
							}
						}
						
						if (!validBook) {
							System.out.println("There is no book with the given ISBN.");
							System.out.println("Type 1 to re-enter another book or 2 to access the main menu.");
							int option = kb.nextInt();
							
							if (option ==1 ) {
								continue;
							}
							
							if (option == 2 ) {
								displayMenu();
								choice = kb.nextInt();
							}
						}	
					}
					
					
					System.out.print(inventory[index].toString());
					displayChange();
					
					
				
				
			}
			}
		}
		

	}

}
