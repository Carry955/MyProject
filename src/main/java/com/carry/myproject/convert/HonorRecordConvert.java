package com.carry.myproject.convert;

import com.carry.myproject.entity.HonorRecordEntity;
import com.carry.myproject.vo.HonorRecordVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HonorRecordConvert {
    HonorRecordConvert INSTANCE = Mappers.getMapper(HonorRecordConvert.class);

    @Mapping(target = "uid", ignore = true)
    HonorRecordEntity convert(HonorRecordVO vo);

    HonorRecordVO convert(HonorRecordEntity entity);
}
