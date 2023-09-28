package com.carry.myproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carry.myproject.convert.HonorRecordConvert;
import com.carry.myproject.dao.HonorRecordDao;
import com.carry.myproject.entity.HonorRecordEntity;
import com.carry.myproject.service.RequestService;
import com.carry.myproject.vo.HonorRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private HonorRecordDao honorRecordDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void process(Integer uid, HonorRecordVO vo) {
        HonorRecordEntity entity = HonorRecordConvert.INSTANCE.convert(vo);
        entity.setUid(uid);
        honorRecordDao.insert(entity);
    }

    @Override
    @Cacheable(value = "hrecord", key = "#uid.toString() + ':' +#hid.toString()")
    public HonorRecordVO get(Integer uid, Integer hid) {
        HonorRecordEntity entity = honorRecordDao.selectOne(new QueryWrapper<HonorRecordEntity>().eq("uid", uid).eq("hid", hid));
        return HonorRecordConvert.INSTANCE.convert(entity);
    }

    @Override
    @CachePut(value = "hrecord", key = "#uid.toString() + ':' +#hid.toString()")
    public HonorRecordVO redisSave(Integer uid, Integer hid, HonorRecordVO vo) {
        return vo;
    }
}
