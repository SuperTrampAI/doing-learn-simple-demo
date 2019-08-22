package com.supertrampai.springbootsimpleexcel.util.ExclUtile;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    //Excel列ID(Excel列排序序号)
    int id();
    //Excel列名
    String[] name();
    //Excel列宽
    int width() default 5000;
}
