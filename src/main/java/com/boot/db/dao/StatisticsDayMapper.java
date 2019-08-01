package com.boot.db.dao;

import java.util.List;

import com.boot.db.StatisticsDay;
import com.boot.db.StatisticsDayExample;

public interface StatisticsDayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatisticsDay record);

    int insertSelective(StatisticsDay record);

    List<StatisticsDay> selectByExample(StatisticsDayExample example);

    StatisticsDay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatisticsDay record);

    int updateByPrimaryKey(StatisticsDay record);
}