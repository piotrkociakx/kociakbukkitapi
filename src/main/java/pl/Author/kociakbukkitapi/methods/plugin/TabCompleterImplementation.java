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
    private final String tabCommand;

    public TabCompleterImplementation(String tabCommand, List<List<String>> options) {
        this.tabCommand = tabCommand;
        this.options = options != null ? options : Collections.emptyList();
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!command.getName().equalsIgnoreCase(tabCommand)) {
            return Collections.emptyList();
        }

        int argsLength = args.length;

        if (argsLength > 0 && argsLength <= options.size()) {
            List<String> currentOptions = options.get(argsLength - 1);
            StringUtil.copyPartialMatches(args[argsLength - 1], currentOptions, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}
