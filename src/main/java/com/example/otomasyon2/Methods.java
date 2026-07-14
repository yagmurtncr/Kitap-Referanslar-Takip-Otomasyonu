
package com.example.otomasyon2;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Methods {

    public static Connection databaseLink;

    public Connection getConnection() {
        // Read DB settings from environment variables so credentials are not hardcoded.
        // Falls back to local development defaults when the variables are not set.
        String databaseName = getenvOrDefault("DB_NAME", "javafx");
        String databaseUser = getenvOrDefault("DB_USER", "root");
        String databasePassword = getenvOrDefault("DB_PASSWORD", "12345");
        String databaseHost = getenvOrDefault("DB_HOST", "localhost");
        String url = "jdbc:mysql://" + databaseHost + "/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }

    private static String getenvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.isBlank()) ? defaultValue : value;
    }

}