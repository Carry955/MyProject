package com.carry.myproject.service;

import com.carry.myproject.vo.HonorRecordVO;

public interface RequestService {
    void process(Integer uid, HonorRecordVO vo);

    HonorRecordVO get(Integer uid, Integer hid);

    HonorRecordVO redisSave(Integer uid, Integer hid,  HonorRecordVO vo);
}
