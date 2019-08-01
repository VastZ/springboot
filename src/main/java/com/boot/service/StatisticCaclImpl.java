package com.boot.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.db.StatisticsDay;
import com.boot.db.StatisticsDayExample;
import com.boot.db.dao.StatisticsDayMapper;

@Service
public class StatisticCaclImpl implements StatisticCacl{

    @Autowired
    StatisticsDayMapper mapper;

    @Override
    public void dealStatisticCacl() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2017-01-01");
        StatisticsDayExample example = new StatisticsDayExample();
        example.createCriteria().andCreateDateGreaterThanOrEqualTo(date);
        List<StatisticsDay> days = mapper.selectByExample(example);
        for (StatisticsDay day : days) {
//            day.setRegisterUserAndroid(getRegister(day.getNewUserAndroid(), day.getRegisterUserAndroid()));
//            day.setRegisterUserIos(getRegister(day.getNewUserIos(), day.getRegisterUserIos()));
            long activeUser = (long) (day.getAccumulateUser().longValue() * getRandomRate(3.4, 0.1) / 100);
            day.setActiveUser(activeUser);
            long day7 = getBefore(day.getCreateDate(), -7);
            double rate7 = getRandomRate(18, 4);
            day.setWeekRate(new BigDecimal(rate7));
            day.setWeekReserveUser((long)(day7 * rate7 / 100));
            long day14 = getBefore(day.getCreateDate(), -14);
            double rate14 = getRandomRate(14, 2);
            day.setDoubleWeekRate(new BigDecimal(rate14));
            day.setDoubleWeekReserveUser((long)(day14 * rate14 /100));
            long day30 = getBefore(day.getCreateDate(), -30);
            double rate30 = getRandomRate(9, 2);
            day.setMonthRate(new BigDecimal(rate30));
            day.setMonthReserveUser((long)(day30 * rate30 / 100 ));
            mapper.updateByPrimaryKeySelective(day);
        }
    }
    
    
    
    private long getBefore(Date date, int n) {
        date = StatisticCaclImpl.addSomeDays(date, n);
        StatisticsDayExample example = new StatisticsDayExample();
        example.createCriteria().andCreateDateEqualTo(date);
        List<StatisticsDay> days = mapper.selectByExample(example);
        return days.get(0).getRegisterUserTotal();
    }
    
    private double getRandomRate(double base, double rate) {
        Random random = new Random();
        double r = random.nextDouble() * rate; 
        base = base + r;
        return base;
    }

    private long getRegister(Long newUser, Long regUser) {
        long diff = newUser - regUser;
        long diffReg = (long) (diff * 0.55d);
        long newReg = regUser + diffReg;
        return newReg;
    }
    
    public static Date addSomeDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return new Date(calendar.getTime().getTime());
    }

}
