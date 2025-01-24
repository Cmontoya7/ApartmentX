package com.gcu.apartmentx.models;

public class ApartmentXUser {
    private String username;
    private String email;
    private String password;
    private String nameFirst;
    private String nameLast;

    public ApartmentXUser(String username, String email, String password, String nameFirst, String nameLast) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst =
                nameFirst.substring(0, 1).toUpperCase() +
                        nameFirst.substring(1).toLowerCase();
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast =
                nameLast.substring(0, 1).toUpperCase() +
                        nameLast.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return "ApartmentXUser{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                '}';
    }
}
