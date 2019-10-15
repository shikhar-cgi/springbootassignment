package com.stackroute.userservice.controller;


import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {
    @Autowired
    UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody  User user)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/getuser")
    public ResponseEntity<?> getALLUsers()
    {

        ResponseEntity responseEntity;
        try
        {
            responseEntity=new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.upadate(user);
            responseEntity=new ResponseEntity<String>("sucessfully updated" ,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.deleteUser(userId);
            responseEntity=new ResponseEntity<String>("sucessfully deleted  " ,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

