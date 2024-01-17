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
<<<<<<< Updated upstream
        this.main = Main.instance;
        this.plugin = Main.instance;
=======
        this.plugin = Main.getInstance();
>>>>>>> Stashed changes
    }
    public void registerPermission(String permission) {
        Permission finalpermission = new Permission(permission);
        plugin.getServer().getPluginManager().addPermission(finalpermission);
    }
    public void addTabCompleter(String command, List<String> option1, List<String> option2, List<String> option3, List<String> option4, List<String> option5) {
        plugin.getCommand(command).setTabCompleter(new TabCompleterImplementation(command, option1, option2, option3, option4, option5));
    }
    public void registerCommand(String commandName, CommandKittyHandler.CommandHandler commandHandler) {
<<<<<<< Updated upstream
        PluginCommand command = main.getCommand(commandName);
        if (command != null) {
            command.setExecutor(new CommandKittyHandler(commandHandler, Main.instance.configManager, main));
=======
        PluginCommand command = plugin.getCommand(commandName);

        if (command != null) {
            command.setExecutor(new CommandKittyHandler(commandHandler, Main.getInstance().configManager, plugin));
>>>>>>> Stashed changes
        } else {
            plugin.getLogger().warning("Plugin '" + plugin.getName() + "' can't load a command '" + commandName + "', maybe is not registered in plugin.yml?");
        }
    }
    public void registerListener(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
