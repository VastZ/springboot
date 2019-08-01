package com.boot.db.mapper;

import java.util.List;

import com.boot.db.entity.RankList;

public interface RankListMapperSpec {

    public List<RankList> getListByParentId(Long parentId);
    
    public List<RankList> getH5ByParentId(Long parentId);
    
}