package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public void deleteUser(int userId);
    public User upadate(User user);

}
