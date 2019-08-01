package com.boot.test;

import java.math.BigDecimal;
import java.util.Date;

public class LoanHouseHistoryVO {
    /** */
    private Long id;

    /** */
    private Long loanHouseItemDetailId;

    /** */
    private String title;

    /** 账单总额*/
    private BigDecimal amount;

    /** 本金*/
    private BigDecimal principal;

    /** 利息*/
    private BigDecimal interest;
    
    /** 已还本金*/
    private BigDecimal paybackPrincipal;

    /** 当前期数*/
    private Integer currentPeriod;

    /** 总期数*/
    private Integer totalPeriod;

    /** 还款日*/
    private Date paybackDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanHouseItemDetailId() {
        return loanHouseItemDetailId;
    }

    public void setLoanHouseItemDetailId(Long loanHouseItemDetailId) {
        this.loanHouseItemDetailId = loanHouseItemDetailId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Integer getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(Integer totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public Date getPaybackDate() {
        return paybackDate;
    }

    public void setPaybackDate(Date paybackDate) {
        this.paybackDate = paybackDate;
    }

    public BigDecimal getPaybackPrincipal() {
        return paybackPrincipal;
    }

    public void setPaybackPrincipal(BigDecimal paybackPrincipal) {
        this.paybackPrincipal = paybackPrincipal;
    }
}