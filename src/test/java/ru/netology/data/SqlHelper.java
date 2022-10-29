package ru.netology.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.mode.CreditModel;
import ru.netology.mode.PaymentModel;

import java.sql.*;

public class SqlHelper {

    private static QueryRunner runner = new QueryRunner();

    private SqlHelper() {
    }

    @SneakyThrows
    private static Connection getConnect() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/aqa-shop.jar", "app", "pass");
    }

    @SneakyThrows
    public static String getPaymentApprovedStatus() {
        var codeSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'APPROVED'";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(PaymentModel.class));
            return result.getStatus();
        }
    }

    @SneakyThrows
    public static String getPaymentDeclinedStatus() {
        var codeSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'DECLINED'";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(PaymentModel.class));
            return result.getStatus();
        }
    }

    @SneakyThrows
    public static String getCreditApprovedStatus() {
        var codeSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = credit_id where status = 'APPROVED'";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        }
    }

    @SneakyThrows
    public static String getCreditDeclinedStatus() {
        var codeSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = credit_id where status = 'DECLINED'";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        }
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.update(connection, "DELETE FROM payment_entity");
        runner.update(connection, "DELETE FROM credit_request_entity");
        runner.update(connection, "DELETE FROM order_entity");
    }
}