package pl.Author.kociakbukkitapi.methods.player;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;

public class PlayerMethods {

<<<<<<< Updated upstream:src/main/java/pl/Author/kociakbukkitapi/methods/player/PlayerMethods.java
    public static void sendmessage(org.bukkit.entity.Player player, String message) {
=======

    Boolean usePlaceholderapi = new Kociak_bukkit_api().usePlaceholderapi;


    public apiPlayer(Player player) {
        this.player = player;
    }

    public Player player;
    public void sendmessage(String message) {
>>>>>>> Stashed changes:src/main/java/pl/Author/kociakbukkitapi/methods/player/apiPlayer.java
        String coloredmessage = ChatColor.translateAlternateColorCodes('&', message);

        if(usePlaceholderapi) {
            String finalPlaceholder = PlaceholderAPI.setPlaceholders(player, coloredmessage);
            player.sendMessage(finalPlaceholder);
        }
        player.sendMessage(coloredmessage);
    }
    public void sendTitle(String title, String subtitle) {
        String coloredtitle = ChatColor.translateAlternateColorCodes('&', title);
        String coloredsubtitle = ChatColor.translateAlternateColorCodes('&', subtitle);

        if(usePlaceholderapi) {
            String finalPlaceholdertitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            String finalPlaceholdersubtitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            player.sendTitle(finalPlaceholdertitle,finalPlaceholdersubtitle);
        }
        player.sendTitle(coloredtitle, coloredsubtitle);
    }
    public void sendTitle(String title) {
        String coloredtitle = ChatColor.translateAlternateColorCodes('&', title);

        if(usePlaceholderapi) {
            String finalPlaceholdertitle = PlaceholderAPI.setPlaceholders(player, coloredtitle);
            player.sendTitle(finalPlaceholdertitle, null);
        }
        player.sendTitle(coloredtitle, null);
    }


}
