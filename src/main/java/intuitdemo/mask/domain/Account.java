package intuitdemo.mask.domain;

/**
 * Simple representation of an Account that contains some sensitive information such as the account number and
 * credit card number.
 *
 * The toString() has been overridden to mask sensitive information when logging Account info.
 *
 */
public class Account {
    private String account;
    private String cc;
    private String lastname;
    private String firstname;

    public Account(){}

    public Account(String account, String cc, String firstname, String lastname) {
        this.account = account;
        this.cc = cc;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Mask all characters except the last 4 chars.
    private String maskAccount() {
        if (account != null && account.length() > 4) {
            int lenToMask = account.length() - 4;
            return "xxxxxx".concat(account.substring(lenToMask));

        }
        return "Cannot display sensitive info - invalid account format";
    }

    // Mask all characters except the last 4 chars.
    private String maskCC() {
        if (cc != null && cc.length() > 15) {
            int lenToMask = cc.length() - 4;
            return "xxxx xxxx xxxx ".concat(cc.substring(lenToMask));
        }
        return "Cannot display sensitive info - invalid cc format";
    }

    @Override
    public String toString() {
        return "Account{" + "account='" + maskAccount() + '\'' + ", cc='" + maskCC() + '\'' + ", lastname='" + lastname + '\'' + ", firstname='" + firstname + '\'' + '}';
    }
}
