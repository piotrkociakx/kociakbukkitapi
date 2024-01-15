package pl.Author.kociakbukkitapi.helpers;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChatHelper {

    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNullElse(text, " "));
    }

    public static List<String> colored(final List<String> texts) {
        return texts.stream().map(text -> colored(Objects.requireNonNullElse(text, " "))).collect(Collectors.toList());
    }

    public static String removeColorCodes(String text) {
        if (text == null) {
            return " ";
        }
        return ChatColor.stripColor(text);
    }
}
