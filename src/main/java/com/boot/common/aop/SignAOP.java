package com.boot.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zhangwenhan
 * @description
 * @date 2018年9月14日 下午2:38:25
 */
@Component
@Aspect
public class SignAOP {

//    @Autowired
//    MobileSession mobileSession;

    private Logger logger = LoggerFactory.getLogger(SignAOP.class);

    //    @Before("execution(public * *.service.**.web.*.*(..))")
//    @Before("execution(public * com.boot.controller..*(..))")
//    @Before("execution(public * *..controller..*(..))")
//    @Before(value = "execution(public * *..controller..*(..)) || execution(public * *..*Controller..*(..))")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("1121111111111111111111111111111111111111111111111111");
        logger.info("Before aspect start");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] objs = joinPoint.getArgs();
        logger.info("" + JSON.toJSONString(objs));

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " +
                joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        logger.info("Before aspect end");
    }

    //    @Around("execution(public * *.service.*.web.*.*(..))")
//    @Around("execution(public * *..controller..*(..))")
    public Object aroundParamValidReturn(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Around aspect start");
        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        request.getHeader("");
        Object[] objs = pjp.getArgs();
        return pjp.proceed();
//        String reqStr = JSON.toJSONString(objs[0]);
//        JSONObject req = JSON.parseObject(reqStr);
//        if (checkSign(req)) {
//            return pjp.proceed();
//        }
//        return "验签失败";
//        return ResponseData.fail("验签失败", null);
    }
//    @After("execution(public * *..controller..*(..))")
    public void doAfter(JoinPoint joinPoint){
        logger.info("After aspect end, args:{}");
    }

//    @AfterReturning(pointcut="execution(public * *..controller..*(..))")
    public void afterReturn(){
        logger.info("AfterReturning aspect end, res:{}");
    }

//    @AfterThrowing(pointcut="execution(public * *..controller..*(..))",throwing="error")
    public void afterThrowing(Throwable error){
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    private boolean checkSign(JSONObject req) {
        try {
//            String sign = req.getString("sign");
            // 测试阶段跳过验签先
//            if (StringUtils.isNotBlank(sign)) {
//                return true;
//            }
//            if (StringUtils.isBlank(sign)) {
//                return false;
//            }
//            Long uid = 0L;
//            SessionInfo sessionInfo = (SessionInfo) mobileSession.getAttribute(MobileConfig.SESSION_USR_INFO);
//            if (sessionInfo != null) {
//                uid = sessionInfo.getUserId();
//            }
//            String reqTime = req.getString("reqTime");
//            String data = req.getString("data");
//            String signStr = ToolsUtil.getMD5(data + reqTime + uid);
//            if (sign.equals(signStr)) {
//                return true;
//            }
            return true;
        } catch (Exception e) {
            logger.error("验签异常", e);
            return false;
        }

    }
}
