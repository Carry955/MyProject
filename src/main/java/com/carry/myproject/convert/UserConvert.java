package com.carry.myproject.convert;

import com.carry.myproject.entity.UserEntity;
import com.carry.myproject.security.user.UserDetail;
import com.carry.myproject.vo.UserVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserDetail convertDetail(UserEntity entity);

    @Mapping(target = "password", ignore = true)
    UserVO convert(UserEntity entity);

    UserEntity convert(UserVO vo);
}
