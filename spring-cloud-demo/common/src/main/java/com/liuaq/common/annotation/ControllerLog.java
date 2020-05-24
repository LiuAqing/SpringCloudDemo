package com.liuaq.common.annotation;

import java.lang.annotation.*;

/**
 * @author liuaqing
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ControllerLog {

  /*  *//**
     * 请求地址
     * @return
     *//*
    String host() default "";

    *//**
     * 操作人
     * @return
     *//*
    String operator() default "";

    *//**
     * 操作名字
     * @return
     *//*
    String option() default "";*/

    /**
     * 请求方式
     * @return
     */
    String requestMethod();

  /*  *//**
     * 请求地址
     * @return
     *//*
    String requestUrl();

    *//**
     * 请求参数
     * @return
     *//*
    String params();*/
}
