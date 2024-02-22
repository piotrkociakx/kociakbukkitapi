package pl.Author.kociakbukkitapi.methods.plugin;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.handler.CommandKittyHandler;

import java.lang.reflect.Field;
import java.util.List;

public class PluginMethods {

    public final boolean enabletabcompleter;
    private final JavaPlugin plugin;
    private CommandMap commandMap;

    public PluginMethods() {
        this.enabletabcompleter = true;
        this.plugin = Main.instance;
    }
    public void registerPermission(String permission) {
        Permission finalpermission = new Permission(permission);
        plugin.getServer().getPluginManager().addPermission(finalpermission);
    }
    public void registerListener(@NotNull  Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
    public getCommand getCommand(String command) {
        return new getCommand(command);
    }
}
