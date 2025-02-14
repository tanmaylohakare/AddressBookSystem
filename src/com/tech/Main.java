package com.tech;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	private static final Map<String, List<AddressBookSystem>> cityDictionary =new HashMap<>();
	private static final Map<String, List<AddressBookSystem>> stateDictionary=new HashMap<>();
	


	public static void main(String[] args) {

		System.out.println("Welcome to the Address Book System");

		
		HashMap<String, AddressBook> AddressBooks=new HashMap<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Create New Address Book");
			System.out.println("2. Select Address Book");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter the name of the new Address Book System : ");
				String addressBookName = sc.nextLine();

				if (AddressBooks.containsKey(addressBookName)) {
					System.out.println("An Address book with the same name is already exist  ");
				} else {
					AddressBooks.put(addressBookName, new AddressBook(addressBookName));
					System.out.println(addressBookName);

				}

				break;

			case 2:
				System.out.println("Enter the name of the Address Book to Select");
				String selectedBook = sc.nextLine();
				AddressBook selectedAddressBook = AddressBooks.get(selectedBook);

				if (selectedAddressBook != null) {
					showAddressBookSystem(selectedAddressBook, sc);

				} else {
					System.out.println("Address Book Not Found. ");
				}

				break;
			

			case 3:
				System.out.println("Existing Address book System. ");
				sc.close();
				System.exit(0);

				break;

			default:

				System.out.println("Invalid choice. Please try again ");
			}
		}
	}

	public static void showAddressBookSystem(AddressBook addressBook, Scanner sc) {

		while (true) {

			System.out.println("\nMenu for Address Book :" + addressBook.getName());
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Display Contacts");
			System.out.println("4. Delete Contact");
			System.out.println("5. Search it by Name Or State");
			System.out.println("6. View Persons by City/State");
			System.out.println("7. Count the Person by City/State");
			System.out.println("8. Sort Enties By City, State, ZIP");
			System.out.println("9. Save Address Book to File");
            System.out.println("10. Load Address Book from File");
            System.out.println("11. Create a New File to Save the Data");
			System.out.println("12. Go back to Main Menu");
			System.out.print("Choose an option: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				addContact(addressBook, sc);

				break;

			case 2:
				Edit_Contact(addressBook, sc);

				break;

			case 3:

				Display_Contacts(addressBook);
				break;

			case 4:

				Delete_Contact(addressBook, sc);
				break;

			case 5:
				searchContacts(addressBook, sc);
				break;
				
			case 6:
				viewPersonsByCityOrState(sc);
				
				break;
				
			case 7:
				
				CountPersonByCityOrState(sc);
				
				break;
			case 8:
				
				sortContacts(addressBook, sc);
				break;
				
			 case 9:
				 
                 writeAddressBookToFile(addressBook);
                 break;
                 
             case 10:
            	 
                 System.out.print("Enter file name to load: ");
                 String fileName = sc.nextLine();
                 readAddressBookFromFile(fileName, addressBook);
                 break;
	
             case 11: 
            	 
            	 System.out.print("Enter file name to create: ");
                 String newFileName = sc.nextLine();
                 createFile(newFileName);
                 break;
            	 
				
			case 12 :
				return;
				
				
			default:
				System.out.println("Invalid choice Please try again.");

			}
		}
	}

// Method to add the Contacts
	public static void addContact(AddressBook addressBook, Scanner sc)

	{
		System.out.println("\n Enter details for Person   :- ");

		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();

		boolean isDuplicate = addressBook.getContacts().stream()
				.anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName)
						&& contact.getLastName().equalsIgnoreCase(lastName));

		if (isDuplicate) {
			System.out.println("Duplicate Entry Detected ! Contact not Added");
			return;
		}

		System.out.print("Enter Address: ");
		String address = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter State: ");
		String state = sc.nextLine();

		System.out.print("Enter ZIP: ");
		String zip = sc.nextLine();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		AddressBookSystem contact=new AddressBookSystem(firstName, lastName, address, city, state, zip, phoneNumber, email);
		addressBook.getContacts().add(contact);
		cityDictionary.computeIfAbsent(city, k -> new ArrayList<>()).add(contact);
		stateDictionary.computeIfAbsent(state, k -> new ArrayList<>()).add(contact);

		System.out.println("Contact added Sucessfully.");

	}

