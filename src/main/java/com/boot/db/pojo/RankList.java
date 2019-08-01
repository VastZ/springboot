package com.boot.db.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class RankList implements Serializable{
    
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */ 
    private static final long serialVersionUID = -6389026750081193442L;

    private BigInteger id;
    
    // 父类ID
    private BigInteger parentId;
    
    // 标题
    private String title;
    
    // 子标题副标题
    private String titleExt;
    
    // 排序
    private Integer sort;
    
    // h5模板类型
    private Integer templateH5;
    
    // 版本号
    private String version;
    
    // 行情数据
    private Object data;
 
    // html源码
    private String html;
    
    // 修改时间
    private Date updateTime;
    
    // 创建时间
    private Date createTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleExt() {
        return titleExt;
    }

    public void setTitleExt(String titleExt) {
        this.titleExt = titleExt;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getTemplateH5() {
        return templateH5;
    }

    public void setTemplateH5(Integer templateH5) {
        this.templateH5 = templateH5;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
