package ru.netology.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.mode.CreditModel;
import ru.netology.mode.PaymentModel;
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
    public static String getPaymentStatus() {
        var codeSQL = "SELECT ?? FROM ??";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(PaymentModel.class));
            ??;
        }
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var codeSQL = "SELECT ?? FROM ??";
        try (var conn = getConnect()) {
            var result = runner.query(conn, codeSQL, new BeanHandler<>(CreditModel.class));
            ??;
        }
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.execute(connection, "DELETE FROM ??");
        runner.execute(connection, "DELETE FROM ??");
    }
}