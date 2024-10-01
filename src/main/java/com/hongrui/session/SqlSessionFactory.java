package com.hongrui.session;

/**
 * @author hongrui
 * @description 会话工厂接口
 * @date 2024-10-01 21:08
 */
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
