package com.carry.myproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity {
    @TableId
    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String email;
}
