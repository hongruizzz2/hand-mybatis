package com.hongrui.builder.xml;

import com.hongrui.mapping.BoundSql;
import com.hongrui.mapping.ParameterMapping;
import com.hongrui.mapping.SqlSource;
import com.hongrui.session.Configuration;

import java.util.List;

/**
 * @author hongrui
 * @description 静态SQL源码
 * @date 2024-10-08 1:51
 */
public class StaticSqlSource implements SqlSource {
    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }
}
