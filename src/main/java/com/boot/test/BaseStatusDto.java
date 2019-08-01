package com.boot.test;

import com.alibaba.fastjson.JSON;

/**
 * @author zhang.wenhan
 * @description BaseStatusDto
 * @date 2019/7/2 15:31
 */
public class BaseStatusDto {


    /** 档案号 */
    private String code;

    /** 结案时间 */
    private String overTime;

    /** 状态 */
    private String status;

    /** 失败原因  */
    private String errorMessage;

    /** 案件信息 */
    private CaseStatusDto caseInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CaseStatusDto getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(CaseStatusDto caseInfo) {
        this.caseInfo = caseInfo;
    }

    public static void main(String[] args) {
        String s = "{\"status\":\"06\",\"overTime\":\"2019-06-14 18:01:46.0\",\"caseInfo\":{\"reportRegisterNo\":\"ALAE00002019C004186\",\"reportNo\":\"00000016YHA2019A009899\"},\"code\":\"CLM2019Y06M13D0074\"}";
        BaseStatusDto baseStatus = JSON.parseObject(s, BaseStatusDto.class);
        System.out.println(baseStatus.getCaseInfo().getReportNo());
    }
}

class CaseStatusDto {

    /** 立案号 */
    private String reportNo;

    /** 咨询号 */
    private String reportRegisterNo;

    /** 结案金额 */
    private Double completionAmount;

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportRegisterNo() {
        return reportRegisterNo;
    }

    public void setReportRegisterNo(String reportRegisterNo) {
        this.reportRegisterNo = reportRegisterNo;
    }

    public Double getCompletionAmount() {
        return completionAmount;
    }

    public void setCompletionAmount(Double completionAmount) {
        this.completionAmount = completionAmount;
    }

}
