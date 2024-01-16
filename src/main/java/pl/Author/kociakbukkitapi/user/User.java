package pl.Author.kociakbukkitapi.user;

import lombok.Data;

import java.util.UUID;
@Data
public class User {

    private final pl.Author.kociakbukkitapi.methods.player.apiPlayer apiPlayer;

    private final UUID playerUUID;

    public User(pl.Author.kociakbukkitapi.methods.player.apiPlayer apiPlayer, UUID playerUUID) {
        this.apiPlayer = apiPlayer;
        this.playerUUID = playerUUID;
    }

}
