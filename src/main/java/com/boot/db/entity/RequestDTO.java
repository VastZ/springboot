package com.boot.db.entity;

import java.io.Serializable;

public class RequestDTO implements Serializable{
    
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */ 
    
    private static final long serialVersionUID = 6380257038376325424L;

    private String sign;
    
    private String vesion;
    
    private Object businessObject;
    
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getVesion() {
        return vesion;
    }

    public void setVesion(String vesion) {
        this.vesion = vesion;
    }

    public Object getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(Object businessObject) {
        this.businessObject = businessObject;
    }
    
}
