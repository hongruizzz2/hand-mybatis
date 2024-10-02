package com.hongrui.builder;

import com.hongrui.session.Configuration;
import com.hongrui.type.TypeAliasRegistry;

/**
 * @author hongrui
 * @description 建造者基类
 * @date 2024-10-01 22:05
 */
public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
