package com.example.SpringBootHMS.service;


import java.util.Optional;

import com.example.SpringBootHMS.entity.User;

public interface UserService {
   public Optional<User> findUserByUserName(String userName);
   
}