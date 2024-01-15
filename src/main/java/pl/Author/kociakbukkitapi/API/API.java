package pl.Author.kociakbukkitapi.API;

import pl.Author.kociakbukkitapi.config.getConfig;
import pl.Author.kociakbukkitapi.database.getDataBase;
import pl.Author.kociakbukkitapi.guicreator.guiCreator;
import pl.Author.kociakbukkitapi.itemcreator.ItemMetaCreator;
import pl.Author.kociakbukkitapi.methods.Methods;

public class API {
    public getConfig getConfigs = new getConfig();
    public Methods getPluginMethods = new Methods();

    public ItemMetaCreator itemMetaCreator = new ItemMetaCreator();

    public pl.Author.kociakbukkitapi.guicreator.guiCreator getGuiCreator = new guiCreator();
    public pl.Author.kociakbukkitapi.database.getDataBase getDataBases = new getDataBase();
}