package pl.Author.kociakbukkitapi.database;


import org.jetbrains.annotations.NotNull;
import pl.Author.kociakbukkitapi.config.ConfigApiManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DataBaseManager {

    public final YamlDataBase yamldb;
    public final MySQLDataBase mysqldb;
    public final Object databasetype;

    public DataBaseManager() {
        databasetype = new ConfigApiManager().getConfig().get("database.type");
        this.yamldb = new YamlDataBase();
        this.mysqldb = new MySQLDataBase();
    }

    public String databasetype() {
        if(databasetype.equals("mysql")) {
            return "mysql";
        } else if (databasetype.equals("yaml")) {
            return "yaml";
        } else {
            return "none";
        }
    }


    public String getString(@NotNull String key, String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            return mysqldb.getString(table, key);
        } else {
            return yamldb.getString(key);
        }
    }
    public int getInt(@NotNull String key, String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            return mysqldb.getInt(table, key);
        } else {
            return yamldb.getInt(key);
        }
    }
    public List getList(@NotNull String key, String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            return mysqldb.getList(table, key);
        } else {
            return yamldb.getList(key);
        }
    }
    public void setList(@NotNull String key, @NotNull List<String> list, String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            mysqldb.setList(table, key, list);
        } else {
            yamldb.setList(key, list);
        }
    }
    public Boolean ValueExists(@NotNull String key, String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            return mysqldb.valueExists(table, key);
        } else {
            return yamldb.ValueExist(key);
        }
    }
    public void setValue(@NotNull String key,@NotNull String value,String table) {
        if(Objects.equals(databasetype(), "mysql")) {
            mysqldb.setValue(table,key,value);
        } else {
            yamldb.setValue(key, value);
        }
    }
    public void setupdatabase(File datafolder, String File) throws IOException {
        if(Objects.equals(databasetype(), "mysql")) {
            mysqldb.setupDatabaseConnection();
        } else {
            yamldb.setupDataFile(datafolder, File);
        }
    }
    public void closeDataBase() throws IOException {
        if(Objects.equals(databasetype(), "mysql")) {
            mysqldb.closeConnection();
        } else {
            yamldb.saveDataFile();
        }
    }

}
