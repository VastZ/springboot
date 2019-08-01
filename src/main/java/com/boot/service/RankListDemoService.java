package com.boot.service;

import com.boot.db.pojo.RankList;

public interface RankListDemoService {
    
    /**
     * 
     * @description 获取子榜单详情
     * @version 1.0.0
     * @author zhangwenhan 
     * @date 2018年8月8日 下午12:20:59
     * @param order
     * @param subOrder
     * @return 返回子榜单详情
     */
    public RankList getRankSubDetail(String order, String subOrder);
    
    public RankList getRankSubDetail1(String order, String subOrder);
    
    /**
     * @description 通过mysql来进行
     * @version 1.0.0
     * @author zhangwenhan 
     * @date 2018年8月8日 下午4:21:24
     * @param order
     * @param subOrder
     * @return 返回子榜单详情
     */
    public RankList getRankSubDetail2(Integer id);
    
    public com.boot.db.entity.RankList getRankSubDetail3(Long id);
}
