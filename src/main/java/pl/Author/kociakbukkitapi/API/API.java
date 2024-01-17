package pl.Author.kociakbukkitapi.API;

import pl.Author.kociakbukkitapi.config.getConfig;
import pl.Author.kociakbukkitapi.database.getDataBase;
import pl.Author.kociakbukkitapi.guicreator.GuiCreator;
import pl.Author.kociakbukkitapi.itemcreator.ItemMetaCreator;
import pl.Author.kociakbukkitapi.methods.Methods;

public class API {
    // open surce api created by piotrkociakx
    // removing this line is not allowed
    public getConfig getConfigs = new getConfig();
    public Methods getPluginMethods = new Methods();

    public ItemMetaCreator itemMetaCreator = new ItemMetaCreator();

    public GuiCreator getGuiCreator = new GuiCreator();
    public pl.Author.kociakbukkitapi.database.getDataBase getDataBases = new getDataBase();
}