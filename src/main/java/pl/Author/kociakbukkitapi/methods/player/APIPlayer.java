package pl.Author.kociakbukkitapi.methods.player;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;

public class APIPlayer {


    private final Player player;
    Boolean usePlaceholderapi = new Kociak_bukkit_api().usePlaceholderapi;

    public APIPlayer(Player player) {
        this.player = player;
    }


    public void sendmessage (String message){
        String coloredmessage = ChatColor.translateAlternateColorCodes('&', message);

        if (usePlaceholderapi) {
            String finalPlaceholder = PlaceholderAPI.setPlaceholders(player, coloredmessage);
            player.sendMessage(finalPlaceholder);
        }
        player.sendMessage(coloredmessage);
    }
    public void sendTitle (String title, String subtitle){
        String coloredtitle = ChatColor.translateAlternateColorCodes('&', title);
        String coloredsubtitle = ChatColor.translateAlternateColorCodes('&', subtitle);

        if (usePlaceholderapi) {
            String finalPlaceholdertitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            String finalPlaceholdersubtitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            player.sendTitle(finalPlaceholdertitle, finalPlaceholdersubtitle);
        }
        player.sendTitle(coloredtitle, coloredsubtitle);
    }
    public void sendTitle (String title){
        String coloredtitle = ChatColor.translateAlternateColorCodes('&', title);

        if (usePlaceholderapi) {
            String finalPlaceholdertitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            player.sendTitle(finalPlaceholdertitle, null);
        }
        player.sendTitle(coloredtitle, null);
    }

}
