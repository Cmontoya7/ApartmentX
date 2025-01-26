package com.gcu.apartmentx.business;

import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AuthenticationBean {
    public boolean result = false;

    public String authenticate(String username, String password) {

        //Psuedo-Database for users
        List<ApartmentXUser> userList = new ArrayList<>();
        userList.add(new ApartmentXUser("username", "email@email.com", "testword", "Chris", "Name"));
        userList.add(new ApartmentXUser("username2", "email2@email.com", "testword2", "User2", "Name2"));
        userList.add(new ApartmentXUser("username3", "email3@email.com", "testword3", "user3", "name3"));
        userList.add(new ApartmentXUser("username4", "email4@email.com", "testword4", "user4", "name4"));
        userList.add(new ApartmentXUser("username5", "email5@email.com", "testword5", "user5", "name5"));

        //Authentication of Username and Password
        String msg = "message null";
        boolean userExists = false;
        boolean passwordMatch = false;
        for (ApartmentXUser user : userList) {
            if (user.getUsername().equals(username)){
                userExists = true;

                if (user.getPassword().equals(password)){
                    passwordMatch = true;
                    msg = user.getNameFirst();
                    result = true;
                    break;
                }
            }
        }
        //Error message for failed loggin.
        if (!userExists) {
            msg ="Username does not exist: " + username;
        } else if (!passwordMatch) {
            msg ="Password did not match";
        }
        //Print any message for testing purposes
        System.out.println(msg);
        return msg;
    }
}
