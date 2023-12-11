package io.github.water1207.dashsdk.demos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.env.Environment;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class DaShSDK {

    private JdbcTemplate jdbcTemplate;
    private List<String> sharedTables;

    public DaShSDK(Environment env) {
        // 数据库配置
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));

        this.jdbcTemplate = new JdbcTemplate(dataSource);

        // 加载要共享的数据表名
        String tables = env.getProperty("shared.tables");
        this.sharedTables = Arrays.asList(tables.split(","));
    }

    public List<?> fetchData(String tableName) {
        if (!sharedTables.contains(tableName)) {
            throw new IllegalArgumentException("Table not configured for sharing: " + tableName);
        }

        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }
}
