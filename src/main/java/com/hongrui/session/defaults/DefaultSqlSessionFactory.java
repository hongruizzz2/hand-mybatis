package com.hongrui.session.defaults;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.session.Configuration;
import com.hongrui.session.SqlSession;
import com.hongrui.session.SqlSessionFactory;

/**
 * @author hongrui
 * @description 会话工厂实现类
 * @date 2024-10-01 21:15
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
