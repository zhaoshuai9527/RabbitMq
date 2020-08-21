package com.MQ.Service.impl;

import com.MQ.Service.ServerCService;
import com.MQ.dao.ServerCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServerCServiceImpl implements ServerCService {

    @Autowired
    private ServerCDao serverCDao;
    @Override
    public void insertC(int id,String name) {
        serverCDao.insertC(id,name);
    }


}
