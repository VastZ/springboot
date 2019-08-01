package com.boot.common.Enum;

public enum ClaimBankEnum {
    
    ONE("1","中国工商银行","102100099996"),
    TWO("2","中国建设银行","105100000017"),
    THREE("3","中国农业银行","103100000026"),
    FOUR("4","中国银行","104100000004"),
    FIVE("5","中国交通银行","301290000007"),
    SIX("6","中国招商银行","308584000013"),
    SEVEN("7","北京银行","313100000013"),
    EIGHT("8","北京农商银行","402100000018"),
    NINE("9","中国光大银行","303100000006"),
    A("a","中信银行","302100011000"),
    B("b","中国民生银行","305100000013"),
    C("c","中国邮政储蓄银行","403100000004"),
    D("d","广发银行","306581000003"),
    E("e","兴业银行","309391000011"),
    ;
    /** 银行编码 */
    private String bankCode;
    /** 银行名称 */
    private String bankName;
    /** 安联银行编码 */
    private String anLianCode;
    
    private ClaimBankEnum(String bankCode, String bankName, String anLianCode) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.anLianCode = anLianCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAnLianCode() {
        return anLianCode;
    }
    
    public static String getBankNameByCode(String bankCode){
        ClaimBankEnum[] enums = ClaimBankEnum.values();
        for (ClaimBankEnum bank : enums){
            if (bank.getBankCode().equals(bankCode)){
                return bank.getBankName();
            }
        }
        return "";
    }
    
}
