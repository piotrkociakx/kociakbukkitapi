package pl.Author.kociakbukkitapi;

import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.API.API;
import pl.Author.kociakbukkitapi.config.ConfigApiManager;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;
import pl.Author.kociakbukkitapi.methods.server.getOnlinePlayers;

import static org.bukkit.Bukkit.getServer;

public class Kociak_bukkit_api {

    public boolean usePlaceholderapi;

    public API getAPI = new API();

    public void loadAPI() {
        MemoryManagment.runGarbageCollection();
        Main main = Main.instance;
        Kociak_bukkit_api kociakBukkitApi = new Kociak_bukkit_api();
        ConfigApiManager configApiManager = new ConfigApiManager();
        configApiManager.createApiConifg();
        ConfigManager configManager = new ConfigManager();
        kociakBukkitApi.usePlaceholderapi = configApiManager.getConfig().getBoolean("messages.enable-placeholderapi");
        getServer().getPluginManager().registerEvents(new getOnlinePlayers(), main);
    }

    public void setUsePlaceholderapi(boolean bool) {
        usePlaceholderapi = bool;
    }
}
