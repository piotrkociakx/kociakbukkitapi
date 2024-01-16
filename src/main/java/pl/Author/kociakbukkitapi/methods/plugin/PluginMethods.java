package pl.Author.kociakbukkitapi.methods.plugin;

import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.commandHandler.CommandKittyHandler;
import pl.Author.kociakbukkitapi.methods.player.apiPlayer;

import java.util.List;

public class PluginMethods {

    public final boolean enabletabcompleter;
    private final Main main;
    private final JavaPlugin plugin;
    private final Kociak_bukkit_api kociakBukkitApi;

    public PluginMethods() {
        this.enabletabcompleter = true;
        this.main = Main.getInstance();
        this.plugin = Main.getInstance();
        this.kociakBukkitApi = new Kociak_bukkit_api();
    }
    public void registerPermission(String permission) {
        Permission finalpermission = new Permission(permission);
        plugin.getServer().getPluginManager().addPermission(finalpermission);
    }
    public void addTabCompleter(String command, List<List<String>> options) {
        plugin.getCommand(command).setTabCompleter(new TabCompleterImplementation(command, options));
    }

    public void registerCommand(String commandName, CommandKittyHandler.CommandHandler commandHandler) {
        PluginCommand command = main.getCommand(commandName);

        if (command != null) {
            command.setExecutor(new CommandKittyHandler(commandHandler, Main.getInstance().configManager, main));
        } else {
            main.getLogger().warning("Plugin '" + main.getName() + "' can't load a command '" + commandName + "', maybe is not registered in plugin.yml?");
        }
    }
    public void registerListener(Listener listener) {
        main.getServer().getPluginManager().registerEvents(listener, main);
    }
}
