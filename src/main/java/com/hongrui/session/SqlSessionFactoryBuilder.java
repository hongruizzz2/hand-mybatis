package com.hongrui.session;

import com.hongrui.builder.xml.XMLConfigBuilder;
import com.hongrui.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author hongrui
 * @description 整个 Mybatis 的入口，提供建造者工厂，包装 XML 解析处理，并返回对应 SqlSessionFactory 处理类
 * @date 2024-10-01 22:02
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
