package com.hongrui.datasource.pooled;


import com.hongrui.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author hongrui
 * @description 有连接池的数据源工厂
 * @date 2024-10-03 21:08
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {
    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }
}
