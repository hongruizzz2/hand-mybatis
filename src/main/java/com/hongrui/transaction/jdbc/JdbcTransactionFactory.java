package com.hongrui.transaction.jdbc;

import com.hongrui.session.TransactionIsolationLevel;
import com.hongrui.transaction.Transaction;
import com.hongrui.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author hongrui
 * @description
 * @date 2024-10-02 22:04
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
