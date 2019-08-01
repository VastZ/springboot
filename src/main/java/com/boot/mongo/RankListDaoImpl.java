//package com.boot.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import com.boot.db.pojo.RankList;
//import com.mongodb.BasicDBObject;
//
//@Component
//public class RankListDaoImpl implements RankListDao {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Override
//    public RankList getRankSubDetail(String order, String subOrder) {
//        Criteria c = Criteria.where("order").is(order).and("subOrder").is(subOrder);
//        Query query = new Query(c);
//        RankList sub = mongoTemplate.findOne(query, RankList.class);
//        return sub;
//    }
//
//    @Override
//    public RankList getRankSubDetail1(String order, String subOrder) {
//        BasicDBObject dbObject = new BasicDBObject();
//        dbObject.put("order", order); // 查询条件
//        dbObject.put("subOrder", subOrder);
//        BasicDBObject fieldsObject = new BasicDBObject();
//        // 指定返回的字段
//        fieldsObject.put("data", false);
////        Query query = new BasicQuery(dbObject, fieldsObject); 2.0.10的springdatamongoDB 有点区别
////
////        RankList sub = mongoTemplate.findOne(query, RankList.class);
////        return sub;
//        return null;
//    }
//
//}
