package com.dev.planefinder.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PACKAGE})
public @interface EnableRestCallLogs {

//	String nameOfAnnotation();
//	String typeOfAnnotation();
}


