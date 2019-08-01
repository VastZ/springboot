package com.boot.db.dao;


import com.alibaba.fastjson.JSONObject;
import com.boot.db.entity.OldLost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CalimMapper {
    
    List<JSONObject> getClaimList(@Param("uuid") String uuid);

    String getKindOfLoss(@Param("uuid") String uuid);

    List<JSONObject> getClaimPersonList(@Param("claimmainuuid") String claimmainuuid);

    JSONObject getSaleMan(@Param("orderMainUuid") String orderMainUuid);

    List<JSONObject> getHolderInsuranList(@Param("orderMainUuid") String orderMainUuid);

    List<String> getUuids();

    List<JSONObject> getResponse(@Param("uuids") List<String> uuids);

    List<OldLost> getOldLostData();

    int updateOldLostData(@Param("id") int id, @Param("status") int status);


}
