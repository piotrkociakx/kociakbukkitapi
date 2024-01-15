package pl.Author.kociakbukkitapi.commandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.Author.kociakbukkitapi.config.ConfigManager;

public class CommandKittyHandler implements CommandExecutor {

    private final CommandHandler kociakCommandHandler;
    private final ConfigManager configManager;
    private final JavaPlugin javaPlugin;

    public CommandKittyHandler(CommandHandler handler, ConfigManager configManager, JavaPlugin javaPlugin) {
        this.kociakCommandHandler = handler;
        this.configManager = configManager;
        this.javaPlugin = javaPlugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta komenda wymaga bycia graczem!");
            return false;
        }

        Player player = (Player) sender;


        try {
            kociakCommandHandler.execute(player, args, configManager, javaPlugin);
        } catch (Exception e) {
            System.out.print("Nie mozna wywolac komendy "+command.getName());
        }

        return true;
    }


    public interface CommandHandler {
        void execute(Player player, String[] args, ConfigManager configManager, JavaPlugin javaPlugin);
    }
}
