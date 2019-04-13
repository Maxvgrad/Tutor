package ru.maxvgrad.tutor.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.maxvgrad.tutor.utils.EmbeddedPostgresHolder;

@Configuration
public class EmbeddedPostgresConfig {

    @Bean
    public javax.sql.DataSource dataSource() {
        String dbName = EmbeddedPostgresHolder.generateNewTestDb();
        return DataSourceBuilder.create()
                                .driverClassName("org.postgresql.Driver")
                                .url("jdbc:postgresql://localhost:" + EmbeddedPostgresHolder.getPort() + "/" + dbName)
                                .username("postgres")
                                .password("password")
                                .build();
    }


}
