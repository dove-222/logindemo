package com.smart.dao;

import com.smart.entity.User;

import java.util.Map;

public interface UserMapper {

    //定义CRUD相关的方法

    //根据id查询User
    public User getUserById(Integer id);

    //添加一个新的User
    public void addUser(User user);

    //修改一个User
    public void updateUser(User user);

    //删除一个User
    public Boolean deleteUserById(Integer id);

    public User getUserByIdAndUsername(Integer id, String username);

    public User getUserByMap(Map<String,Object> map);

}
