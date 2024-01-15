package pl.Author.kociakbukkitapi.methods.player;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;

public class PlayerMethods {

    public static void sendmessage(org.bukkit.entity.Player player, String message) {
        String coloredmessage = ChatColor.translateAlternateColorCodes('&', message);

        if(new Kociak_bukkit_api().usePlaceholderapi) {
            String finalPlaceholder = PlaceholderAPI.setPlaceholders(player, coloredmessage);
            player.sendMessage(finalPlaceholder);
        }
        player.sendMessage(coloredmessage);
    }


}
