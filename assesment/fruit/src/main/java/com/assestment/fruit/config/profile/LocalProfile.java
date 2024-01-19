package com.assestment.fruit.config.profile;


import com.assestment.fruit.config.properties.AppProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalProfile {
    @Bean(AppProperties.BEAN_APP_CONF)
    public AppProperties loadAppConfig(){
        return new AppProperties();
    }

    @Bean(AppProperties.BEAN_DS_FRUIT)
    public HikariDataSource FruitDatasource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/fruit");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setPoolName("Hikaripool-Fruit");
        return new HikariDataSource(config);
    }
}
