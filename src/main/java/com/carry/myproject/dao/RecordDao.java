package com.carry.myproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carry.myproject.entity.RecordEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordDao extends BaseMapper<RecordEntity> {

}
