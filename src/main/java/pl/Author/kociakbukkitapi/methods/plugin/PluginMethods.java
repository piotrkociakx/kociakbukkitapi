package pl.Author.kociakbukkitapi.methods.plugin;

import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.commandHandler.CommandKittyHandler;

import java.util.List;

public class PluginMethods {

    public final boolean enabletabcompleter;
    private final JavaPlugin plugin;

    public PluginMethods() {
        this.enabletabcompleter = true;
        this.plugin = Main.instance;
    }
    public void registerPermission(String permission) {
        Permission finalpermission = new Permission(permission);
        plugin.getServer().getPluginManager().addPermission(finalpermission);
    }
    public void addTabCompleter(String command, List<List<String>> options) {
        plugin.getCommand(command).setTabCompleter(new TabCompleterImplementation(command, options));
    }

    public void registerCommand(String commandName, CommandKittyHandler.CommandHandler commandHandler) {
        PluginCommand command = plugin.getCommand(commandName);

        if (command != null) {
            command.setExecutor(new CommandKittyHandler(commandHandler, Main.instance.configManager, plugin));
        } else {
            plugin.getLogger().warning("Plugin '" + plugin.getName() + "' can't load a command '" + commandName + "', maybe is not registered in plugin.yml?");
        }
    }
    public void registerListener(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
