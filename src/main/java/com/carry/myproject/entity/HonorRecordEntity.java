package com.carry.myproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@TableName("hrecord")
public class HonorRecordEntity extends BaseEntity {
    @TableId
    private Integer id;
    private Integer hid;
    private Integer uid;
    private String context;
    private String filePath;
}
