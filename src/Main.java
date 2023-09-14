
import java.util.List;
import java.util.Scanner;

import controller.ListpetHelper;
import model.petList;

public class Main {

		static Scanner in = new Scanner(System.in);
		static ListpetHelper lih = new ListpetHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter an type: ");
			String name = in.nextLine();
			System.out.print("Enter an name: ");
			String type = in.nextLine();
			System.out.print("Enter an owner: ");
			String owner = in.nextLine();
			petList toAdd = new petList(name,type,owner);
			lih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the type to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String type = in.nextLine();
			System.out.print("Enter the owner to delete: ");
			String owner = in.nextLine();
			petList toDelete = new petList(name,type,owner);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by type");
			System.out.println("2 : Search by name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<petList> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the pet type: ");
				String petName = in.nextLine();
				foundItems = lih.searchForPetByType(petName);
			} else if (searchBy == 2){
				System.out.print("Enter the name: ");
				String type = in.nextLine();
				foundItems = lih.searchForpetbyname(type);
			} else 
			{
				System.out.print("Enter the pet owner: ");
				String petOwner = in.nextLine();
				foundItems = lih.searchForPetByType(petOwner);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (petList l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				petList toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + ", " + toEdit.getType() + " and "+ toEdit.getOwner());
				System.out.println("1 : Update name");
				System.out.println("2 : Update type");
				System.out.println("3 : Update owner");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New type: ");
					String newType = in.nextLine();
					toEdit.setType(newType);
				}else if (update == 3) {
					System.out.print("New Owner: ");
					String newOwner = in.nextLine();
					toEdit.setOwner(newOwner);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an pet");
				System.out.println("*  2 -- Edit an pet");
				System.out.println("*  3 -- Delete an pet");
				System.out.println("*  4 -- View the pet");
				System.out.println("*  5 -- Exit");
				int chossen = in.nextInt();
				in.nextLine();

				if (chossen == 1) {
					addAnItem();
				} else if (chossen == 2) {
					editAnItem();
				} else if (chossen == 3) {
					deleteAnItem();
				} else if (chossen == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<petList> allItems = lih.showAllItems();
			for(petList singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}

