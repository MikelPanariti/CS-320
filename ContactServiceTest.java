package test.java;



import org.junit.jupiter.api.Test;

import main.java.Contact;
import main.java.ContactService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	@Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        ContactService instance = new ContactService();
        Map<Integer, Contact> result = instance.addContact(contact);

        // Check if the result map contains the contact with the correct ID
        assertTrue(result.entrySet().stream()
                .anyMatch(entry -> entry.getKey() > 2000 && entry.getValue().equals(contact)),
                "Contact should be added with the new ID");
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        ContactService instance = new ContactService();
        instance.addContact(contact);
        Map<Integer, Contact> result = instance.deleteContact("1");
        assertFalse(result.containsKey(2001), "Contact should be deleted");
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        ContactService instance = new ContactService();
        instance.addContact(contact);
        

        try {
            // Try updating with an invalid ID
            assertThrows(IllegalArgumentException.class, () -> {
                instance.updateContact("2", "Jane", "Doe", "9876543210", "456 Oak St");
            }, "Contact with ID 2 not found.");

            // Update the contact with a valid ID
            Map<Integer, Contact> result = instance.updateContact("1", "Jane", "Doe", "9876543210", "456 Oak St");
            assertTrue(result.containsKey(2001), "Contact should still exist after update");
            Contact updatedContact = result.get(2001);
            assertEquals("Jane", updatedContact.getFirstName(), "FirstName should be updated");
            assertEquals("Doe", updatedContact.getLastName(), "LastName should remain unchanged");
            assertEquals("9876543210", updatedContact.getPhoneNumber(), "PhoneNumber should be updated");
            assertEquals("456 Oak St", updatedContact.getAddress(), "Address should be updated");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testUpdateContactNotFound() {
        ContactService instance = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->
                instance.updateContact("999", "Jane", "Doe", "9876543210", "456 Oak St"));
    }
}
