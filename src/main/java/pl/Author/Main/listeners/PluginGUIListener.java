package pl.Author.Main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import pl.Author.kociakbukkitapi.Kociak_bukkit_api;
import pl.Author.kociakbukkitapi.guicreator.GuiCreator;
import pl.Author.kociakbukkitapi.helpers.ChatHelper;
import pl.Author.kociakbukkitapi.methods.player.APIPlayer;

public class PluginGUIListener implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Kociak_bukkit_api kociakBukkitApi = new Kociak_bukkit_api();
        GuiCreator guiCreator = kociakBukkitApi.getAPI.getGuiCreator;
        Player player = (Player) event.getInventory().getHolder();
        if(player == null) {
            return;
        }
        APIPlayer apiPlayer = new APIPlayer(player);


        if (event.getInventory().getHolder() instanceof Player) {
            Inventory inventory = guiCreator.getGui(player, "&aZazadzanie pluginem", 54);
            if (player.getOpenInventory().getTitle().equalsIgnoreCase(ChatHelper.colored("&aZazadzanie pluginem"))) {
                event.setCancelled(true);
                int slot = event.getSlot();

                if(slot == (inventory.getSize() / 2) + 3) {
                    try {
                        kociakBukkitApi.getAPI.getConfigs.getconfigManager.reloadConfig();
                        apiPlayer.sendmessage("&aPomyslnie przeladowano config");
                    } catch (Exception e) {
                        apiPlayer.sendmessage("Nie udalo sie zaladowac konfiguracji: \n"+e.getMessage());
                        e.printStackTrace();
                    }
                }
                if(slot == (inventory.getSize() / 2) + 5) {
                    try {
                        kociakBukkitApi.getAPI.getConfigs.getconfigApiManager.reloadConfig();
                        apiPlayer.sendmessage("&aPomyslnie przeladowano config api");
                    } catch (Exception e) {
                        apiPlayer.sendmessage("Nie udalo sie zaladowac konfiguracji: \n"+e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
