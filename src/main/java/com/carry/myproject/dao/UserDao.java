package com.carry.myproject.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carry.myproject.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    default UserEntity getByUsername(String username) {
        return this.selectOne(new QueryWrapper<UserEntity>().eq("username", username));
    }
}
