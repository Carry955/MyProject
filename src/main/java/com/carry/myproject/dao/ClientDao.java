package com.carry.myproject.dao;

import com.carry.myproject.entity.ClientEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientDao {
    default ClientEntity getByClientId(String clientId) {
        return new ClientEntity();
    }
}
