package com.example.module1.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/9
 * Time: 14:38
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Module1Scope {
}
