package com.boot.db.entity;

import com.alibaba.fastjson.JSONObject;

public class TestJson {
    private Integer id;

    private String name;

    private JSONObject data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}