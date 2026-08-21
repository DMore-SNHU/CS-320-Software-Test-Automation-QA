package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();

        contact = new Contact(
                "12345",
                "David",
                "Morelli",
                "2255551234",
                "123 Main Street");
    }
    
    @Test
    void testAddContact() {
        assertDoesNotThrow(() -> {
            contactService.addContact(contact);
        });
    }
    
    @Test
    void testDuplicateContactId() {

        contactService.addContact(contact);

        Contact duplicate = new Contact(
                "12345",
                "John",
                "Smith",
                "2251112222",
                "456 Oak Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicate);
        });
    }
    
    @Test
    void testDeleteContact() {
        contactService.addContact(contact);

        contactService.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("12345");
        });
    }
    
    @Test
    void testUpdateFirstName() {

        contactService.addContact(contact);

        assertDoesNotThrow(() -> {
            contactService.updateFirstName("12345", "Johnny");
        });

        assertEquals("Johnny", contact.getFirstName());
    }
    
    @Test
    void testUpdateLastName() {

        contactService.addContact(contact);

        assertDoesNotThrow(() -> {
            contactService.updateLastName("12345", "Johnson");
        });

        assertEquals("Johnson", contact.getLastName());
    }
    
    @Test
    void testUpdatePhone() {

        contactService.addContact(contact);

        assertDoesNotThrow(() -> {
            contactService.updatePhone("12345", "2259998888");
        });

        assertEquals("2259998888", contact.getPhone());
    }
    
    @Test
    void testUpdateAddress() {

        contactService.addContact(contact);

        assertDoesNotThrow(() -> {
            contactService.updateAddress("12345", "789 Pine Street");
        });

        assertEquals("789 Pine Street", contact.getAddress());
    }
}