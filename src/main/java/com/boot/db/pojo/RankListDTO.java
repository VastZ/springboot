package com.boot.db.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class RankListDTO implements Serializable{
    
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */ 
    private static final long serialVersionUID = 8203350933287920493L;

    private BigInteger id;
    
    // 标题
    private String title;
    
    // 排序
    private Integer order;
    
    // 版本号
    private String version;
    
    // 子类型集合
    private List<RankList> subList;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<RankList> getSubList() {
        return subList;
    }

    public void setSubList(List<RankList> subList) {
        this.subList = subList;
    }
    
}
