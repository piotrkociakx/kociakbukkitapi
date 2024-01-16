package pl.Author.kociakbukkitapi.database;

import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.config.ConfigApiManager;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MySQLDataBase {
    private final JavaPlugin plugin;
    private final ConfigApiManager configApiManager;

    private Connection connection;
    private Statement statement;

    public MySQLDataBase() {
        this.plugin = Main.getInstance();
        this.configApiManager = new ConfigApiManager();
    }

    private void createTable(String table) {
        try {
            if (statement == null) {
                statement = connection.createStatement();
            }

            String createTableQuery = "CREATE TABLE IF NOT EXISTS "+plugin.getName()+"-"+table+" (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "key_column VARCHAR(255) NOT NULL," +
                    "value_column VARCHAR(255) NOT NULL);";

            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to create tables: " + e.getMessage());
        }
    }


    public void setupDatabaseConnection() {
        try {
            String driver = configApiManager.getConfig().getString("database.mysql-settings.driver");
            String address = configApiManager.getConfig().getString("database.mysql-settings.address");
            int port = configApiManager.getConfig().getInt("database.mysql-settings.port");
            String database = configApiManager.getConfig().getString("database.mysql-settings.database");
            String username = configApiManager.getConfig().getString("database.mysql-settings.username");
            String password = configApiManager.getConfig().getString("database.mysql-settings.password");

            Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + database, username, password);

            if (connection != null) {
                statement = connection.createStatement();
            } else {
                plugin.getLogger().warning("Failed to connect to the MySQL database. Connection is null.");
            }
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to connect to the MySQL database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to close the MySQL database connection: " + e.getMessage());
        }
    }

    public String getString(String table, String key) {
        createTableIfNotExists(table);
        try {
            String query = "SELECT value_column FROM " + plugin.getName()+"-"+table + " WHERE key_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("value_column");
            }
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to retrieve a string value from the MySQL database: " + e.getMessage());
        }

        return null;
    }

    public int getInt(String table, String key) {
        createTableIfNotExists(table);
        try {
            String query = "SELECT value_column FROM " + plugin.getName()+"-"+table + " WHERE key_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("value_column");
            }
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to retrieve an integer value from the MySQL database: " + e.getMessage());
        }

        return 0;
    }

    public List<String> getList(String table, String key) {
        createTableIfNotExists(table);
        try {
            String query = "SELECT value_column FROM " + plugin.getName()+"-"+table + " WHERE key_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String value = resultSet.getString("value_column");
                return Arrays.asList(value.split(","));
            }
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to retrieve a list value from the MySQL database: " + e.getMessage());
        }

        return null;
    }

    public void setList(String table, String key, List<String> list) {
        createTableIfNotExists(table);
        try {
            String value = String.join(",", list);
            String query = "INSERT INTO " + plugin.getName()+"-"+table + " (key_column, value_column) VALUES (?, ?) ON DUPLICATE KEY UPDATE value_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, value);
            preparedStatement.setString(3, value);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to set a list value in the MySQL database: " + e.getMessage());
        }
    }

    public boolean valueExists(String table, String key) {
        createTableIfNotExists(table);
        try {
            String query = "SELECT 1 FROM " + plugin.getName()+"-"+table + " WHERE key_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to check if a value exists in the MySQL database: " + e.getMessage());
        }

        return false;
    }

    public void setValue(String table, String key, String value) {
        createTableIfNotExists(table);
        try {
            String query = "INSERT INTO " + plugin.getName()+"-"+table + " (key_column, value_column) VALUES (?, ?) ON DUPLICATE KEY UPDATE value_column = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, value);
            preparedStatement.setString(3, value);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to set a value in the MySQL database: " + e.getMessage());
        }
    }

    private void createTableIfNotExists(String table) {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + plugin.getName()+"-"+table + " (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "key_column VARCHAR(255) NOT NULL," +
                    "value_column VARCHAR(255) NOT NULL);";

            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            plugin.getLogger().warning("Failed to create table " + plugin.getName()+"-"+table + ": " + e.getMessage());
        }
    }
}
