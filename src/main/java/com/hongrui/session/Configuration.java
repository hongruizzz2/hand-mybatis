package com.hongrui.session;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.datasource.druid.DruidDataSourceFactory;
import com.hongrui.datasource.pooled.PooledDataSourceFactory;
import com.hongrui.datasource.unpooled.UnpooledDataSourceFactory;
import com.hongrui.executor.Executor;
import com.hongrui.executor.SimpleExecutor;
import com.hongrui.executor.resultset.DefaultResultSetHandler;
import com.hongrui.executor.resultset.ResultSetHandler;
import com.hongrui.executor.statement.PreparedStatementHandler;
import com.hongrui.executor.statement.StatementHandler;
import com.hongrui.mapping.BoundSql;
import com.hongrui.mapping.Environment;
import com.hongrui.mapping.MappedStatement;
import com.hongrui.transaction.Transaction;
import com.hongrui.transaction.jdbc.JdbcTransactionFactory;
import com.hongrui.type.TypeAliasRegistry;
import sun.plugin2.main.server.ResultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongrui
 * @description 配置项
 * @date 2024-10-01 22:07
 */
public class Configuration {

    // 环境
    protected Environment environment;

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }


    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

}
