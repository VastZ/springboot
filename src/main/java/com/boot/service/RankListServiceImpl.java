package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.db.entity.RankList;
import com.boot.db.entity.RankListDTO;
import com.boot.db.mapper.RankListMapper;
import com.boot.db.mapper.RankListMapperSpec;

@Service
public class RankListServiceImpl implements RankListService {

    @Autowired
    RankListMapper rankListMapper;
    
    @Autowired
    RankListMapperSpec rankListMapperSpec;
    
    @Override
    public RankList getDetailById(Long id, String type) {
        RankList rankList = rankListMapper.selectByPrimaryKey(id);
        if ("H5".equals(type)) { // H5查询详情不下发html源码
            rankList.setHtml(null);
        }
        return rankList;
    }

    @Override
    public List<RankList> getList(Long parentId) {
        return rankListMapperSpec.getListByParentId(parentId);
    }

    @Override
    public List<RankListDTO> getTypeAndH5(List<RankList> rankList) {
        // 查询parentId=0的所有信息， 然后比较version是否相等 不相等的查询子类型并下发
        List<RankList> ranks = rankListMapperSpec.getH5ByParentId(0L);
        for (RankList rank : ranks) {
            for (RankList rank1: rankList) {
                if (rank1.getId() == rank.getId() && rank1.getMarketVersion().equals(rank.getMarketVersion())) {
                    ranks.remove(rank);
                }
            }
        }
        List<RankListDTO> rankDTOs = new ArrayList<RankListDTO>();
        for (RankList rank : ranks) {
            RankListDTO rankListDTO = new RankListDTO();
            BeanUtils.copyProperties(rank, rankListDTO);
            rankListDTO.setSubRank(rankListMapperSpec.getH5ByParentId(rankListDTO.getId()));
        }
        return rankDTOs;
    }

    @Override
    public String updateById(RankList rankList) {
        Integer res =  rankListMapper.updateByPrimaryKeySelective(rankList);
        return res.toString();
    }

}
