package com.boot.db.entity;

import java.util.List;

public class RankListDTO extends RankList{
    
    private List<RankList> subRank;

    public List<RankList> getSubRank() {
        return subRank;
    }

    public void setSubRank(List<RankList> subRank) {
        this.subRank = subRank;
    }
    
}
