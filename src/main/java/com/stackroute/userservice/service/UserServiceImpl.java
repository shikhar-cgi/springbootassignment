package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
     UserRepository userRepository;

      @Autowired
     public UserServiceImpl(UserRepository userRepository)
     {
       this.userRepository=userRepository;
     }
    @Override
    public User saveUser(User user) {
        User SavedUser=userRepository.save(user);
        return SavedUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int userId) {
     userRepository.deleteById(userId);

    }

    @Override
    public User upadate(User user) {
        User updateUser=userRepository.getOne(user.getTrackid());
        updateUser.setTrackComment(user.getTrackComment());
        userRepository.save(updateUser);
        return updateUser;
    }
}
