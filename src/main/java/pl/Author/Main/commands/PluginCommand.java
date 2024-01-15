package pl.Author.Main.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.commandHandler.CommandKittyHandler;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.guicreator.guiCreator;
import pl.Author.kociakbukkitapi.helpers.ChatHelper;

public class PluginCommand implements CommandKittyHandler.CommandHandler {

;    @Override
    public void execute(Player player, String[] args, ConfigManager config, JavaPlugin plugin) {
        if(!player.hasPermission(plugin.getName().toLowerCase()+ ".admin")) {
            player.sendMessage(ChatHelper.colored("&cNie masz uprawnien do tej komendy"));
            return;
        }

        Kociak_bukkit_api kociakBukkitApi = new Kociak_bukkit_api();
        guiCreator guiCreator = kociakBukkitApi.getAPI.getGuiCreator;


        Inventory inventory = guiCreator.getGui(player, "&aZazadzanie pluginem", 54);

        inventory.setItem((inventory.getSize() / 2) + 3, kociakBukkitApi.getAPI.itemMetaCreator.createItem(Material.MUSIC_DISC_13, "&7Przeladuj konfiguracje"));
        inventory.setItem((inventory.getSize() / 2) + 5, kociakBukkitApi.getAPI.itemMetaCreator.createItem(Material.NAME_TAG, "&7Przeladuj konfiguracje API"));
        guiCreator.fillEmptySlots(Material.BLACK_STAINED_GLASS_PANE, inventory);
        guiCreator.openGui(player, inventory);

    }
}
