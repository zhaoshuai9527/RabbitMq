package com.MQ.Service.impl;

import com.MQ.Service.ServerAService;
import com.MQ.dao.ServerADao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServerAServiceImpl implements ServerAService {

    @Autowired
    private ServerADao serverADao;
    @Override
    public void insertA(int id,String name) {
        serverADao.insertA(id,name);
    }
}
