package com.boot.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatisticsDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsDayExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalIsNull() {
            addCriterion("new_user_total is null");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalIsNotNull() {
            addCriterion("new_user_total is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalEqualTo(Long value) {
            addCriterion("new_user_total =", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalNotEqualTo(Long value) {
            addCriterion("new_user_total <>", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalGreaterThan(Long value) {
            addCriterion("new_user_total >", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("new_user_total >=", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalLessThan(Long value) {
            addCriterion("new_user_total <", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalLessThanOrEqualTo(Long value) {
            addCriterion("new_user_total <=", value, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalIn(List<Long> values) {
            addCriterion("new_user_total in", values, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalNotIn(List<Long> values) {
            addCriterion("new_user_total not in", values, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalBetween(Long value1, Long value2) {
            addCriterion("new_user_total between", value1, value2, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserTotalNotBetween(Long value1, Long value2) {
            addCriterion("new_user_total not between", value1, value2, "newUserTotal");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidIsNull() {
            addCriterion("new_user_android is null");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidIsNotNull() {
            addCriterion("new_user_android is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidEqualTo(Long value) {
            addCriterion("new_user_android =", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidNotEqualTo(Long value) {
            addCriterion("new_user_android <>", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidGreaterThan(Long value) {
            addCriterion("new_user_android >", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidGreaterThanOrEqualTo(Long value) {
            addCriterion("new_user_android >=", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidLessThan(Long value) {
            addCriterion("new_user_android <", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidLessThanOrEqualTo(Long value) {
            addCriterion("new_user_android <=", value, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidIn(List<Long> values) {
            addCriterion("new_user_android in", values, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidNotIn(List<Long> values) {
            addCriterion("new_user_android not in", values, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidBetween(Long value1, Long value2) {
            addCriterion("new_user_android between", value1, value2, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserAndroidNotBetween(Long value1, Long value2) {
            addCriterion("new_user_android not between", value1, value2, "newUserAndroid");
            return (Criteria) this;
        }

        public Criteria andNewUserIosIsNull() {
            addCriterion("new_user_ios is null");
            return (Criteria) this;
        }

        public Criteria andNewUserIosIsNotNull() {
            addCriterion("new_user_ios is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserIosEqualTo(Long value) {
            addCriterion("new_user_ios =", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosNotEqualTo(Long value) {
            addCriterion("new_user_ios <>", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosGreaterThan(Long value) {
            addCriterion("new_user_ios >", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosGreaterThanOrEqualTo(Long value) {
            addCriterion("new_user_ios >=", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosLessThan(Long value) {
            addCriterion("new_user_ios <", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosLessThanOrEqualTo(Long value) {
            addCriterion("new_user_ios <=", value, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosIn(List<Long> values) {
            addCriterion("new_user_ios in", values, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosNotIn(List<Long> values) {
            addCriterion("new_user_ios not in", values, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosBetween(Long value1, Long value2) {
            addCriterion("new_user_ios between", value1, value2, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andNewUserIosNotBetween(Long value1, Long value2) {
            addCriterion("new_user_ios not between", value1, value2, "newUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalIsNull() {
            addCriterion("register_user_total is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalIsNotNull() {
            addCriterion("register_user_total is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalEqualTo(Long value) {
            addCriterion("register_user_total =", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalNotEqualTo(Long value) {
            addCriterion("register_user_total <>", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalGreaterThan(Long value) {
            addCriterion("register_user_total >", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("register_user_total >=", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalLessThan(Long value) {
            addCriterion("register_user_total <", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalLessThanOrEqualTo(Long value) {
            addCriterion("register_user_total <=", value, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalIn(List<Long> values) {
            addCriterion("register_user_total in", values, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalNotIn(List<Long> values) {
            addCriterion("register_user_total not in", values, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalBetween(Long value1, Long value2) {
            addCriterion("register_user_total between", value1, value2, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserTotalNotBetween(Long value1, Long value2) {
            addCriterion("register_user_total not between", value1, value2, "registerUserTotal");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidIsNull() {
            addCriterion("register_user_android is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidIsNotNull() {
            addCriterion("register_user_android is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidEqualTo(Long value) {
            addCriterion("register_user_android =", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidNotEqualTo(Long value) {
            addCriterion("register_user_android <>", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidGreaterThan(Long value) {
            addCriterion("register_user_android >", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidGreaterThanOrEqualTo(Long value) {
            addCriterion("register_user_android >=", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidLessThan(Long value) {
            addCriterion("register_user_android <", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidLessThanOrEqualTo(Long value) {
            addCriterion("register_user_android <=", value, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidIn(List<Long> values) {
            addCriterion("register_user_android in", values, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidNotIn(List<Long> values) {
            addCriterion("register_user_android not in", values, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidBetween(Long value1, Long value2) {
            addCriterion("register_user_android between", value1, value2, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserAndroidNotBetween(Long value1, Long value2) {
            addCriterion("register_user_android not between", value1, value2, "registerUserAndroid");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosIsNull() {
            addCriterion("register_user_ios is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosIsNotNull() {
            addCriterion("register_user_ios is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosEqualTo(Long value) {
            addCriterion("register_user_ios =", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosNotEqualTo(Long value) {
            addCriterion("register_user_ios <>", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosGreaterThan(Long value) {
            addCriterion("register_user_ios >", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosGreaterThanOrEqualTo(Long value) {
            addCriterion("register_user_ios >=", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosLessThan(Long value) {
            addCriterion("register_user_ios <", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosLessThanOrEqualTo(Long value) {
            addCriterion("register_user_ios <=", value, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosIn(List<Long> values) {
            addCriterion("register_user_ios in", values, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosNotIn(List<Long> values) {
            addCriterion("register_user_ios not in", values, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosBetween(Long value1, Long value2) {
            addCriterion("register_user_ios between", value1, value2, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andRegisterUserIosNotBetween(Long value1, Long value2) {
            addCriterion("register_user_ios not between", value1, value2, "registerUserIos");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserIsNull() {
            addCriterion("accumulate_user is null");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserIsNotNull() {
            addCriterion("accumulate_user is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserEqualTo(Long value) {
            addCriterion("accumulate_user =", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserNotEqualTo(Long value) {
            addCriterion("accumulate_user <>", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserGreaterThan(Long value) {
            addCriterion("accumulate_user >", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("accumulate_user >=", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserLessThan(Long value) {
            addCriterion("accumulate_user <", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserLessThanOrEqualTo(Long value) {
            addCriterion("accumulate_user <=", value, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserIn(List<Long> values) {
            addCriterion("accumulate_user in", values, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserNotIn(List<Long> values) {
            addCriterion("accumulate_user not in", values, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserBetween(Long value1, Long value2) {
            addCriterion("accumulate_user between", value1, value2, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andAccumulateUserNotBetween(Long value1, Long value2) {
            addCriterion("accumulate_user not between", value1, value2, "accumulateUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserIsNull() {
            addCriterion("active_user is null");
            return (Criteria) this;
        }

        public Criteria andActiveUserIsNotNull() {
            addCriterion("active_user is not null");
            return (Criteria) this;
        }

        public Criteria andActiveUserEqualTo(Long value) {
            addCriterion("active_user =", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserNotEqualTo(Long value) {
            addCriterion("active_user <>", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserGreaterThan(Long value) {
            addCriterion("active_user >", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserGreaterThanOrEqualTo(Long value) {
            addCriterion("active_user >=", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserLessThan(Long value) {
            addCriterion("active_user <", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserLessThanOrEqualTo(Long value) {
            addCriterion("active_user <=", value, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserIn(List<Long> values) {
            addCriterion("active_user in", values, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserNotIn(List<Long> values) {
            addCriterion("active_user not in", values, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserBetween(Long value1, Long value2) {
            addCriterion("active_user between", value1, value2, "activeUser");
            return (Criteria) this;
        }

        public Criteria andActiveUserNotBetween(Long value1, Long value2) {
            addCriterion("active_user not between", value1, value2, "activeUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserIsNull() {
            addCriterion("week_reserve_user is null");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserIsNotNull() {
            addCriterion("week_reserve_user is not null");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserEqualTo(Long value) {
            addCriterion("week_reserve_user =", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserNotEqualTo(Long value) {
            addCriterion("week_reserve_user <>", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserGreaterThan(Long value) {
            addCriterion("week_reserve_user >", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserGreaterThanOrEqualTo(Long value) {
            addCriterion("week_reserve_user >=", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserLessThan(Long value) {
            addCriterion("week_reserve_user <", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserLessThanOrEqualTo(Long value) {
            addCriterion("week_reserve_user <=", value, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserIn(List<Long> values) {
            addCriterion("week_reserve_user in", values, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserNotIn(List<Long> values) {
            addCriterion("week_reserve_user not in", values, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserBetween(Long value1, Long value2) {
            addCriterion("week_reserve_user between", value1, value2, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekReserveUserNotBetween(Long value1, Long value2) {
            addCriterion("week_reserve_user not between", value1, value2, "weekReserveUser");
            return (Criteria) this;
        }

        public Criteria andWeekRateIsNull() {
            addCriterion("week_rate is null");
            return (Criteria) this;
        }

        public Criteria andWeekRateIsNotNull() {
            addCriterion("week_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWeekRateEqualTo(BigDecimal value) {
            addCriterion("week_rate =", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateNotEqualTo(BigDecimal value) {
            addCriterion("week_rate <>", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateGreaterThan(BigDecimal value) {
            addCriterion("week_rate >", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("week_rate >=", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateLessThan(BigDecimal value) {
            addCriterion("week_rate <", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("week_rate <=", value, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateIn(List<BigDecimal> values) {
            addCriterion("week_rate in", values, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateNotIn(List<BigDecimal> values) {
            addCriterion("week_rate not in", values, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("week_rate between", value1, value2, "weekRate");
            return (Criteria) this;
        }

        public Criteria andWeekRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("week_rate not between", value1, value2, "weekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserIsNull() {
            addCriterion("double_week_reserve_user is null");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserIsNotNull() {
            addCriterion("double_week_reserve_user is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserEqualTo(Long value) {
            addCriterion("double_week_reserve_user =", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserNotEqualTo(Long value) {
            addCriterion("double_week_reserve_user <>", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserGreaterThan(Long value) {
            addCriterion("double_week_reserve_user >", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserGreaterThanOrEqualTo(Long value) {
            addCriterion("double_week_reserve_user >=", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserLessThan(Long value) {
            addCriterion("double_week_reserve_user <", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserLessThanOrEqualTo(Long value) {
            addCriterion("double_week_reserve_user <=", value, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserIn(List<Long> values) {
            addCriterion("double_week_reserve_user in", values, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserNotIn(List<Long> values) {
            addCriterion("double_week_reserve_user not in", values, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserBetween(Long value1, Long value2) {
            addCriterion("double_week_reserve_user between", value1, value2, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekReserveUserNotBetween(Long value1, Long value2) {
            addCriterion("double_week_reserve_user not between", value1, value2, "doubleWeekReserveUser");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateIsNull() {
            addCriterion("double_week_rate is null");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateIsNotNull() {
            addCriterion("double_week_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateEqualTo(BigDecimal value) {
            addCriterion("double_week_rate =", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateNotEqualTo(BigDecimal value) {
            addCriterion("double_week_rate <>", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateGreaterThan(BigDecimal value) {
            addCriterion("double_week_rate >", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("double_week_rate >=", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateLessThan(BigDecimal value) {
            addCriterion("double_week_rate <", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("double_week_rate <=", value, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateIn(List<BigDecimal> values) {
            addCriterion("double_week_rate in", values, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateNotIn(List<BigDecimal> values) {
            addCriterion("double_week_rate not in", values, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_week_rate between", value1, value2, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andDoubleWeekRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_week_rate not between", value1, value2, "doubleWeekRate");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserIsNull() {
            addCriterion("month_reserve_user is null");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserIsNotNull() {
            addCriterion("month_reserve_user is not null");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserEqualTo(Long value) {
            addCriterion("month_reserve_user =", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserNotEqualTo(Long value) {
            addCriterion("month_reserve_user <>", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserGreaterThan(Long value) {
            addCriterion("month_reserve_user >", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserGreaterThanOrEqualTo(Long value) {
            addCriterion("month_reserve_user >=", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserLessThan(Long value) {
            addCriterion("month_reserve_user <", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserLessThanOrEqualTo(Long value) {
            addCriterion("month_reserve_user <=", value, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserIn(List<Long> values) {
            addCriterion("month_reserve_user in", values, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserNotIn(List<Long> values) {
            addCriterion("month_reserve_user not in", values, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserBetween(Long value1, Long value2) {
            addCriterion("month_reserve_user between", value1, value2, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthReserveUserNotBetween(Long value1, Long value2) {
            addCriterion("month_reserve_user not between", value1, value2, "monthReserveUser");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNull() {
            addCriterion("month_rate is null");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNotNull() {
            addCriterion("month_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRateEqualTo(BigDecimal value) {
            addCriterion("month_rate =", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotEqualTo(BigDecimal value) {
            addCriterion("month_rate <>", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThan(BigDecimal value) {
            addCriterion("month_rate >", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_rate >=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThan(BigDecimal value) {
            addCriterion("month_rate <", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_rate <=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateIn(List<BigDecimal> values) {
            addCriterion("month_rate in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotIn(List<BigDecimal> values) {
            addCriterion("month_rate not in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_rate between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_rate not between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}