package com.hongrui.mapping;

/**
 * @author hongrui
 * @description SQL源码
 * @date 2024-10-08 1:54
 */
public interface SqlSource {
    BoundSql getBoundSql(Object parameterObject);
}
