package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.Contact;

public class ContactTest {

    @Test
    public void testGetContactID() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getContactID());
    }

    @Test
    public void testSetContactID() {
        // Create a contact with an initial ID of "1"
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Set contactID to a new value "2"
        contact.setContactID("2");

        // Validate that the contactID has been updated to "2"
        assertEquals("2", contact.getContactID(), "ContactID should be updated to '2'");
    }
    
    @Test
    public void testValidateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Valid case
        assertTrue(contact.validateFirstName("John"));

        // Invalid cases
        assertFalse(contact.validateFirstName(null)); // Null first name
        assertFalse(contact.validateFirstName("TooLongFirstName")); // More than 10 characters
    }

    @Test
    public void testGetFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
    }

    // Add similar tests for other getters and setters

    @Test
    public void testValidateContactID() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validateContactID("1"));
        assertFalse(contact.validateContactID(null));
        assertFalse(contact.validateContactID("12345678901")); // More than 10 characters
    }
    
    @Test
    public void testGetLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testGetAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    public void testValidateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validateLastName("Doe"));
        assertFalse(contact.validateLastName(null));
        assertFalse(contact.validateLastName("Toolonglastname")); // More than 10 characters
    }

    @Test
    public void testValidatePhoneNumber() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validatePhoneNumber("1234567890"));
        assertFalse(contact.validatePhoneNumber(null));
        assertFalse(contact.validatePhoneNumber("12345678901")); // More than 10 digits
        assertFalse(contact.validatePhoneNumber("12345abcde")); // Contains non-digit characters
    }

    @Test
    public void testValidateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contact.validateAddress("123 Main St"));
        assertFalse(contact.validateAddress(null));
        assertFalse(contact.validateAddress("Thisaddressiswaytoolongforvalidationpurposes")); // More than 30 characters
    }

    @Test
    public void testSetPhoneNumber() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setNumber("9876543210");
        assertEquals("9876543210", contact.getPhoneNumber());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Side St");
        assertEquals("456 Side St", contact.getAddress());
    }
    
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact(null, null, null, null, null);
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName(), "FirstName should be set to John");
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact(null, null, null, null, null);
        contact.setLastName("Doe");
        assertEquals("Doe", contact.getLastName(), "LastName should be set to Doe");
    }

}
