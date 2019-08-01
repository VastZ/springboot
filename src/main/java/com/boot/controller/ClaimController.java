package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.common.Enum.ClaimBankEnum;
import com.boot.db.dao.CalimMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhang.wenhan
 * @description ClaimController
 * @date 2019/5/17 9:23
 */
@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    CalimMapper calimMapper;

    @GetMapping("/test")
    public String test(@RequestParam("key") String key) {
        List<JSONObject> list = calimMapper.getClaimList(key);
        int count = 0;
        int n = 0;
        for (JSONObject claim : list) {
            String uuid = claim.getString("UUID");
            String claimTypeUuid = claim.getString("claimTypeUuid");
            String orderMainUuid = claim.getString("ordermainuuid");
            String KindOfLoss = calimMapper.getKindOfLoss(claimTypeUuid);
            System.out.println("update claim_main set KindOfLoss = '" + KindOfLoss + "' where uuid = '" + uuid + "';");
            List<JSONObject> personList = calimMapper.getClaimPersonList(uuid);
//            -- 0 = 报案人 1 = 被保人 2 = 索赔人 此处影响人员信息哪些有值
            JSONObject baoan = personList.get(0);
            JSONObject beibao = personList.get(1);
            JSONObject suopei = personList.get(2);
            List<JSONObject> policyList = calimMapper.getHolderInsuranList(orderMainUuid);
            JSONObject holder = policyList.get(0);
            JSONObject insurance = policyList.get(1);
            JSONObject sale = calimMapper.getSaleMan(orderMainUuid);
            if (sale.getString("realname").equals(baoan.getString("personName"))) {
                System.out.println("update claim_person set certType = '" + sale.getString("certType") + "' , CertCode = '" +
                        sale.getString("certCode") + "' where claimmainuuid = '" + uuid + "' and PersonType = '0';");
            } else if (baoan.getString("personName").equals(beibao.getString("personName"))) {
                System.out.println("update claim_person set certType = '" + beibao.getString("certType") + "' , CertCode = '" +
                        beibao.getString("CertCode") + "' where claimmainuuid = '" + uuid + "' and PersonType = '0';");
            } else if (baoan.getString("personName").equals(holder.getString("name"))) {
                System.out.println("update claim_person set certType = '" + holder.getString("certificatesType") + "' , CertCode = '" +
                        holder.getString("certificatesNumber") + "' where claimmainuuid = '" + uuid + "' and PersonType = '0';");
            } else {
                n++;
                System.err.println("没有报案人信息 claimUuid:" + uuid);
            }
            String email = "";

            if (suopei.getString("personName").equals(insurance.getString("name"))) {
                email = insurance.getString("email");
                if (StringUtils.isBlank(email)) {
                    email = holder.getString("email");
                }
            } else if (suopei.getString("personName").equals(holder.getString("name"))) {
                email = holder.getString("email");
            }
            if (StringUtils.isBlank(email)) {
                count++;
                System.err.println("当前索赔订单 claimCode： " + claim.getString("claimCode") + " email为：" + email );
            } else {
                System.out.println("update claim_person set personEmail = '" + email + "' , personPosition = '中国', BankName = '" +
                        ClaimBankEnum.getBankNameByCode(suopei.getString("bankCode")) + "' where claimmainuuid = '" + uuid + "' and PersonType = '2';");
            }

            System.out.println();
        }
        return "完事" + count + "    " + n;

    }

    @GetMapping("/dealMoney")
    public String dealMoney() {
        List<String> uuids = calimMapper.getUuids();
        List<JSONObject> list = calimMapper.getResponse(uuids);
        for(JSONObject obj : list){
            String uuid = obj.getString("claim_main_uuid");
            try{
                JSONObject json = JSON.parseObject(obj.getString("response_xml"));
                JSONObject json1 = JSON.parseObject(json.getString("value"));
                JSONObject json2 = JSON.parseObject(json1.getString("caseInfo"));
                double money =  json2.getDouble("completionAmount");
                System.out.println("update claim_main set payMoney ='" + money + "' where uuid = '" + uuid + "';");
            } catch (Exception e) {
                System.err.println("异常， 当前uuid:" + uuid);
            }
        }

        return "success";
    }

}
