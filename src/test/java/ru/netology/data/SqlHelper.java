package ru.netology.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.mode.CreditModel;
import ru.netology.mode.PaymentModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHelper {

    private static QueryRunner runner = new QueryRunner();

    private SqlHelper() {
    }

    @SneakyThrows
    private static Connection getConnect() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/aqa-shop.jar", "app", "pass");
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var codeSQL = "SELECT status FROM payment_entity";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(PaymentModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var codeSQL = "SELECT status FROM credit_request_entity";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(CreditModel.class));
            return result.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.update(connection, "DELETE FROM payment_entity");
        runner.update(connection, "DELETE FROM credit_request_entity");
        runner.update(connection, "DELETE FROM order_entity");
    }
}