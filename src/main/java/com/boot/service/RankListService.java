package com.boot.service;

import java.util.List;

import com.boot.db.entity.RankList;
import com.boot.db.entity.RankListDTO;

public interface RankListService {
    
    public RankList getDetailById(Long id, String type);
    
    public List<RankList> getList(Long parentId);
    
    public List<RankListDTO> getTypeAndH5(List<RankList> rankList);
    
    public String updateById(RankList rankList);
}
