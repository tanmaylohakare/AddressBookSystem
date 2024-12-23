package com.tech;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to the Address Book System");


HashMap<String, AddressBook> addressBook=new HashMap<>();
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{System.out.println("\nMenu:");
        System.out.println("1. Create New Address Book");
        System.out.println("2. Select Address Book");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int choice = sc.nextInt();
        sc.nextLine();
        
       
        
        
        switch (choice) {
		
        case 1:
        	System.out.println("Enter the name of the new Address Book System : ");
        	String addressBookName=sc.nextLine();
        	
        	if(addressBook.containsKey(addressBookName))
        	{
        		System.out.println("An Address book with the same name is already exist  ");
        	}
        	else {
				addressBook.put(addressBookName, new AddressBook(addressBookName));
				System.out.println(addressBookName);
					
				}
        	
        	break;
        	
        case 2:
        	System.out.println("Enter the name of the Address Book to Select");
        	String selectedBook=sc.nextLine();
        	AddressBook selectedAddressBook=addressBook.get(selectedBook);
        	
        	if(selectedAddressBook != null)
        	{
        		showAddressBookSystem(selectedAddressBook, sc);    

        	}
        	else
        	{
        		System.out.println("Address Book Not Found. ");
        	}
        	
        	break;
        	
			
        case 3:
        	System.out.println("Existing Address book System. ");
        	sc.close();
        	System.exit(0);
        	
        	break;
        
        	
        default :
        
        	System.out.println("Invalid choice. Please try again ");
		}
		}
	}
	
public static void showAddressBookSystem(AddressBook addressBook ,Scanner sc) {
	

        while (true) {

        	System.out.println("\nMenu for Address Book :"+ addressBook.getName());
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Go back to Main Menu");
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
            	return;

           default:
                	System.out.println("Invalid choice Please try again.");

            
	}
}}


// Method
public static void addContact(AddressBook addressBook,Scanner sc)

{
	System.out.println("\n Enter details for Person   :- ");

System.out.print("Enter First Name: ");
String firstName = sc.nextLine();

System.out.print("Enter Last Name: ");
String lastName = sc.nextLine();


boolean isDuplicate=addressBook.getContacts().stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName));

if(isDuplicate)
{
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

          addressBook.addcontact(new AddressBookSystem(firstName, lastName, address, city, state, zip, phoneNumber, email));

System.out.println("Contact added Sucessfully.");


}

//Method to Edit the contact
public static void Edit_Contact(AddressBook addressBook, Scanner sc)
{
	 System.out.print("Enter the First Name of the contact to edit: ");
     String searchName = sc.nextLine();
     boolean found = false;

for(int i=0 ; i<addressBook.getContacts().size() ; i++)
{
    if (addressBook.getContacts().get(i).getFirstName().equalsIgnoreCase(searchName)) {
    	found =true;

    	System.out.println("Editing contact: ");
    	addressBook.getContacts().get(i).showinfo();

        System.out.println("\nEnter new details (leave blank to keep unchanged):");
        System.out.print("Enter First Name: ");
        String newFirstName = sc.nextLine();
        if (!newFirstName.isBlank()) addressBook.getContacts().get(i).setFirstName(newFirstName);

        System.out.print("Enter Last Name: ");
        String newLastName = sc.nextLine();
        if (!newLastName.isBlank()) addressBook.getContacts().get(i).setLastName(newLastName);

        System.out.print("Enter Address: ");
        String newAddress = sc.nextLine();
        if (!newAddress.isBlank()) addressBook.getContacts().get(i).setAddress(newAddress);

        System.out.print("Enter City: ");
        String newCity = sc.nextLine();
        if (!newCity.isBlank()) addressBook.getContacts().get(i).setCity(newCity);

        System.out.print("Enter State: ");
        String newState = sc.nextLine();
        if (!newState.isBlank()) addressBook.getContacts().get(i).setState(newState);

        System.out.print("Enter ZIP: ");
        String newZip = sc.nextLine();
        if (!newZip.isBlank()) addressBook.getContacts().get(i).setZip(newZip);

        System.out.print("Enter Phone Number: ");
        String newPhoneNumber = sc.nextLine();
        if (!newPhoneNumber.isBlank()) addressBook.getContacts().get(i).setPhoneNumber(newPhoneNumber);

        System.out.print("Enter Email: ");
        String newEmail = sc.nextLine();
        if (!newEmail.isBlank()) addressBook.getContacts().get(i).setEmail(newEmail);

        System.out.println("Contact updated successfully.");
        break;
        
    }
}
if (!found) {
    System.out.println("Contact not found.");
}
}

//Method to Display_Contacts

	public static void Display_Contacts(AddressBook addressBook)
	{
	System.out.println("Enter the First Name to display the contact .");
	for(int i=0;i< addressBook.getContacts().size();i++)
	{
		System.out.println("\nContact "+ (i+1)+" :");
		addressBook.getContacts().get(i).showinfo();
}
	}
	
	//Method to delete Contact
	public static void Delete_Contact(AddressBook addressBook, Scanner sc)
	{
		System.out.print("Enter the First Name of the contact to delete: ");
        String deleteName = sc.nextLine();
        boolean isDeleted = false;
        
        for (int i = 0; i <  addressBook.getContacts().size(); i++) {
            if (addressBook.getContacts().get(i).getFirstName().equalsIgnoreCase(deleteName)) {
            	addressBook.getContacts().remove(i);
                isDeleted=true;
            	
                System.out.println("Contact deleted successfully.");
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("Contact not found.");
        }
	}
}