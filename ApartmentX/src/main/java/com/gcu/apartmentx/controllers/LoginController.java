package com.gcu.apartmentx.controllers;

import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import com.gcu.apartmentx.business.AuthenticationBean;
import com.gcu.apartmentx.business.AuthenticationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.apartmentx.models.LoginModel;

@Controller
public class LoginController {
    @Autowired
    private AuthenticationInterface authentication;

    /**
     * Handles GET requests to the root URI and sets up the model
     */
    @GetMapping("/login")
    public String display(Model model, HttpSession session) {
        if (session.getAttribute("user") != null)
            return "Homepage";
        // Set the title attribute
        model.addAttribute("title", "Login Form");

        // Set the loginModel attribute with an instance of LoginModel
        model.addAttribute("loginModel", new LoginModel());

        // Return the view name "login"
        return "Login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, Model model, HttpSession session) {
        // Check for submission errors and retrieve any error messages
        String msg = authentication.authenticate(loginModel.getUsername(), loginModel.getPassword());
        if (!((AuthenticationBean) authentication).getAuthenticationResult()) { 
            model.addAttribute("title", "Login Form");
            // Send the error message to the HTML
            model.addAttribute("message", msg);
            return "Login";
        } else {
            // Return the view name for orders
            String[] split = msg.split(":");
            String msg1 = split[0];
            String msg2 = split[1];
            String msg3 = split[2];
            session.setAttribute("username", msg1);
            session.setAttribute("level", msg2);
            session.setAttribute("id", msg3);
            return "Homepage";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Ends session so to Log out the User
        session.invalidate();
        return "Homepage";
    }
}
