package com.MQ.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ServerBDao {

    void insertB(@Param("id") int id, @Param("name") String name);
}
