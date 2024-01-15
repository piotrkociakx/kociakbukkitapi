package pl.Author.kociakbukkitapi.database;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import pl.Author.kociakbukkitapi.memory.MemoryManagment;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlDataBase {
    private File dataFile;
    private YamlConfiguration dataConfig;

    public void setupDataFile(File dataFolder, String file) throws IOException {
        File databaseFolder = new File(dataFolder, file);
        if (!databaseFolder.exists()) {
            databaseFolder.mkdirs();
        }

        dataFile = new File(databaseFolder, file);
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }

        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }


    public String getString(@NotNull String Value) {
        return dataConfig.get(Value).toString();
    }
    public int getInt(@NotNull String Value) {
        return dataConfig.getInt(Value);
    }
    public List getList(@NotNull String Value) {
        return dataConfig.getList(Value);
    }
    public void setList(@NotNull String path, List list) {
        dataConfig.set(path, list);
    }
    public Boolean ValueExist(@NotNull String Value) {
        return dataConfig.get(Value) == null;
    }
    public void setValue(String existingvaluepath, String newValue) {
        dataConfig.set(existingvaluepath, newValue);
    }



    public void saveDataFile() throws IOException {
        MemoryManagment.removefromMemory(dataConfig);
        dataConfig.save(dataFile);
    }
    public void refreshData() throws IOException, InvalidConfigurationException {
        MemoryManagment.removefromMemory(dataConfig);
        dataConfig.load(dataFile);
    }
}
