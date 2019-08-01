package com.boot.db.pojo;

import java.io.Serializable;
import java.util.List;

public class BoardDetail implements Serializable {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */ 
    private static final long serialVersionUID = 4180316760852403744L;

    private String id;
    
    private String type;
    
    private String title;
    
    private String subType;
    
    private String subTitle;
    
    private String subTitleExt;
    
    private String templateType;
    
    private List<Object> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitleExt() {
        return subTitleExt;
    }

    public void setSubTitleExt(String subTitleExt) {
        this.subTitleExt = subTitleExt;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
    
}
