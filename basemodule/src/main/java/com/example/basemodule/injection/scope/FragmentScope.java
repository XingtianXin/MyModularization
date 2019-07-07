package com.example.basemodule.injection.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 11:15
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScope {
}
