package ru.alex_life.sql;

import org.postgresql.Driver;
import ru.alex_life.sql.util.ConnectionManager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Видео-курс JDBC 2022
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.08.2022
 */
public class JdbsRunner {

    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class; //подключили драйвер
        String sql = """
                create table if not exists info (
                id serial primary key,
                data text not null 
                );
                """;

        try (var connection = ConnectionManager.open(); //в методе getConnection передаем урл, юзера и пароль
             var statement = connection.createStatement()) {
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.execute(sql);
            System.out.println(executeResult);
        }


    }

}
