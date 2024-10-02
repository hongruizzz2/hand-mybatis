package com.hongrui.datasource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author hongrui
 * @description 数据源工厂
 * @date 2024-10-02 22:27
 */
public interface  DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
