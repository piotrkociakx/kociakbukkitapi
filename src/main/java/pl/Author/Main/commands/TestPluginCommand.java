package pl.Author.Main.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.kociakbukkitapi.commandHandler.CommandKittyHandler;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.helpers.ChatHelper;
import pl.Author.kociakbukkitapi.methods.player.apiPlayer;
import pl.Author.kociakbukkitapi.user.User;

public class TestPluginCommand implements CommandKittyHandler.CommandHandler {


    @Override
    public void execute(Player player, User user, String[] args, ConfigManager config, JavaPlugin plugin) {


        if(player.hasPermission(plugin.getName().toLowerCase() + ".admin")) {
            player.sendMessage(ChatHelper.colored("&cNie masz uprawnien do tej komendy"));
            return;
        }
    }
}
