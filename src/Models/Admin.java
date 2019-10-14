package Models;

import java.io.Serializable;

public class Admin implements Serializable {
    private String name, password, email;
    public Admin(String name, String password){
        this.name = name;
        this.password = password;
    }
    public Admin(String name, String password, String email){
        this(name, password);
        this.email = email;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
