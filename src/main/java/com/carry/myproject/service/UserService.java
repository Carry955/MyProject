package com.carry.myproject.service;

import com.carry.myproject.vo.UserVO;

import java.util.Iterator;

public interface UserService {
    void addUser(UserVO vo);
    void updateUser(UserVO vo);
    void deleteUser(Integer id);
    UserVO getUser(Integer id);
}
