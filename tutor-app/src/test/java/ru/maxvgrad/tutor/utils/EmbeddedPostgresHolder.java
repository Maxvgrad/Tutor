package ru.maxvgrad.tutor.utils;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class EmbeddedPostgresHolder {

    private static EmbeddedPostgres embeddedPostgres;

    public static int getPort() {
        return embeddedPostgres.getPort();
    }

    public static String generateNewTestDb() {
        int port = new Random().nextInt(50000 - 10000) + 10000;
        return generateNewTestDb(port);
    }

    @SneakyThrows
    public static String generateNewTestDb(int port) {
        initDbIfNeed(port);

        String dbName = String
                .format("crpt_registry_delegation_%d_%d", System.currentTimeMillis(), new Random().nextInt(1000));

        try (Connection conn = embeddedPostgres.getPostgresDatabase().getConnection()) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE DATABASE \"" + dbName + "\"");
        }

        return dbName;
    }

    @SneakyThrows
    private static void initDbIfNeed(int port) {
        if (embeddedPostgres == null) {
            embeddedPostgres = EmbeddedPostgres.builder().setPort(port).start();
        }
    }

}

