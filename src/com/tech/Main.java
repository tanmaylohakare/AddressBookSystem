package com.tech;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Address Book System");
		

        AddressBookSystem[] addressBookArray = new AddressBookSystem[50]; 
	
		Scanner sc = new Scanner(System.in);
        int count =0;

        for (int i = 0; i < 50; i++) {
        	
        	System.out.println("\n Enter details for Person "+ (i+1) + " :");
		
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
		
		
        addressBookArray[i] = new AddressBookSystem(firstName, lastName, address, city, state, zip, phoneNumber, email);
        count ++;
            }
		
	}
	}


