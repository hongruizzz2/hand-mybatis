package com.hongrui.builder;

import com.hongrui.session.Configuration;
import com.hongrui.type.TypeAliasRegistry;
import com.hongrui.type.TypeHandlerRegistry;

/**
 * @author hongrui
 * @description 建造者基类 - 建造者模式
 * @date 2024-10-01 22:05
 */
public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;


    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }

}
