package com.carry.myproject.security.service;

import com.carry.myproject.convert.UserConvert;
import com.carry.myproject.dao.UserDao;
import com.carry.myproject.entity.UserEntity;
import com.carry.myproject.exception.FastException;
import com.carry.myproject.security.user.UserDetail;
import com.carry.myproject.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getByUsername(username);
        if (userEntity == null) {
            throw new FastException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        UserDetail userDetail = UserConvert.INSTANCE.convertDetail(userEntity);

        return userDetail;
    }
}
