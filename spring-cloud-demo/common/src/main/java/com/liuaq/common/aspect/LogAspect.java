package com.liuaq.common.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class LogAspect {

    //@Pointcut("execution(public * com.liuaq.userclient.controller.UserController.getUserById(..)) || @annotation(com.liuaq.userclient.annotation.ControllerLog)")
    @Pointcut("@annotation(com.liuaq.common.annotation.ControllerLog)")
    private void controllerLogPointCut() {}

    @Before("controllerLogPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String params = JSONObject.toJSONString(request.getParameterMap());
        log.info("Request from:{}, target URL:{}, params:{}", request.getRemoteAddr(), request.getRequestURI(), params);
    }

    @Around("controllerLogPointCut()")
    public Object doAround(JoinPoint joinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();
        Long end = System.currentTimeMillis();
        log.info("methodName:{}, cost:{}ms", joinPoint.getSignature().getName(), end - begin);
        Map values = getControllerLog(joinPoint);
        return proceed;
    }

    @AfterReturning(pointcut = "controllerLogPointCut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("this is after");
    }

    @AfterThrowing(value = "controllerLogPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {

        log.error("Error:", e);
    }

    public Map getControllerLog(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class c = Class.forName(targetName);
        Method[] methods = c.getDeclaredMethods();
        Map<String, Object> values = new HashMap<>();
        for (Method method : methods) {
            values.put(method.getName(), method.getAnnotation(c));
        }
        return values;
    }
}
