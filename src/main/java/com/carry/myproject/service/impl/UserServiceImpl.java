package com.carry.myproject.service.impl;

import com.carry.myproject.convert.UserConvert;
import com.carry.myproject.dao.UserDao;
import com.carry.myproject.entity.UserEntity;
import com.carry.myproject.service.UserService;
import com.carry.myproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserConvert userConvert = UserConvert.INSTANCE;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserVO vo) {
        UserEntity entity = userConvert.convert(vo);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userDao.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserVO vo) {
        userDao.updateById(userConvert.convert(vo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public UserVO getUser(Integer id) {
        UserEntity entity = userDao.selectById(id);
        return userConvert.convert(entity);
    }
}
