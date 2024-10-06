package com.hongrui.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author hongrui
 * @description getter调用者
 * @date 2024-10-06 19:40
 */
public class GetFieldInvoker implements Invoker{
    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
