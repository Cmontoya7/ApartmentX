package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DeleteUserContoller {
    private UserEntity user;

    @Autowired
    private UserDataService service;

    @GetMapping("/delete")
    public String deleteUser(Model m) {
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "DeleteUser";
    }

    @PostMapping("/delete/confirm")
    public String confirmDeleteUser(Model m, @RequestParam(value = "action", required = false) int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "ConfirmDeleteUser";
    }

    @PostMapping("/delete/isconfirmed")
    public String doDeleteUser(Model m, @RequestParam(value = "action", required = false) boolean confirm) {
        if (confirm) {
            service.delete(user.getId());
            String msg = "Username: " + user.getUsername() + " was Deleted";
            m.addAttribute("msg", msg);
        }
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "DeleteUser";
    }

    @PostMapping("/update")
    public String updateUser(Model m, @RequestParam(value = "action", required = false) int id, HttpSession session) {
        if (session.getAttribute("level").equals("Admin")){
            user = service.findById(id);
        } else {
            String sId = (String) session.getAttribute("id");
            try {
                id = Integer.parseInt(sId);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            user = service.findById(id);
        }
        m.addAttribute("user", user);
        return "UpdateUser";
    }

    @PostMapping("/update/doupdate")
    public String doUpdateUser(Model m, @RequestParam(value = "action", required = false) String value) {

    }

}
