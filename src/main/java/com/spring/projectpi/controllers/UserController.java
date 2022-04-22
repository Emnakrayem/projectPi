package com.spring.projectpi.controllers;

import com.spring.projectpi.entites.Role;
import com.spring.projectpi.entites.User;
import com.spring.projectpi.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @PutMapping("CompletondeProfil")
    public User Completiondeprofil(@RequestBody User user) {
        return us.Completiondeprofil(user);
    }
    @PostMapping("addrole")
    public Role saveRole(Role role) {
        return us.saveRole(role);
    }

    @Autowired
    UserServiceImpl us;
    @PostMapping("/add")
    @ResponseBody
    public User addUser(@RequestBody User user){
        return    us.addUser(user);
    }
    @PutMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return    us.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long id ){
        us.deleteUser(id);
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id){
        return us.getUser(id);
    }
    @GetMapping("/get-all")
    @ResponseBody
    public Set<User> getUsers(){
        return us.getUsers();
    }
}
