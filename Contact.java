package main.java;

public class Contact {

    private String contactID;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
	

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean validateContactID(String contactID) {
        return contactID != null && contactID.length() <= 10;
    }

    public boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() <= 10;
    }

    public boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() <= 10;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        // Additional validation logic can be added here
        return phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.matches("\\d+");
    }

    public boolean validateAddress(String address) {
        // Additional validation logic can be added here
        return address != null && address.length() <= 30;
    }

    public void setNumber(String number) {
        // You might want to add validation logic here before setting the number
        this.phoneNumber = number;
    }

    public void setAddress(String address) {
        // You might want to add validation logic here before setting the address
        this.address = address;
    }
    
    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
