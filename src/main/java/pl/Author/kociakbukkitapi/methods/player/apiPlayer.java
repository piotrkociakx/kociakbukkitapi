package pl.Author.kociakbukkitapi.methods.player;

import lombok.Getter;
import lombok.Setter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.user.User;

public class apiPlayer {


    public apiPlayer(Player player) {
        this.player = player;
    }

    public Player player;
    public void sendmessage(String message) {
        String coloredmessage = ChatColor.translateAlternateColorCodes('&', message);

        if(new Kociak_bukkit_api().usePlaceholderapi) {
            String finalPlaceholder = PlaceholderAPI.setPlaceholders(player, coloredmessage);
            player.sendMessage(finalPlaceholder);
        }
        player.sendMessage(coloredmessage);
    }


}
