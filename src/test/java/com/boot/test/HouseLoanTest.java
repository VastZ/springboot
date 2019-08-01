package com.boot.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.fastjson.JSON;

public class HouseLoanTest {

    public static void main(String[] args) {
        getLoanMonthPay(new BigDecimal(1000000), new BigDecimal(4.9), 10, 360, new Date());
    }
    

    /**
     * @description 根据指定期数获取当期还款信息
     * @version 1.0.0
     * @author zhangwenhan
     * @date 2018年10月13日 上午10:55:49
     * @param loanPrincipal
     *            贷款总本金
     * @param rate
     *            贷款利率
     * @param currentPeriod
     *            当前期数
     * @param totalPeriod
     *            总期数
     * @param startPayDate
     *            首次还款日
     * @return 返回当期还款
     */
    public static void getLoanMonthPay(BigDecimal loanPrincipal, BigDecimal rate, Integer currentPeriod,
            Integer totalPeriod, Date startPayDate) {
//        double origin = loanPrincipal.doubleValue(); // 贷款总本金
//        double monthRate = rate.doubleValue() / 12.0d / 100.0d;// 月利息
//        double bonus; // 每期利息
//        double monthCost = parseDouble(loanPrincipal.doubleValue() / totalPeriod); // 每期代还本金
//        LoanHouseHistoryVO loanHouse = new LoanHouseHistoryVO();
//        Date paybackDate = ToolsUtil.getYearAndMonthYYYYMMDD(startPayDate, currentPeriod - 1);
//        loanHouse.setPaybackDate(paybackDate);
//        loanHouse.setTitle(formatDate(paybackDate, "yyyy年MM月"));
//        if (currentPeriod.equals(totalPeriod)) { // 如果是最后一期
//            BigDecimal interest = getLoanMonthInterestTotal(loanPrincipal, rate, 360);
//            double totalBonus = 0.0d;
//            double totalmoney = 0;
//            for (int i = 1; i < totalPeriod; i++) {
//                bonus = parseDouble((origin - monthCost * (i - 1)) * monthRate);
//                totalBonus += parseDouble(bonus);
//                totalmoney += parseDouble(monthCost);
//            }
//            monthCost = parseDouble(origin - totalmoney);
//            bonus = parseDouble(interest.doubleValue() - totalBonus);
//            loanHouse.setPaybackPrincipal(new BigDecimal(parseDouble(totalmoney) + ""));
//        } else {
//            // 计算当前期数的利息
//            bonus = parseDouble((origin - monthCost * (currentPeriod - 1)) * monthRate);
//            loanHouse.setPaybackPrincipal(new BigDecimal(parseDouble(monthCost * (currentPeriod - 1)) + ""));
//        }
//        loanHouse.setPrincipal(new BigDecimal(monthCost + ""));
//        loanHouse.setInterest(new BigDecimal(bonus + ""));
//        loanHouse.setAmount(new BigDecimal(parseDouble(monthCost + bonus) + ""));
//        System.out.println(JSON.toJSONString(loanHouse));
        
        double origin = loanPrincipal.doubleValue(); // 贷款总本金
        double monthRate = rate.doubleValue() / 12.0d / 100.0d;// 月利息
        double bonus; // 每期利息
        double monthCost = parseDouble(origin / totalPeriod); // 每期代还本金
        BigDecimal interest = getLoanMonthInterestTotal(loanPrincipal, rate, 360);
        double totalBonus = 0.0d;
        double totalmoney = 0;
        for (int i = 1; i <= totalPeriod; i++) {
            Date paybackDate = ToolsUtil.getYearAndMonthYYYYMMDD(startPayDate, i - 1);
            LoanHouseItemHistory history = new LoanHouseItemHistory();
            history.setPaybackDate(paybackDate);
            history.setCurrentPeriod(i);
            history.setTotalPeriod(totalPeriod);
            history.setTitle(formatDate(paybackDate, "yyyy年MM月"));
            if (i < totalPeriod) {
                bonus = parseDouble((origin - monthCost * (i - 1)) * monthRate);
                totalBonus += parseDouble(bonus);
                totalmoney += parseDouble(monthCost);
                history.setPaybackPrincipal(new BigDecimal(parseDouble(totalmoney) + ""));
            } else {
                monthCost = parseDouble(origin - totalmoney);
                bonus = parseDouble(interest.doubleValue() - totalBonus);
                history.setPaybackPrincipal(new BigDecimal(parseDouble(monthCost * (i - 1)) + ""));
            }
            history.setPrincipal(new BigDecimal(monthCost + ""));
            history.setInterest(new BigDecimal(bonus + ""));
            history.setAmount(new BigDecimal(parseDouble(monthCost + bonus) + ""));
            System.out.println(JSON.toJSONString(history));
        }
    }
    
    
    private static void test() {
        BigDecimal money = new BigDecimal(1000000);
        BigDecimal interest = null;
        double loft = 0.0f;
        int month = 360;
        BigDecimal rate = new BigDecimal(0.049);
        BigDecimal mm = new BigDecimal(0);
        for (int i = 1; i <= month; i++) {
            interest = getLoanInterest1(money, mm, rate, month);
            mm = new BigDecimal(money.doubleValue() - money.doubleValue() / (month * 1.0f) * i);
            loft += interest.doubleValue();
        }
        System.out.println(loft);
    }

