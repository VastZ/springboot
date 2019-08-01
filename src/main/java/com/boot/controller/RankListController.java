package com.boot.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.boot.db.entity.RankList;
import com.boot.db.entity.RankListDTO;
import com.boot.db.entity.RequestDTO;
import com.boot.service.RankListService;

@RestController
@RequestMapping("/rankList")
public class RankListController {
    
    @Autowired
    RankListService rankListService;
    
    // 获取详情
    @RequestMapping(value="/getDetailById", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getDetailById(@RequestBody RequestDTO req) {
        JSONObject object = JSON.parseObject(req.getBusinessObject().toString());
        Long id = object.getLong("id");
        String type = object.getString("type");
        RankList rank = rankListService.getDetailById(id, type);
        return JSON.toJSONString(rank);
    }
    
    // 获取列表
    @RequestMapping(value="/getList", method=RequestMethod.POST)
    public String getList(@RequestBody RequestDTO req) {
        JSONObject object = JSON.parseObject(req.getBusinessObject().toString());
        Long parentId = object.getLong("parentId");
        List<RankList> ranks = rankListService.getList(parentId);
        return JSON.toJSONString(ranks);
    }
    
    // 根据ID进行更新
    @RequestMapping(value="/updateById", method=RequestMethod.POST)
    public String updateById(@RequestBody RequestDTO req) {
        System.out.println(JSON.toJSONString(req.getBusinessObject()));
        RankList rankList = JSON.parseObject(req.getBusinessObject().toString(), RankList.class);
        return rankListService.updateById(rankList);
    }
    
    // 获取H5详情和类型
    @RequestMapping(value="/getTypeAndH5", method=RequestMethod.POST)
    public String getTypeAndH5(@RequestBody RequestDTO req) {
        System.out.println(JSON.toJSONString(req.getBusinessObject()));
        // JSON的泛型转换时 使用 TypeReference 来进行
        List<RankList> ranks = JSON.parseObject(req.getBusinessObject().toString(), new TypeReference<List<RankList>>(){});
        List<RankListDTO> res =  rankListService.getTypeAndH5(ranks);
        return JSON.toJSONString(res);
    }
    
    public static void main(String[] args) {
        String str = "{\"items\":{\"aaa\":[{\"code\":123}], \"bbb\":[{\"code\":123}]}}";
        JSONObject obj = JSON.parseObject(str);
        JSONObject items = obj.getJSONObject("items");
        Set<String> keys =  items.keySet();
        for (String key : keys) {
            
        }
        
        
    }
    
}
