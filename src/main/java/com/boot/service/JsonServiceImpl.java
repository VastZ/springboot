package com.boot.service;

import com.boot.db.entity.AUser;
import com.boot.db.mapper.AUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhang.wenhan
 * @description JsonServiceImpl
 * @date 2019/4/22 13:56
 */
@Service
public class JsonServiceImpl implements JsonService {

    @Autowired
    AUserMapper aUserMapper ;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String json) {
        try {
            AUser user = new AUser();
            user.setAge(18);
            user.setName("张三");
            aUserMapper.insert(user);
        } catch (Exception e){
            System.out.println("JsonServiceImpl save 出现异常");
        } finally {
            System.out.println("异常后的finally处理");
            this.save1(json);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save1(String json) {
        AUser user = new AUser();
        user.setAge(20);
        user.setName("李四");
        aUserMapper.insert(user);
    }

}
