package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    private static final String DB_PROPERTIES_FILE = "src/config/db.properties";

    public static Connection connection() throws SQLException {

            Properties properties = new Properties();
            String url = null;
            String username = null;
            String password = null;

            try (FileInputStream fis = new FileInputStream(DB_PROPERTIES_FILE)) {
                properties.load(fis);
                url = properties.getProperty("db.url");
                username = properties.getProperty("db.username");
                password = properties.getProperty("db.password");
            } catch (IOException e) {
                throw new RuntimeException("Unable to load database configuration", e);
            }

            if (url == null || username == null || password == null) {
                throw new RuntimeException("Database configuration is missing required properties");
            }

            return DriverManager.getConnection(url, username, password);

    }
}
