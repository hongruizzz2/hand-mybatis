package com.hongrui.executor.resultset;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hongrui
 * @description 结果集处理器
 * @date 2024-10-04 1:17
 */
public interface ResultSetHandler {
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;
}
