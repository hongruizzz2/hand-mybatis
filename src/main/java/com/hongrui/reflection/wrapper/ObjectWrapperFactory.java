package com.hongrui.reflection.wrapper;

import com.hongrui.reflection.MetaObject;

/**
 * @author hongrui
 * @description 对象包装工厂
 * @date 2024-10-06 20:07
 */
public interface ObjectWrapperFactory {
    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
