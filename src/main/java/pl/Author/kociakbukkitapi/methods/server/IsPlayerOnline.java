package pl.Author.kociakbukkitapi.methods.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IsPlayerOnline {

    public boolean isPlayerOnline(Player player) {
        return Bukkit.getServer().getOnlinePlayers().contains(player);
    }
}
