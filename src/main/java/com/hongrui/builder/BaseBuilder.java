package com.hongrui.builder;

import com.hongrui.session.Configuration;

/**
 * @author hongrui
 * @description 建造者基类
 * @date 2024-10-01 22:05
 */
public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
