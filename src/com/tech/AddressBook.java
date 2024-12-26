package com.tech;

import java.util.ArrayList;

public class AddressBook {
	
	private String name;
    ArrayList<AddressBookSystem> contacts;
	
	
	// Constructor
	public AddressBook(String name) 
	{
		this.name=name;
		this.contacts=new ArrayList<>();
	
	}


	public String getName() {
		return name;
	}


	public ArrayList<AddressBookSystem> getContacts() {
		return contacts;
	}
	
	public void addcontact(AddressBookSystem contact)
	{
		contacts.add(contact);
	}
	

}
