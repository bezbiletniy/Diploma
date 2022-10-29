package ru.netology.data;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.mode.CreditModel;
import ru.netology.mode.PaymentModel;

import java.sql.*;

public class SqlHelper {

    private static QueryRunner runner = new QueryRunner();

    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    @SneakyThrows
    public static String getPaymentApprovedStatus() {
        var codeSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'APPROVED'";
        try (Connection connection = getConnection()) {
            var result = runner.query(connection, codeSQL, new BeanHandler<>(PaymentModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static String getPaymentDeclinedStatus() {
        var codeSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'DECLINED'";
        try (Connection connection = getConnection()) {
            var result = runner.query(connection, codeSQL, new BeanHandler<>(PaymentModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }


    @SneakyThrows
    public static String getCreditApprovedStatus() {
        var codeSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = credit_id where status = 'APPROVED'";
        try (Connection connection = getConnection()) {
            var result = runner.query(connection, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static String getCreditDeclinedStatus() {
        var codeSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = credit_id where status = 'DECLINED'";
        try (Connection connection = getConnection()) {
            var result = runner.query(connection, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        val order = "DELETE FROM order_entity";
        val payment = "DELETE FROM payment_entity";
        val creditRequest = "DELETE FROM credit_request_entity";

        try (val connection = getConnection()) {
            runner.update(connection, order);
            runner.update(connection, payment);
            runner.update(connection, creditRequest);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}