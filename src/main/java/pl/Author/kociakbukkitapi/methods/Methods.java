package pl.Author.kociakbukkitapi.methods;

import pl.Author.kociakbukkitapi.methods.player.ConvertCordinats;
import pl.Author.kociakbukkitapi.methods.player.PlayerMethods;
import pl.Author.kociakbukkitapi.methods.plugin.PluginMethods;
import pl.Author.kociakbukkitapi.methods.server.getOnlinePlayers;


public class Methods {
    public PlayerMethods getPlayerMessagesMethods = new PlayerMethods();

    public ConvertCordinats convertCordinats = new ConvertCordinats();
    public PluginMethods getPluginMethods = new PluginMethods();

    public pl.Author.kociakbukkitapi.methods.server.getOnlinePlayers getOnlinePlayers = new getOnlinePlayers();
}