package com.hongrui.reflection.invoker;

/**
 * @author hongrui
 * @description 调用者
 * @date 2024-10-06 19:40
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();
}
