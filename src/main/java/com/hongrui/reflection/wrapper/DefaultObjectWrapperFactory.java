package com.hongrui.reflection.wrapper;

import com.hongrui.reflection.MetaObject;

/**
 * @author hongrui
 * @description 默认对象包装工厂
 * @date 2024-10-06 20:45
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
