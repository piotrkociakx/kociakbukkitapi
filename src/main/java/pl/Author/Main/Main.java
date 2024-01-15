package pl.Author.Main;

import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.Main.commands.PluginCommand;
import pl.Author.Main.listeners.PluginGUIListener;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;
import pl.Author.kociakbukkitapi.methods.plugin.PluginMethods;

public class Main extends JavaPlugin {
    public static Main instance;
    public ConfigManager configManager;


    @Override
    public void onEnable() {
        instance = this;
        Kociak_bukkit_api kociakBukkitApi = new Kociak_bukkit_api();
        PluginMethods pluginMethods = new PluginMethods();
        configManager = new ConfigManager();
        kociakBukkitApi.loadAPI();

        // commands
        pluginMethods.registerCommand("KociakAPI", new PluginCommand()); // komenda z nazwa plg
        pluginMethods.registerPermission(getName()+".admin"); // rejstrowanie pluginu


        // listeners
        pluginMethods.registerListener(new PluginGUIListener());

    }


    @Override
    public void onDisable() {
        MemoryManagment.runGarbageCollection();
    }





}
