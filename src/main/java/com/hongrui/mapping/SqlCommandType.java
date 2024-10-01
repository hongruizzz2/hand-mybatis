package com.hongrui.mapping;

/**
 * @author hongrui
 * @description SQL 指令类型
 * @date 2024-10-01 22:09
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,

    /**
     * 插入
     */
    INSERT,

    /**
     * 更新
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 查找
     */
    SELECT;
}
