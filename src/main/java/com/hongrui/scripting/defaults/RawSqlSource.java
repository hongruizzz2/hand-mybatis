package com.hongrui.scripting.defaults;

import com.hongrui.builder.SqlSourceBuilder;
import com.hongrui.mapping.BoundSql;
import com.hongrui.mapping.SqlSource;
import com.hongrui.scripting.xmltags.DynamicContext;
import com.hongrui.scripting.xmltags.SqlNode;
import com.hongrui.session.Configuration;

import java.util.HashMap;

/**
 * @author hongrui
 * @description 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @date 2024-10-08 1:53
 */
public class RawSqlSource implements SqlSource {
    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }
}
