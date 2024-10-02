package com.hongrui.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hongrui
 * @description 事务接口
 * @date 2024-10-02 21:52
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
