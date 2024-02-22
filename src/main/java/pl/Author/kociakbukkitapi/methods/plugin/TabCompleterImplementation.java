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
    private final String[] options;
    private final String tabCommand;

    public TabCompleterImplementation(String tabCommand, String[] options) {
        this.tabCommand = tabCommand;
        this.options = options != null ? options : new String[0];
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!command.getName().equalsIgnoreCase(tabCommand)) {
            return Collections.emptyList();
        }

        int argsLength = args.length;

        if (argsLength > 0 && argsLength <= options.length) {
            String currentOption = options[argsLength - 1];
            StringUtil.copyPartialMatches(args[argsLength - 1], Collections.singletonList(currentOption), completions);
        }

        Collections.sort(completions);
        return completions;
    }
}