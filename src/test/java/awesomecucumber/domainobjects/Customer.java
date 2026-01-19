package awesomecucumber.domainobjects;

public class Customer {
    private String Username;
    private String email;
    private String password;

    public Customer(String username, String email, String password) {
        this.Username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }
}
