package com.carry.myproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("record")
public class RecordEntity {
    @TableId
    private String id;
    private String data;
}
