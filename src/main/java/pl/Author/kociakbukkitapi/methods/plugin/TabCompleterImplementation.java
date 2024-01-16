package pl.Author.kociakbukkitapi.methods.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleterImplementation implements TabCompleter {
    private final List<List<String>> options;
    private final String tabcommand;

    public TabCompleterImplementation(String tabcommand, List<List<String>> options) {
        this.tabcommand = tabcommand;
        this.options = options != null ? options : Collections.emptyList();
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!command.getName().equalsIgnoreCase(tabcommand)) {
            return Collections.emptyList();
        }

        int length = args.length - 1;
        if (length >= 0 && length < options.size()) {
            StringUtil.copyPartialMatches(args[length], options.get(length), completions);
        }

        Collections.sort(completions);

        return completions;
    }
}
