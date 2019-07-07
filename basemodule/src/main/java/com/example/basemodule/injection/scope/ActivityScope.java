package com.example.basemodule.injection.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 10:55
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
