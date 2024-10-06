package com.hongrui.executor;

import com.hongrui.mapping.BoundSql;
import com.hongrui.mapping.MappedStatement;
import com.hongrui.transaction.Transaction;
import sun.plugin2.main.server.ResultHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author hongrui
 * @description 执行器
 * @date 2024-10-04 1:04
 */
public interface Executor {
    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
