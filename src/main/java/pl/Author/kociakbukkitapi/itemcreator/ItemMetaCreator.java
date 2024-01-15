package pl.Author.kociakbukkitapi.itemcreator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.Author.kociakbukkitapi.helpers.ChatHelper;

import java.util.ArrayList;

public class ItemMetaCreator {
    public ItemStack createItem(Material material, String displayName, String loreText, String loreText2, String loreText3, String loreText4) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) {
            itemMeta = item.getItemMeta();
        }

        itemMeta.setDisplayName(ChatHelper.colored(displayName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatHelper.colored(loreText));
        lore.add(ChatHelper.colored(loreText2));
        lore.add(ChatHelper.colored(loreText3));
        lore.add(ChatHelper.colored(loreText4));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
    public ItemStack createItem(Material material, String displayName, String loreText, String loreText2, String loreText3) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) {
            itemMeta = item.getItemMeta();
        }

        itemMeta.setDisplayName(ChatHelper.colored(displayName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatHelper.colored(loreText));
        lore.add(ChatHelper.colored(loreText2));
        lore.add(ChatHelper.colored(loreText3));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
    public ItemStack createItem(Material material, String displayName, String loreText, String loreText2) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) {
            itemMeta = item.getItemMeta();
        }

        itemMeta.setDisplayName(ChatHelper.colored(displayName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatHelper.colored(loreText));
        lore.add(ChatHelper.colored(loreText2));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
    public ItemStack createItem(Material material, String displayName, String loreText) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) {
            itemMeta = item.getItemMeta();
        }

        itemMeta.setDisplayName(ChatHelper.colored(displayName));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatHelper.colored(loreText));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
    public ItemStack createItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) {
            itemMeta = item.getItemMeta();
        }

        itemMeta.setDisplayName(ChatHelper.colored(displayName));
        item.setItemMeta(itemMeta);
        return item;
    }
    public ItemStack createItem(Material material) {
        return new ItemStack(material);
    }
}
