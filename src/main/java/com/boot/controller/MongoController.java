//package com.boot.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.boot.mongo.MongoDao;
//import com.boot.pojo.Board;
//import com.boot.pojo.BoardDetail;
//import com.boot.pojo.RankList;
//import com.boot.service.RankListDemoService;
//
//@RestController
//@RequestMapping("/mongo")
//public class MongoController {
//    
//    @Autowired
//    MongoDao mongoDao;
//    
//    @Autowired
//    RankListDemoService rankListService;
//    
//    @RequestMapping("/test")
//    public String test() {
//        List<Board> list = mongoDao.getList();
//        return  JSON.toJSONString(list);
//    }
//    
//    @RequestMapping("/test1")
//    public String test1() {
//        List<BoardDetail> list = mongoDao.getList("1", "2");
//        return  JSON.toJSONString(list);
//    }
//    
//    
//    @RequestMapping("/test2")
//    public String test2(String order, String subOrder) {
//        RankList detail = rankListService.getRankSubDetail(order, subOrder);
//        return  JSON.toJSONString(detail);
//    }
//    
//    @RequestMapping("/test3")
//    public String test3(String order, String subOrder) {
//        RankList detail = rankListService.getRankSubDetail1(order, subOrder);
//        return  JSON.toJSONString(detail);
//    }
//    @RequestMapping("/test4")
//    public String test4(Integer id) {
//        RankList detail = rankListService.getRankSubDetail2(id);
//        String str = JSON.toJSONString(detail);
//        System.out.println(str);
//        return  str;
//    }
//    
//    @RequestMapping("/test5")
//    public String test5(Long id) {
//        com.boot.entity.RankList detail = rankListService.getRankSubDetail3(id);
//        String str = JSON.toJSONString(detail);
//        System.out.println(str);
//        return  str;
//    }
//    
//    
//}
