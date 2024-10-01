package com.hongrui.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author hongrui
 * @description 映射器代理工厂
 * @date 2024-10-01 18:08
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String,String> sqlSession) {
        MapperProxy<T> proxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                                         new Class[]{mapperInterface},
                                         proxy);
    }
}
