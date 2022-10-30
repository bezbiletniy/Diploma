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

    private static Connection getConnect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getPaymentApprovedStatus() {
        var codeSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'APPROVED'";
        try (Connection connection = getConnect()) {
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
        try (Connection connection = getConnect()) {
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
        try (Connection connection = getConnect()) {
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
        try (Connection connection = getConnect()) {
            var result = runner.query(connection, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM order_entity");
    }
}