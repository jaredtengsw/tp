package seedu.address.model.residence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.booking.TenantName;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TenantName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new TenantName(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> TenantName.isValidName(null));

        // invalid name
        assertFalse(TenantName.isValidName("")); // empty string
        assertFalse(TenantName.isValidName(" ")); // spaces only
        assertFalse(TenantName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(TenantName.isValidName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(TenantName.isValidName("Hudson Village")); // alphabets only
        assertTrue(TenantName.isValidName("12345")); // numbers only
        assertTrue(TenantName.isValidName("North Tower 2")); // alphanumeric characters
        assertTrue(TenantName.isValidName("Capital Heights")); // with capital letters
        assertTrue(TenantName.isValidName("Pinnacle Duxton Cantonment Rd HDB")); // long names
    }
}
