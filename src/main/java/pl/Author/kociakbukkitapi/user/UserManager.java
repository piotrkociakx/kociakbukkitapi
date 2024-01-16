package pl.Author.kociakbukkitapi.user;

import org.bukkit.Bukkit;
import pl.Author.kociakbukkitapi.methods.player.apiPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private final ConcurrentHashMap<UUID, User> users = new ConcurrentHashMap<>();

    public User getOrCreate(UUID uuid){
        if(users.containsKey(uuid)) return users.get(uuid);

        User user = new User(new apiPlayer(Bukkit.getPlayer(uuid)), uuid);
        users.put(uuid, user);

        return user;
    }

    public List<User> getUsers(){
        return new ArrayList<>(users.values());
    }
}
