package com.boot.db.mapper;

import com.boot.db.entity.TestJson;

public interface TestJsonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestJson record);

    int insertSelective(TestJson record);

    TestJson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestJson record);

    int updateByPrimaryKey(TestJson record);
}