package com.carry.myproject.security.service;

import com.carry.myproject.dao.ClientDao;
import com.carry.myproject.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

//@Service
//public class ClientDetailService implements ClientDetailsService {
//    @Autowired
//    private ClientDao clientDao;
//
//    @Override
//    public ClientDetails loadClientByClientId(String clientId) {
//        ClientEntity clientEntity = clientDao.getByClientId(clientId);
//
//        BaseClientDetails clientDetails = new BaseClientDetails();
//        clientDetails.setClientId(clientId);
//        return clientDetails;
//    }
//}
