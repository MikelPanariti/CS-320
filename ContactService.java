package main.java;



import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private static int uniqueId = 2000;
    private static Map<Integer, Contact> contacts = new HashMap<>();

    public Map<Integer, Contact> addContact(Contact contact) {
        uniqueId++;
        contacts.put(uniqueId, contact);
        return contacts;
    }

    public Map<Integer, Contact> deleteContact(String contactID) {
        contacts.entrySet().removeIf(entry -> entry.getValue().getContactID().equals(contactID));
        return contacts;
    }

    public Map<Integer, Contact> updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        int id;
        try {
            id = Integer.parseInt(contactID);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid contact ID format");
        }

        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " not found.");
        }

        Contact existingContact = contacts.get(id);
        Contact updatedContact = new Contact(existingContact.getContactID(), firstName, lastName, phoneNumber, address);

        contacts.put(id, updatedContact);

        // Return a copy of the contacts map
        return new HashMap<>(contacts);
    }

    // Getter method to retrieve contacts for testing purposes
    public Map<Integer, Contact> getContacts() {
        return contacts;
    }
}
