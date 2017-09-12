package com.cachexic.cloud.provider.rocketmq.config;

import com.cachexic.cloud.config.sjdbc.DruidDatasourceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author tangmin
 * @version V1.0
 * @Title: DruidDatasource.java
 * @Package com.cachexic.cloud.provider.config
 * @Description: 每个工程配置自己的数据源
 * @date 2017-09-06 16:08:07
 */
@Component
@Configuration
@Order(2)
public class DruidDatasource {
    @Autowired
    private DruidDatasourceBase druidDatasourceBase;

    @Bean(name = "ds_rocketmq")
    @Primary
    public DataSource ds_rocketmq(
            @Value("${jdbc.datasource.ds_rocketmq.url}") String url,
            @Value("${jdbc.datasource.ds_rocketmq.username}") String username,
            @Value("${jdbc.datasource.ds_rocketmq.password}") String password,
            @Value("${jdbc.datasource.ds_rocketmq.publickey}") String publickey,
            @Value("${jdbc.datasource.ds_rocketmq.filters}") String filters) {
        return druidDatasourceBase.getDruidDataSource(url, username, password, publickey, filters);
    }

}