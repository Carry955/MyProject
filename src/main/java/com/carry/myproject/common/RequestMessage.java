package com.carry.myproject.common;

import com.carry.myproject.vo.HonorRecordVO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RequestMessage implements Serializable {
    private Integer uid;
    private HonorRecordVO vo;
}
