package com.smart.service;

import com.smart.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean hasMatch(String username,String password){
        System.out.println("service");
        int count=userDAO.ValidUser(username,password);
        return count>0;
    }

}
