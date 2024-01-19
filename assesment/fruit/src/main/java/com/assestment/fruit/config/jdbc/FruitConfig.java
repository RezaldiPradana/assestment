package com.assestment.fruit.config.jdbc;

import com.assestment.fruit.config.properties.AppProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class FruitConfig {
        @Qualifier(AppProperties.BEAN_DS_FRUIT)
        private HikariDataSource dataSource;

        @Bean(AppProperties.BEAN_JDBC_FRUIT)
        public JdbcTemplate jdbcDataBarang(@Qualifier(AppProperties.BEAN_DS_FRUIT) HikariDataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }
}
