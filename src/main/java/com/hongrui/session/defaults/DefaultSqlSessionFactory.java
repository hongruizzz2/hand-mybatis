package com.hongrui.session.defaults;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.executor.Executor;
import com.hongrui.mapping.Environment;
import com.hongrui.session.Configuration;
import com.hongrui.session.SqlSession;
import com.hongrui.session.SqlSessionFactory;
import com.hongrui.session.TransactionIsolationLevel;
import com.hongrui.transaction.Transaction;
import com.hongrui.transaction.TransactionFactory;

import java.sql.SQLException;

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
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
