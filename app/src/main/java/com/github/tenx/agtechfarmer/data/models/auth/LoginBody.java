package com.github.tenx.agtechfarmer.data.models.auth;

public class LoginBody {
    private String email;
    private String password;

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

    public LoginBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
