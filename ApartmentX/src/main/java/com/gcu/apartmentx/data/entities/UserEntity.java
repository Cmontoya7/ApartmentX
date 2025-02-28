package com.gcu.apartmentx.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity class representing a user in the database
 * Maps to the "USERS" table and provides properties for user details
 */
@Table("USERS")
public class UserEntity {
    @Id
    private int id;
    @Column("TYPE")
    private String type;
    @Column("USERNAME")
    private String username;
    @Column("EMAIL")
    private String email;
    @Column("PASSWORD")
    private String password;
    @Column("FIRST_NAME")
    private String firstName;
    @Column("LAST_NAME")
    private String lastName;

    /**
     * Default constructor
     */
    public UserEntity() {}

    /**
     * Constructor for creating a UserEntity with all fields including id
     * @param id the unique identifier for the user
     * @param type the type of the user
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     */
    public UserEntity(int id, String type, String username, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor for creating a UserEntity without
     * @param type the type of the user
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     */
    public UserEntity(String type, String username, String email, String password, String firstName, String lastName) {
        this.type = type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Gets the unique identifier for the user
     * @return the id of the user
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the unique identifier for the user
     * @param id the unique identifier for the user
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the type of the user (e.g., admin, tenant, landlord)
     * @return the type of the user
     */
    public String getType() {
        return type;
    }
    /**
     * Sets the type of the user (e.g., admin, tenant, landlord)
     * @param type the type of the user
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Gets the email of the user
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email of the user
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Gets the username of the user
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the username of the user
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Gets the password of the user
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the password of the user
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Gets the first name of the user
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name of the user
     * @param firstName the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the last name of the user
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the user
     * @param lastName the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
