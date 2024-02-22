package pl.Author.kociakbukkitapi.methods.player;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APIPlayer {


    private final Player player;
    Boolean usePlaceholderapi = new Kociak_bukkit_api().usePlaceholderapi;

    public APIPlayer(Player player) {
        this.player = player;
    }


    public void sendmessage(String message) {
        String coloredmessage = ChatColor.translateAlternateColorCodes('&', message);
        coloredmessage = replaceHexColors(coloredmessage);
        coloredmessage = replacePlaceholders(coloredmessage);

        if (usePlaceholderapi) {
            String finalPlaceholder = PlaceholderAPI.setPlaceholders(player, coloredmessage);
            player.sendMessage(finalPlaceholder);
        }
        player.sendMessage(coloredmessage);
    }

    private String replaceHexColors(String message) {
        Pattern pattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = pattern.matcher(message);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            String color = matcher.group(1);
            StringBuilder replacement = new StringBuilder("§x");
            for (char c : color.toCharArray()) {
                replacement.append("§").append(c);
            }
            matcher.appendReplacement(buffer, replacement.toString());
        }

        return matcher.appendTail(buffer).toString();
    }
    private String replacePlaceholders(String message) {
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("player", player.getName());
        placeholders.put("ip", player.getAddress().toString());
        placeholders.put("uuid", player.getUniqueId().toString());
        placeholders.put("displayname", player.getDisplayName());
        placeholders.put("world", player.getWorld().getName());
        placeholders.put("health", String.valueOf(player.getHealth()));
        placeholders.put("maxhealth", String.valueOf(player.getMaxHealth()));
        placeholders.put("food", String.valueOf(player.getFoodLevel()));
        placeholders.put("level", String.valueOf(player.getLevel()));
        placeholders.put("exp", String.valueOf(player.getExp()));
        placeholders.put("x", String.valueOf(player.getLocation().getX()));
        placeholders.put("y", String.valueOf(player.getLocation().getY()));
        placeholders.put("z", String.valueOf(player.getLocation().getZ()));

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            message = message.replace("{" + entry.getKey() + "}", entry.getValue());
        }

        return message;
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
