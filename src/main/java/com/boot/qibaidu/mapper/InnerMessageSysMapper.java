package com.boot.qibaidu.mapper;


import com.boot.qibaidu.entity.InnerMessageSys;

public interface InnerMessageSysMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(InnerMessageSys record);

    int insertSelective(InnerMessageSys record);

    InnerMessageSys selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(InnerMessageSys record);

    int updateByPrimaryKey(InnerMessageSys record);
}