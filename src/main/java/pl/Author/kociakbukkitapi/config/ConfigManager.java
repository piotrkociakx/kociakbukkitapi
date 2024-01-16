package pl.Author.kociakbukkitapi.config;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;

@Getter
public class ConfigManager {

    private FileConfiguration config;

    public ConfigManager() {
        loadConfig();
    }
    public void loadConfig() {
        Main plugin = Main.getInstance();
        try {
            plugin.saveDefaultConfig();
            plugin.reloadConfig();
            config = plugin.getConfig();
        } catch (Exception e) {
            System.out.print("Nie udalo sie poprawnie zaladowac konfiguracji z pliku config.yml"+"\n\n\n\n\n\n\n\n oto blad: ");
            e.printStackTrace();
            plugin.getPluginLoader().disablePlugin(plugin);
        }

    }
    public void reloadConfig() {
        MemoryManagment.removefromMemory(config);
        loadConfig();
    }

}
