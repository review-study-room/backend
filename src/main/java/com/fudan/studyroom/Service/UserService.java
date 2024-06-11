package com.fudan.studyroom.service;

import com.fudan.studyroom.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    int insert(User user);
    
    int update(User user);

    List<User> selectByNameAndPassword(String userName, String passWord);

    User selectByName(String username);
}