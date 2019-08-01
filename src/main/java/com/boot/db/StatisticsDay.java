package com.boot.db;

import java.math.BigDecimal;
import java.util.Date;

public class StatisticsDay {
    /** */
    private Long id;

    /** 总新增用户*/
    private Long newUserTotal;

    /** 新增用户android*/
    private Long newUserAndroid;

    /** 新增用户ios*/
    private Long newUserIos;

    /** 总注册用户*/
    private Long registerUserTotal;

    /** 新注册用户android*/
    private Long registerUserAndroid;

    /** 新注册用户ios*/
    private Long registerUserIos;

    /** 累积用户*/
    private Long accumulateUser;

    /** 日活*/
    private Long activeUser;

    /** 七日留存*/
    private Long weekReserveUser;

    /** 周留存百分比*/
    private BigDecimal weekRate;

    /** 双周留存*/
    private Long doubleWeekReserveUser;

    /** 双周留存百分比*/
    private BigDecimal doubleWeekRate;

    /** 月留存*/
    private Long monthReserveUser;

    /** 月留存百分比*/
    private BigDecimal monthRate;

    /** 日期*/
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewUserTotal() {
        return newUserTotal;
    }

    public void setNewUserTotal(Long newUserTotal) {
        this.newUserTotal = newUserTotal;
    }

    public Long getNewUserAndroid() {
        return newUserAndroid;
    }

    public void setNewUserAndroid(Long newUserAndroid) {
        this.newUserAndroid = newUserAndroid;
    }

    public Long getNewUserIos() {
        return newUserIos;
    }

    public void setNewUserIos(Long newUserIos) {
        this.newUserIos = newUserIos;
    }

    public Long getRegisterUserTotal() {
        return registerUserTotal;
    }

    public void setRegisterUserTotal(Long registerUserTotal) {
        this.registerUserTotal = registerUserTotal;
    }

    public Long getRegisterUserAndroid() {
        return registerUserAndroid;
    }

    public void setRegisterUserAndroid(Long registerUserAndroid) {
        this.registerUserAndroid = registerUserAndroid;
    }

    public Long getRegisterUserIos() {
        return registerUserIos;
    }

    public void setRegisterUserIos(Long registerUserIos) {
        this.registerUserIos = registerUserIos;
    }

    public Long getAccumulateUser() {
        return accumulateUser;
    }

    public void setAccumulateUser(Long accumulateUser) {
        this.accumulateUser = accumulateUser;
    }

    public Long getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Long activeUser) {
        this.activeUser = activeUser;
    }

    public Long getWeekReserveUser() {
        return weekReserveUser;
    }

    public void setWeekReserveUser(Long weekReserveUser) {
        this.weekReserveUser = weekReserveUser;
    }

    public BigDecimal getWeekRate() {
        return weekRate;
    }

    public void setWeekRate(BigDecimal weekRate) {
        this.weekRate = weekRate;
    }

    public Long getDoubleWeekReserveUser() {
        return doubleWeekReserveUser;
    }

    public void setDoubleWeekReserveUser(Long doubleWeekReserveUser) {
        this.doubleWeekReserveUser = doubleWeekReserveUser;
    }

    public BigDecimal getDoubleWeekRate() {
        return doubleWeekRate;
    }

    public void setDoubleWeekRate(BigDecimal doubleWeekRate) {
        this.doubleWeekRate = doubleWeekRate;
    }

    public Long getMonthReserveUser() {
        return monthReserveUser;
    }

    public void setMonthReserveUser(Long monthReserveUser) {
        this.monthReserveUser = monthReserveUser;
    }

    public BigDecimal getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}