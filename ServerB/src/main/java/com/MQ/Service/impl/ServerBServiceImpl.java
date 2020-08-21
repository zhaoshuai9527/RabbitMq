package com.MQ.Service.impl;

import com.MQ.Service.ServerBService;
import com.MQ.dao.ServerBDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServerBServiceImpl implements ServerBService {

    @Autowired
    private ServerBDao serverBDao;
    @Override
    public void insertB(int id,String name) {
        serverBDao.insertB(id,name);
    }


}
