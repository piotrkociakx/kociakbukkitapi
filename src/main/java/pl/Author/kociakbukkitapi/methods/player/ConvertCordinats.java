package pl.Author.kociakbukkitapi.methods.player;

import org.bukkit.Location;
import org.bukkit.World;

public class ConvertCordinats {

    public static Location CordinatsConverter(String string, World world) {
        String[] coordinatesAsString = string.split(",\\s*");
        double x = Double.parseDouble(coordinatesAsString[0]);
        double y = Double.parseDouble(coordinatesAsString[1]);
        double z = Double.parseDouble(coordinatesAsString[2]);
        return new Location(world, x, y, z);
    }
}
