package com.hongrui.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hongrui
 * @description 类型处理器
 * @date 2024-10-08 2:06
 */
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

}
