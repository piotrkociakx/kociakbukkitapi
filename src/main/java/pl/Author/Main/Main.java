package pl.Author.Main;

import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.Main.commands.PluginCommand;
import pl.Author.Main.listeners.PluginGUIListener;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;
import pl.Author.kociakbukkitapi.methods.plugin.PluginMethods;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public static Main instance;
    public ConfigManager configManager;
    public static List<String> commands = new ArrayList<>();


    @Override
    public void onEnable() {
        instance = this;
        Kociak_bukkit_api kociakBukkitApi = new Kociak_bukkit_api();
        PluginMethods pluginMethods = new PluginMethods();
        configManager = new ConfigManager();
        kociakBukkitApi.loadAPI();

        // commands
        pluginMethods.registerPermission(getName()+".admin"); // rejstrowanie permisji
        // listeners
        pluginMethods.registerListener(new PluginGUIListener());
        pluginMethods.getCommand(getName()).register(new PluginCommand()).addAliases(new String[]{"kitty"}).setTabCompleter(new String[]{"test1", "test2"});
    }


    @Override
    public void onDisable() {
        MemoryManagment.runGarbageCollection();
    }





}
