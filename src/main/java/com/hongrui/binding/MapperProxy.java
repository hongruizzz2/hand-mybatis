package com.hongrui.binding;

import com.hongrui.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hongrui
 * @description 映射器代理类
 * @date 2024-10-01 18:08
 */
public class MapperProxy<T> implements InvocationHandler , Serializable {

    private static final Long serialVersionUID = 1L;

    private final Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession,Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        return sqlSession.selectOne(method.getName(), args);
    }
}
