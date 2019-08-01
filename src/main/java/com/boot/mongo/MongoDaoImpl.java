//package com.boot.mongo;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import com.boot.db.pojo.Board;
//import com.boot.db.pojo.BoardDetail;
//
//@Component
//public class MongoDaoImpl implements MongoDao {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Override
//    public List<Board> getList() {
//
//        Query query = new Query(Criteria.where("type").is("P2P网贷").and("subType").is("网贷新手标收益率榜"));
//        List<Board> list = mongoTemplate.find(query, Board.class);
//
//        return list;
//    }
//
//    @Override
//    public List<BoardDetail> getList(String type, String subType) {
//        Criteria c = Criteria.where("type").is(type).and("subType").is(subType);
//        Query query = new Query(c);
//        List<BoardDetail> list = mongoTemplate.find(query, BoardDetail.class);
//        return list;
//    }
//
//}
