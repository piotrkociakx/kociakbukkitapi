package pl.Author.kociakbukkitapi.guicreator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.Author.kociakbukkitapi.config.ConfigManager;
import pl.Author.kociakbukkitapi.helpers.ChatHelper;

import java.util.List;

public class guiCreator {

    private final ConfigManager configManager;

    public guiCreator() {
        this.configManager = new ConfigManager();
    }

    public void createBasicGui(String configPath, Player player) {
        Inventory inventory = getGui(configPath, player);
        addConfigItemsToGui(configPath, inventory);
        fillEmptySlots(configPath, inventory);
        openGui(player, inventory);
    }

    public Inventory getGui(String configPath, Player player) {
        int slots = configManager.getConfig().getInt(configPath + ".options.slots", 9);
        String title = ChatHelper.colored(configManager.getConfig().getString(configPath + ".options.title", "Default Title"));
        return Bukkit.createInventory(player, slots, title);
    }
    public Inventory getGui(Player player, String title, int slots) {
        String finaltitle = ChatHelper.colored(title);
        return Bukkit.createInventory(player, slots, finaltitle);
    }
    public Boolean isguiNameMatches(String configPath, String guiName) {
        String title = ChatHelper.colored(configManager.getConfig().getString(configPath + ".options.title", "Default Title"));
        return title.equals(guiName);
    }

    public void fillEmptySlots(String configPath, Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack currentItem = inventory.getItem(i);
            if (currentItem == null || currentItem.getType() == Material.AIR) {
                Material backgroundMaterial = Material.matchMaterial(configManager.getConfig().getString(configPath + ".options.background", "DIRT"));
                if (backgroundMaterial != null) {
                    ItemStack backgroundItem = new ItemStack(backgroundMaterial);
                    inventory.setItem(i, backgroundItem);
                }
            }
        }
    }
    public void fillEmptySlots(Material material, Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack currentItem = inventory.getItem(i);
            if (currentItem == null || currentItem.getType() == Material.AIR) {
                Material backgroundMaterial = material;
                if (backgroundMaterial != null) {
                    ItemStack backgroundItem = new ItemStack(backgroundMaterial);
                    inventory.setItem(i, backgroundItem);
                }
            }
        }
    }

    public void addItemsToGui(Inventory inventory, ItemStack itemStack, int slot) {
        inventory.setItem(slot, itemStack);
    }

    public void addConfigItemsToGui(String configPath, Inventory inventory) {
        if(configManager.getConfig().getConfigurationSection(configPath + ".slots").getKeys(false) == null) {
            return;
        }
        for (String path : configManager.getConfig().getConfigurationSection(configPath + ".slots").getKeys(false)) {
            Material material = Material.matchMaterial(configManager.getConfig().getString(configPath + ".slots." + path + ".material", "DIRT"));
            if (material == null) {
                continue;
            }
            int count = configManager.getConfig().getInt(configPath + ".slots." + path + ".count", 1);
            boolean enchanted = configManager.getConfig().getBoolean(configPath + ".slots." + path + ".enchanted", false);
            String name = ChatHelper.colored(configManager.getConfig().getString(configPath + ".slots." + path + ".name", "&cNazwa przedmiotu"));
            List<String> lore = ChatHelper.colored(configManager.getConfig().getStringList(configPath + ".slots." + path + ".lore"));
            ItemStack item = new ItemStack(material, count);
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null) {
                itemMeta.setDisplayName(name);
                itemMeta.setLore(lore);
                if (enchanted) {
                    itemMeta.addEnchant(Enchantment.DURABILITY, 10, true);
                }
                item.setItemMeta(itemMeta);
                inventory.addItem(item);
            }
        }
    }
    public void openGui(Player player, Inventory inventory) {
        player.openInventory(inventory);
    }
}
