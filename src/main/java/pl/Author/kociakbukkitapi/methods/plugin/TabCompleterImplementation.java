package pl.Author.kociakbukkitapi.methods.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleterImplementation implements TabCompleter {
    private final List<String> option1;
    private final List<String> option2;
    private final List<String> option3;
    private final List<String> option4;
    private final List<String> option5;
    private final String tabcommand;

    public TabCompleterImplementation(String tabcommand, List<String> option1, List<String> option2, List<String> option3, List<String> option4, List<String> option5) {
        this.option1 = option1 != null ? option1 : Collections.emptyList();
        this.option2 = option2 != null ? option2 : Collections.emptyList();
        this.option3 = option3 != null ? option3 : Collections.emptyList();
        this.option4 = option4 != null ? option4 : Collections.emptyList();
        this.option5 = option5 != null ? option5 : Collections.emptyList();
        this.tabcommand = tabcommand;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!command.getName().equalsIgnoreCase(tabcommand)) {
            return Collections.emptyList();
        }

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[args.length - 1], option1, completions);
        } else if (args.length == 2) {
            StringUtil.copyPartialMatches(args[args.length - 1], option2, completions);
        } else if (args.length == 3) {
            StringUtil.copyPartialMatches(args[args.length - 1], option3, completions);
        } else if (args.length == 4) {
            StringUtil.copyPartialMatches(args[args.length - 1], option4, completions);
        } else if (args.length == 5) {
            StringUtil.copyPartialMatches(args[args.length - 1], option5, completions);
        }

        Collections.sort(completions);

        return completions;
    }
}
