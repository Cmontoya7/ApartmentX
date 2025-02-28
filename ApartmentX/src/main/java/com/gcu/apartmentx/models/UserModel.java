package com.gcu.apartmentx.models;

/**
 * Represents a user in the apartment system.
 * Contains personal information, login credentials, and user type.
 */
public class UserModel {
    private String type;
    private String username;
    private String email;
    private String password;
    private String nameFirst;
    private String nameLast;

    /**
     * Constructor to initialize a UserModel object with provided details
     * @param type the type of the user (e.g., admin, tenant, landlord)
     * @param username the username of the user
     * @param email the email address of the user
     * @param password the password of the user
     * @param nameFirst the first name of the user
     * @param nameLast the last name of the user
     */
    public UserModel(String type, String username, String email, String password, String nameFirst, String nameLast) {
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
    }

    /**
     * Retrieves the type of the user
     * @return the type of the user
     */
    public String getType() {
        return type;
    }
    /**
     * Sets the type of the user (e.g., admin, tenant, landlord)
     * @param type the type to assign to the user
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Retrieves the email of the user
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the username of the user
     * @param username the username to assign to the user
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Retrieves the username of the user
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the email of the user
     * @param email the email to assign to the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Retrieves the password of the user
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the password of the user
     * @param password the password to assign to the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Retrieves the first name of the user
     * @return the first name of the user
     */
    public String getNameFirst() {
        return nameFirst;
    }
    /**
     * Sets the first name of the user, capitalizing the first letter
     * @param nameFirst the first name to assign to the user
     */
    public void setNameFirst(String nameFirst) {
        this.nameFirst =
                nameFirst.substring(0, 1).toUpperCase() +
                nameFirst.substring(1).toLowerCase();
    }
    /**
     * Retrieves the last name of the user
     * @return the last name of the user
     */
    public String getNameLast() {
        return nameLast;
    }
    /**
     * Sets the last name of the user, capitalizing the first letter
     * @param nameLast the last name to assign to the user
     */
    public void setNameLast(String nameLast) {
        this.nameLast =
                nameLast.substring(0, 1).toUpperCase() +
                nameLast.substring(1).toLowerCase();
    }

    /**
     * Returns a string representation of the UserModel object
     * @return a string representation of the user with their details
     */
    @Override
    public String toString() {
        return "ApartmentXUser{" +
                "type=" + type + '\'' +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                '}';
    }
}
