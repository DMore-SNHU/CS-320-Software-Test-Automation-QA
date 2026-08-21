package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "12345",
                "David",
                "Morelli",
                "2255551234",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("David", contact.getFirstName());
        assertEquals("Morelli", contact.getLastName());
        assertEquals("2255551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }
    
    // Contact ID tests
    
    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "David",
                    "Morelli",
                    "2255551234",
                    "123 Main Street");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "David",
                    "Morelli",
                    "2255551234",
                    "123 Main Street");
        });
    }
    
    // First name tests

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "DavidDavidD",
                    "Morelli",
                    "2255551234",
                    "123 Main Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Morelli",
                    "2255551234",
                    "123 Main Street");
        });
    }
    
    // Last name tests

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "ABCDEFGHIJK",
                    "2255551234",
                    "123 Main Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    null,
                    "2255551234",
                    "123 Main Street");
        });
    }
    
    // Phone tests
    
    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    "225555123",
                    "123 Main Street");
        });
    }
    
    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    "22555512345",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneContainsLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    "22555abcde",
                    "123 Main Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    null,
                    "123 Main Street");
        });
    }
    
    // Address tests

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    "2255551234",
                    "123 Main Street Apartment 12345");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "David",
                    "Morelli",
                    "2255551234",
                    null);
        });
    }
}