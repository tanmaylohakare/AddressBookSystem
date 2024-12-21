package com.tech;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to the Address Book System");


		ArrayList<AddressBookSystem> addressBookSystems=new ArrayList<AddressBookSystem>();
		
		Scanner sc = new Scanner(System.in);
        int count =0;

        while (true) {

        	System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt(); 
            sc.nextLine();

            switch (choice) {
            case 1:
                


        	System.out.println("\n Enter details for Person   :- ");

		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();

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

                  addressBookSystems.add(new AddressBookSystem(firstName, lastName, address, city, state, zip, phoneNumber, email));

        System.out.println("Contact added Sucessfully.");

        break;

            case 2:

            	 System.out.print("Enter the First Name of the contact to edit: ");
                 String searchName = sc.nextLine();
                 boolean found = false;

            for(int i=0;i<addressBookSystems.size();i++)
            {
                if (addressBookSystems.get(i).getFirstName().equalsIgnoreCase(searchName)) {
                	found =true;

                	System.out.println("Editing contact: ");
                    addressBookSystems.get(i).showinfo();

                    System.out.println("\nEnter new details (leave blank to keep unchanged):");
                    System.out.print("Enter First Name: ");
                    String newFirstName = sc.nextLine();
                    if (!newFirstName.isBlank()) addressBookSystems.get(i).setFirstName(newFirstName);

                    System.out.print("Enter Last Name: ");
                    String newLastName = sc.nextLine();
                    if (!newLastName.isBlank()) addressBookSystems.get(i).setLastName(newLastName);

                    System.out.print("Enter Address: ");
                    String newAddress = sc.nextLine();
                    if (!newAddress.isBlank()) addressBookSystems.get(i).setAddress(newAddress);

                    System.out.print("Enter City: ");
                    String newCity = sc.nextLine();
                    if (!newCity.isBlank()) addressBookSystems.get(i).setCity(newCity);

                    System.out.print("Enter State: ");
                    String newState = sc.nextLine();
                    if (!newState.isBlank()) addressBookSystems.get(i).setState(newState);

                    System.out.print("Enter ZIP: ");
                    String newZip = sc.nextLine();
                    if (!newZip.isBlank()) addressBookSystems.get(i).setZip(newZip);

                    System.out.print("Enter Phone Number: ");
                    String newPhoneNumber = sc.nextLine();
                    if (!newPhoneNumber.isBlank()) addressBookSystems.get(i).setPhoneNumber(newPhoneNumber);

                    System.out.print("Enter Email: ");
                    String newEmail = sc.nextLine();
                    if (!newEmail.isBlank()) addressBookSystems.get(i).setEmail(newEmail);

                    System.out.println("Contact updated successfully.");
                    break;


            }


            }
            if (!found) {
                System.out.println("Contact not found.");
            }
            break;

            case 3:
                System.out.println("\nDisplaying all contacts:");
                for (int i = 0; i < addressBookSystems.size(); i++) {
                    System.out.println("\nContact " + (i + 1) + ":");
                    addressBookSystems.get(i).showinfo();
                }
                break;


            case 4: 
                System.out.print("Enter the First Name of the contact to delete: ");
                String deleteName = sc.nextLine();
                boolean isDeleted = false;
                
                for (int i = 0; i < addressBookSystems.size(); i++) {
                    if (addressBookSystems.get(i).getFirstName().equalsIgnoreCase(deleteName)) {
                        addressBookSystems.remove(i);
                        isDeleted=true;
                    	
                        System.out.println("Contact deleted successfully.");
                        break;
                    }
                }
                if (!isDeleted) {
                    System.out.println("Contact not found.");
                }
                break;
                
            case 5:

            	System.out.println("Exiting Address Book System.");
                sc.close(); 
                System.exit(0); 
                break;

           default:
                	System.out.println("Invalid choice Please try again.");

		
	}
			}
	}
	}