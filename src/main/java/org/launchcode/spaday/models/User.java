package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank (message = "Must enter a username between 5 and 15 characters")
    @Size(min = 5, max = 15, message = "Must enter a username between 5 and 15 characters")
    private String username;

    @Email (message = "Must enter a valid email")
    private String email;

    @NotBlank(message = "Must enter a password")
    @Size(min= 6, message = "Password must be 6 or more characters")
    private String password;

    @NotNull(message = "Passwords don't match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword=verifyPassword;
    }

    private void checkPassword(){
        if(verifyPassword != null && password != null && !password.equals(verifyPassword)){
            verifyPassword= null;
        }
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        checkPassword();
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
}
