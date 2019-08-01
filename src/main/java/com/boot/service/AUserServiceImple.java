package com.boot.service;

import com.alibaba.fastjson.JSON;
import com.boot.db.entity.AUser;
import com.boot.db.entity.AUserExample;
import com.boot.db.mapper.AUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhang.wenhan
 * @description AUserServiceImple
 * @date 2019/4/22 17:02
 */
@Service
public class AUserServiceImple implements AUserService {

    @Autowired
    AUserMapper aUserMapper;

    @Autowired
    JsonService jsonService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testSave(String json) {
        AUser aUser = new AUser();
        aUser.setAge(28);
        aUser.setName("最外层");
        aUserMapper.insert(aUser);
        jsonService.save(json);
        AUserExample example = new AUserExample();
        List<AUser> list = aUserMapper.selectByExample(example);
        System.out.println("列表:" + JSON.toJSONString(list));
        if("0".equals(json)){
            AUser aUser1 = null;
            aUser1.getAge();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTranscation() {
        AUser aUser = new AUser();
        aUser.setAge(28);
        aUser.setName("最外层");
        aUser.setCreateTime(new Date());
        aUser.setUpdateTime(new Date());
        aUserMapper.insert(aUser);
        String s = null;
        s.equals("1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        aUser.setAge(38);
        aUser.setUpdateTime(new Date());
        aUserMapper.updateByPrimaryKey(aUser);
    }
}
