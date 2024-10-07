package com.hongrui.session.defaults;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.executor.Executor;
import com.hongrui.mapping.BoundSql;
import com.hongrui.mapping.Environment;
import com.hongrui.mapping.MappedStatement;
import com.hongrui.session.Configuration;
import com.hongrui.session.SqlSession;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hongrui
 * @description 会话实现类
 * @date 2024-10-01 21:16
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getSqlSource().getBoundSql(parameter));
        return list.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }


}
