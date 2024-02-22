package pl.Author.kociakbukkitapi.methods.plugin;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.jetbrains.annotations.NotNull;
import pl.Author.Main.Main;
import pl.Author.kociakbukkitapi.handler.CommandKittyHandler;

import java.lang.reflect.Field;

public class getCommand {
    private final String command;
    private final Main plugin;

    public getCommand(String command) {
        this.command = command;
        this.plugin = Main.instance;
    }

    @SneakyThrows
    public getCommand register(@NotNull CommandKittyHandler.CommandHandler commandHandler) {
        CommandMap commandMap = getCommandMap();
        commandMap.register(command, new CommandKittyHandler(command, commandHandler, Main.instance.configManager, plugin));
        Main.commands.add(command);
        return this;
    }

    public getCommand addAliases(String[] aliases) {
        if (isCommandNotNull()) {
            for (String alias : aliases) {
                plugin.getCommand(command).getAliases().add(alias);
            }
        }
        return this;
    }

    public getCommand setTabCompleter(@NotNull  String[] options) {
        if (isCommandNotNull()) {
            plugin.getCommand(command).setTabCompleter(new TabCompleterImplementation(command, options));
        }
        return this;
    }

    @SneakyThrows
    private CommandMap getCommandMap() {
        final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        bukkitCommandMap.setAccessible(true);
        return (CommandMap) bukkitCommandMap.get(Main.instance.getServer());
    }

    private boolean isCommandNotNull() {
        return plugin.getCommand(command) != null;
    }
}