//Method to Edit the contact
	public static void Edit_Contact(AddressBook addressBook, Scanner sc) 
	{
		System.out.print("Enter the First Name of the contact to edit: ");
		String searchName = sc.nextLine();
		
		Optional<AddressBookSystem> contactOptional =addressBook.getContacts().stream().filter(contact -> contact.getFirstName().equalsIgnoreCase(searchName)).findFirst();

		if (contactOptional.isPresent()) {
	        AddressBookSystem contact = contactOptional.get(); // Get the found contact

				System.out.println("Editing contact: ");
				contact.showinfo();

				System.out.println("\nEnter new details (leave blank to keep unchanged):");
				
				System.out.print("Enter First Name: ");
				String newFirstName = sc.nextLine();
				if (!newFirstName.isBlank()) contact.setFirstName(newFirstName);

				System.out.print("Enter Last Name: ");
				String newLastName = sc.nextLine();
				if (!newLastName.isBlank()) contact.setLastName(newLastName);
				
				System.out.print("Enter Address: ");
				String newAddress = sc.nextLine();
				if (!newAddress.isBlank())contact.setAddress(newAddress);

				System.out.print("Enter City: ");
				String newCity = sc.nextLine();
				if (!newCity.isBlank())contact.setCity(newCity);
				
				System.out.print("Enter State: ");
				String newState = sc.nextLine();
				if (!newState.isBlank())contact.setState(newState);
				
				System.out.print("Enter ZIP: ");
				String newZip = sc.nextLine();
				if (!newZip.isBlank())contact.setZip(newZip);

				System.out.print("Enter Phone Number: ");
				String newPhoneNumber = sc.nextLine();
				if (!newPhoneNumber.isBlank())contact.setPhoneNumber(newPhoneNumber);

				System.out.print("Enter Email: ");
				String newEmail = sc.nextLine();
				if (!newEmail.isBlank())contact.setEmail(newEmail);

				System.out.println("Contact updated successfully.");

			}
		else {
			System.out.println("Contact not found.");
		}
		
	}

//Method to Display_Contacts

	public static void Display_Contacts(AddressBook addressBook) {
		
		addressBook.getContacts().stream().sorted((c1,c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()))
		.forEach(contact -> { contact.showinfo();System.out.println();
		});
		
	}

