package com.carry.myproject.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HonorRecordVO implements Serializable {
    private int hid;
    private String context;
    private String filePath;
}

