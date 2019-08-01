package com.boot.db.pojo;

import java.io.Serializable;

public class Board implements Serializable {

    /** 
     * @Fields serialVersionUID : 
     */ 
    private static final long serialVersionUID = -5253971542425380530L;
    
    private String id;
    
    private String type;
    
    private String subType;
    
    private Object data;

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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
}
