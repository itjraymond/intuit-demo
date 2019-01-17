package intuitdemo.mask;

import intuitdemo.mask.domain.Account;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AccountTest {

    @Test
    public void shouldReturnMaskedFields_WhenPayloadHasValidData() {
        // given:
        Account account = new Account("123456789", "1234 5555 1234 6666", "John", "Doe");

        // when
        String logOutput = account.toString();

        // expect
        assertEquals("Account{account='xxxxxx6789', cc='xxxx xxxx xxxx 6666', lastname='Doe', firstname='John'}", logOutput);
    }

    @Test
    public void shouldNotLogSensitiveInfo_WhenPayloadMayHaveInvalidData() {
        // given:
        Account account = new Account("12", "4444", "Bob", "Stewart");

        // when:
        String logOutput = account.toString();

        // expect
        assertNotEquals("Account{account='12', cc='4444', lastname='Stewart', firstname='Bob'}", logOutput);
        assertEquals("Account{account='Cannot display sensitive info - invalid account format', cc='Cannot display sensitive info - invalid cc format', lastname='Stewart', firstname='Bob'}", logOutput);
    }
}
