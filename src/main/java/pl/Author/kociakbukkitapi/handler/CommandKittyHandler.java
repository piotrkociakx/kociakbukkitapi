package pl.Author.kociakbukkitapi.handler;

import lombok.SneakyThrows;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import pl.Author.kociakbukkitapi.config.ConfigManager;

public class CommandKittyHandler extends BukkitCommand {

    private final CommandHandler kociakCommandHandler;
    private final ConfigManager configManager;
    private final JavaPlugin javaPlugin;

    @SneakyThrows
    public CommandKittyHandler(@NotNull String command, CommandHandler handler, ConfigManager configManager, JavaPlugin javaPlugin) {
        super(command);
        this.kociakCommandHandler = handler;
        this.configManager = configManager;
        this.javaPlugin = javaPlugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Ta komenda wymaga bycia graczem!");
            return false;
        }

        Player player = (Player) commandSender;


        try {
            kociakCommandHandler.execute(player, strings, configManager, javaPlugin);
        } catch (Exception e) {
            System.out.print("Nie mozna wywolac komendy "+e.getMessage());
        }
        return true;
    }


    public interface CommandHandler {
        void execute(Player player, String[] args, ConfigManager configManager, JavaPlugin javaPlugin);
    }
}
