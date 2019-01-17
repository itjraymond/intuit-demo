package intuitdemo.mask.domain;

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
}
