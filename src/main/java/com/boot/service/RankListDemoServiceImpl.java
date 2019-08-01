package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.db.dao.RankMapper;
//import com.boot.mongo.RankListDao;
import com.boot.db.pojo.RankList;

@Service
public class RankListDemoServiceImpl implements RankListDemoService {

//    @Autowired
//    RankListDao rankListDao;
//
//    @Autowired
//    RankMapper rankMapper;
//
//    @Autowired
//    com.boot.db.mapper.RankListMapper rankListMapper;
    
    @Override
    public RankList getRankSubDetail(String order, String subOrder) {
//        return rankListDao.getRankSubDetail(order, subOrder);
        return null;
    }

    @Override
    public RankList getRankSubDetail1(String order, String subOrder) {
//        return rankListDao.getRankSubDetail1(order, subOrder);
        return null;
    }

    @Override
    public RankList getRankSubDetail2(Integer id) {
//        return rankMapper.getRankListById(id);
        return null;
    }
    
    @Override
    public com.boot.db.entity.RankList getRankSubDetail3(Long id) {
//        return rankListMapper.selectByPrimaryKey(id);
        return null;
    }
    
}
