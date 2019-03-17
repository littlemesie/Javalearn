package cn.mesie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 2019-03-17 20:06
 * 自定义简单的@interface
 * @author: mesie
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityCheck {

    boolean open() default false;

    boolean justLimitFailure() default false;

    String rule() default "";

}