// Method to delete Contact
	public static void Delete_Contact(AddressBook addressBook, Scanner sc) {
		System.out.print("Enter the First Name of the contact to delete: ");
		String deleteName = sc.nextLine();
		
		Iterator<AddressBookSystem> iterator =addressBook.getContacts().iterator();
		boolean isDeleted=false;
		
		while(iterator.hasNext())
		{
			AddressBookSystem contact = iterator.next();
			
			if(contact.getFirstName().equalsIgnoreCase(deleteName))
			{
				iterator.remove();
				
				cityDictionary.get(contact.getCity()).remove(contact);
				stateDictionary.get(contact.getState()).remove(contact);
				
				isDeleted =true;
				
				System.out.println("Contact delete successfully. ");
				break;
			}
		}
		
		if (!isDeleted) {
			System.out.println("Contact not found.");
		}
	}
	
	// Method to Search Contact By city 
	public static void searchContacts(AddressBook addressBook, Scanner sc) {
        System.out.println("Search by:");
        System.out.println("1. City");
        System.out.println("2. State");
        System.out.println("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter City: ");
            String city = sc.nextLine();
            addressBook.getContacts().stream()
                    .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                    .forEach(System.out::println);
        } else if (choice == 2) {
            System.out.print("Enter State: ");
            String state = sc.nextLine();
            addressBook.getContacts().stream()
                    .filter(contact -> contact.getState().equalsIgnoreCase(state))
                    .forEach(System.out::println);
        }
        else {
            System.out.println("Invalid choice.");
        }
    }
	
	// View Person By its City Or State
	private static void viewPersonsByCityOrState(Scanner sc)
	{
		System.out.println("\nView Person by :");
		System.out.println("1. City");
		System.out.println("2. State");
		System.out.println("3. ZIP");
		System.out.println("Choose an option : ");
		
		int choice=sc.nextInt();
		sc.nextLine();
		
		 if (choice == 1) {
	            System.out.print("Enter City: ");
	            String city = sc.nextLine();
	            List<AddressBookSystem> cityContacts = cityDictionary.getOrDefault(city, new ArrayList<>());
	            
	            if(cityContacts.isEmpty())
	            {
	            	System.out.println("No Contact Found in City :"+ city);
	            }
	            else
	            {
	            	cityContacts.forEach(AddressBookSystem :: showinfo);
	            }
	        } 
		 else if (choice == 2) {
	            System.out.print("Enter State: ");
	            String state = sc.nextLine();
	            List<AddressBookSystem> stateContacts = stateDictionary.getOrDefault(state, new ArrayList<>());
	            if(stateContacts.isEmpty())
	            {
	            	System.out.println("No Contact Found in State :"+ state);
	            }
	            else 
	            {
	            stateContacts.forEach(AddressBookSystem:: showinfo);
	            }
	            }
		 else {
	            System.out.println("Invalid choice.");
	        }
	}
	
	public static void CountPersonByCityOrState(Scanner sc)
	{
		System.out.println("\nCount Contacts by: ");
		System.out.println("1. City");
		System.out.println("2. State");
		System.out.println("Choose an option: ");
		
		int choice= sc.nextInt();
		sc.nextLine();
		
		if(choice==1)
		{
			System.out.println("1.Enter the City");
			String city=sc.nextLine();
			long count= cityDictionary.getOrDefault(city, new ArrayList<>()).stream().count();
			System.out.println("Number Of Contact in City "+ city +" :"+ count);
			
		}
		else if(choice == 2)
		{
			System.out.println("2.Enter the State");
			String state=sc.nextLine();
			long count=stateDictionary.getOrDefault(state, new ArrayList<>()).stream().count();
			System.out.println("Number Of Contact in State "+ state +" :"+ count);
		}
		else
		{
			System.out.println("Invalid choice");
		}
	}
	
	public static void sortContacts(AddressBook addressBook, Scanner sc)
	{
		System.out.println("\n Sort Contacts by: ");
		System.out.println("1. City");
		System.out.println("2. State");
		System.out.println("3. ZIP");
		System.out.println("Choose an Option: ");
		
		int choice=sc.nextInt();
		sc.nextLine();
		
		
		switch (choice) {
		case 1
			-> addressBook.getContacts().stream()
            .sorted(Comparator.comparing(AddressBookSystem::getCity, String.CASE_INSENSITIVE_ORDER))
            .forEach(AddressBookSystem::showinfo);		
			
		case 2
			-> addressBook.getContacts().stream()
            .sorted(Comparator.comparing(AddressBookSystem::getState, String.CASE_INSENSITIVE_ORDER))
            .forEach(AddressBookSystem::showinfo);
			
		case 3
		-> addressBook.getContacts().stream()
        .sorted(Comparator.comparing(AddressBookSystem::getZip, String.CASE_INSENSITIVE_ORDER))
        .forEach(AddressBookSystem::showinfo);
			
		default -> System.out.println("Invalid Choice");
	
		}}
	
	// Method to create a file
	public static void createFile(String fileName) {
	    File file = new File(fileName);
	    try {
	        if (file.exists()) {
	            System.out.println("File already exists: " + fileName);
	        } else if (file.createNewFile()) {
	            System.out.println("File created successfully: " + fileName);
	        } else {
	            System.out.println("Failed to create the file: " + fileName);
	        }
	    } catch (IOException e) {
	        System.out.println("Error while creating the file: " + e.getMessage());
	    }
	}

	// <ethod to Write the File 
	public static void writeAddressBookToFile(AddressBook addressBook) {
        String fileName = addressBook.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (AddressBookSystem contact : addressBook.getContacts()) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Address Book saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving Address Book to file: " + e.getMessage());
        }
    }


	// Method to read Address Book from a file
    public static void readAddressBookFromFile(String fileName, AddressBook addressBook) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                if (details.length == 8) {
                    AddressBookSystem contact = new AddressBookSystem(
                            details[0], // First Name
                            details[1], // Last Name
                            details[2], // Address
                            details[3], // City
                            details[4], // State
                            details[5], // ZIP
                            details[6], // Phone Number
                            details[7]  // Email
                    );
                    addressBook.getContacts().add(contact);
                    cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
                    stateDictionary.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
                }
            }
            System.out.println("Address Book loaded from file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading Address Book from file: " + e.getMessage());
        }
    }



}