    public static BigDecimal getLoanInterest1(BigDecimal money, BigDecimal payed, BigDecimal rate, int month) {
        BigDecimal monthRate = new BigDecimal(rate.doubleValue() / 100.0f / 12.0f);
        double monthlyInterest = money.doubleValue() / month + payed.doubleValue() * monthRate.doubleValue();
        return new BigDecimal(monthlyInterest);
    }

    private static void test1() {
        BigDecimal origin = new BigDecimal(1000000);
        BigDecimal months = new BigDecimal(360);
        BigDecimal rate = new BigDecimal(0.049);
        BigDecimal perMonth = origin.divide(months, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal monthRate = rate.divide(new BigDecimal(12), 6, BigDecimal.ROUND_HALF_UP);
        System.out.println("每月应还本金：" + perMonth);
        System.out.println("当前月利率：" + monthRate);
        BigDecimal all = new BigDecimal(0);
        for (int i = 0; i < 360; i++) {
            BigDecimal remainOrigin = perMonth.multiply(new BigDecimal(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal perInterest = origin.subtract(remainOrigin).multiply(monthRate).setScale(2,
                    BigDecimal.ROUND_HALF_UP);
            BigDecimal payback = perMonth.add(perInterest).setScale(2, BigDecimal.ROUND_HALF_UP);
            all = all.add(payback).setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("第" + i + " 个月应还金额: " + payback);
        }
        System.out.println("总还款金额：" + all);
    }

    private static void test2() {

        BigDecimal mm = new BigDecimal("1000000");
        BigDecimal rate = new BigDecimal("4.9");
        double month = 360;
        BigDecimal interest = getLoanMonthPayTotal(mm, rate, 360);
        System.out.println("利息： " + interest);
        double base = 0.0d;
        double bonus;
        double monthlymoney = 0.0d;
        java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.00");
        double totalBonus = 0.0d;
        double monthCost = parseDouble(mm.doubleValue() / month);
        double totalmoney = 0;
        for (int i = 1; i <= month; i++) {
            if (i < month) {
                base = monthCost;
                bonus = parseDouble((mm.doubleValue() - monthCost * (i - 1)) * rate.doubleValue() / 12.0d / 100.0d);
                totalBonus += parseDouble(bonus);
                totalmoney += parseDouble(monthCost);
            } else {
                base = parseDouble(mm.doubleValue() - totalmoney);
                bonus = parseDouble(interest.doubleValue() - mm.doubleValue() - totalBonus);
            }
            System.out.println("第" + i + " 个月应还本金: " + base);
            System.out.println("第" + i + " 个月应还利息: " + bonus);
            System.out.println("第" + i + " 个月应还金额: " + parseDouble(base + bonus));
        }
    }

    public static BigDecimal getLoanMonthPayTotal(BigDecimal money, BigDecimal rate, int month) {
        BigDecimal mm = money;
        BigDecimal interest = null;
        double loft = 0.0f;
        for (int i = 1; i <= month; i++) {
            interest = getLoanInterest1(money, mm, rate, month);
            mm = new BigDecimal(money.doubleValue() - money.doubleValue() / (month * 1.0f) * i);
            loft += interest.doubleValue();
        }
        return new BigDecimal(loft);
    }

    public static double parseDouble(double input) {
        double ff = (double) (Math.round(input * 100)) / 100;
        return ff;
    }

    public static String getYearAndMonthYYYYMMDD(Date dt, int during) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        if (during > 0) {
            rightNow.add(Calendar.MONTH, during);
        }
        return sdf.format(rightNow.getTime());
    }
    
    public static BigDecimal getLoanMonthInterestTotal(BigDecimal money, BigDecimal rate, int month) {
        BigDecimal mm = money;
        BigDecimal interest = null;
        double loft = 0.0f;
        for (int i = 1; i <= month; i++) {
            interest = getMonthPayInterest(mm, rate, month);
            mm = new BigDecimal(money.doubleValue() - money.doubleValue() / (month * 1.0f) * i);
            loft += interest.doubleValue();
        }
        return new BigDecimal(loft);
    }

    public static BigDecimal getMonthPayInterest(BigDecimal payed, BigDecimal rate, int month) {
        BigDecimal monthRate = new BigDecimal(rate.doubleValue() / 100.0f / 12.0f);
        double monthlyInterest = payed.doubleValue() * monthRate.doubleValue();
        return new BigDecimal(monthlyInterest);
    }
    
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if(date==null) {
            return formatDate;
        }
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
        }
        return formatDate;
    }

}
