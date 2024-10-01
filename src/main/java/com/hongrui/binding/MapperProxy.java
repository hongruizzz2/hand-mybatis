package com.hongrui.binding;

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

    // 代理接口
    private final Class<T> mapperInterface;
    // 会话工厂
    private Map<String, String> sqlSession = new HashMap<String, String>();

    public MapperProxy(Map<String,String> sqlSession,Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        return "你被代理了" + sqlSession.get(mapperInterface.getName()) + "-" + method.getName();
    }
}
