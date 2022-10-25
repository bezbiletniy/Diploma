package ru.netology.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlHelper {

    private static QueryRunner runner = new QueryRunner();
    private SqlHelper() {
    }

    @SneakyThrows
    private static Connection getConnect() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/aqa-shop.jar", "app", "pass");
    }

    @SneakyThrows
    public static String approvedPaymentStatement() {
        var codeSQL = "SELECT ??? FROM ??";
        try (var conn = getConnect()) {
            runner.query(conn, codeSQL, new ScalarHandler<String>());
        }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.execute(connection, "DELETE FROM ???");
        runner.execute(connection, "DELETE FROM ???");
        runner.execute(connection, "DELETE FROM ???");
        runner.execute(connection, "DELETE FROM ???");
    }

}
