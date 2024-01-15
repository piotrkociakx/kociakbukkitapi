package pl.Author.kociakbukkitapi.config;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;

import java.io.File;
import java.io.IOException;

public class ConfigApiManager {
    private final Main plugin;

    @Getter
    private FileConfiguration config;
    private File apiConfigFile;

    public ConfigApiManager() {
        this.plugin = Main.instance;
        loadApiConfig();
    }

    private void loadApiConfig() {
        apiConfigFile = new File(plugin.getDataFolder(), "api-config.yml");
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        if (!apiConfigFile.exists()) {
            try {
                apiConfigFile.getParentFile().mkdirs();
                apiConfigFile.createNewFile();
            } catch (IOException e) {
                System.out.print("Nie udalo sie poprawnie stworzyc pliku konfiguracji api api-config.yml"+"\n\n\n\n\n\n\n\n oto kompletny blad: ");
                e.printStackTrace();
                plugin.getPluginLoader().disablePlugin(plugin);
            }
        }

        config = YamlConfiguration.loadConfiguration(apiConfigFile);
    }
    public void createApiConifg() {
        String folderPluginu = plugin.getDataFolder().getAbsolutePath();

        File folder = new File(folderPluginu);

        File apiConfigFile = new File(folder, "api-config.yml");

        try {
            if (!apiConfigFile.exists()) {
                apiConfigFile.createNewFile();
            }

            if (apiConfigFile.length() > 0) {
                return;
            }

            YamlConfiguration apiConifg = YamlConfiguration.loadConfiguration(apiConfigFile);

            apiConifg.set("database.type", "yaml");
            apiConifg.set("messages.enable-placeholderapi", isPlaceholderapiEnabled());
            apiConifg.set("database.mysql-settings.driver", "com.mysql.cj.jdbc.Driver");
            apiConifg.set("database.mysql-settings.address", "localhost");
            apiConifg.set("database.mysql-settings.port", 3306);
            apiConifg.set("database.mysql-settings.database", "minecraft");
            apiConifg.set("database.mysql-settings.username", "admin");
            apiConifg.set("database.mysql-settings.password", "");
            apiConifg.set("database.yaml-settings.file", "{plugin-folder}/database/database.yml");
            
            apiConifg.save(apiConfigFile);

        } catch (IOException e) {
            System.out.print("Nie udalo sie poprawnie zapisac pliku konfiguracji api api-config.yml"+"\n\n\n\n\n\n\n\n oto kompletny blad: "+e.getMessage());
            plugin.getPluginLoader().disablePlugin(plugin);
            MemoryManagment.removefromMemory(config);
        }
    }
    public boolean isPlaceholderapiEnabled() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }


    public void reloadConfig() {
        MemoryManagment.removefromMemory(config);
        MemoryManagment.removefromMemory(apiConfigFile);
        loadApiConfig();
    }
}
