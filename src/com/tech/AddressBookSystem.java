package com.tech;

public class AddressBookSystem {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	
	public AddressBookSystem(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "AddressBookSystem [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}
	
	public void showinfo()
	{
		
		System.out.println("Full Name :- "+firstName+" "+lastName);
		System.out.println("Address :- "+ address);
		System.out.println("City :- "+ city);
		System.out.println("State :- "+ state);
		System.out.println("zip :- "+zip);
		System.out.println("Phone Number :- "+phoneNumber);
		System.out.println("Emial :- "+email);
		
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this ==obj)
			return true;
		if(obj == null|| getClass() != obj.getClass())
				return false;
		AddressBookSystem that=(AddressBookSystem)obj;
	    return firstName.equalsIgnoreCase(that.firstName) && lastName.equalsIgnoreCase(that.lastName);
	}
	
	public int hashCode()
	{
        return java.util.Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
	}
	
}


