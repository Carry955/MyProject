package com.carry.myproject.vo;

import lombok.Data;

@Data
public class DataSourceVO {
    private String url;
    private String driverClass;
    private String username;
    private String password;
}
