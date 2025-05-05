package com.instana.robotshop.shipping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class JpaConfig {
    private static final Logger logger = LoggerFactory.getLogger(JpaConfig.class);

    @Bean
    public DataSource getDataSource() {
        String host = System.getenv("DB_HOST") == null ? "mysql" : System.getenv("DB_HOST");
        String JDBC_URL = String.format(
            "jdbc:mysql://%s/cities?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            host
        );
    
        logger.info("jdbc url {}", JDBC_URL);
    
        return DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url(JDBC_URL)
            .username("shipping")
            .password("secret")
            .build();
    }
    
}
