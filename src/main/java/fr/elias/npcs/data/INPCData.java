package fr.elias.npcs.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Represents NPC data
 */
public interface INPCData {

    int getId();

    String getName();

    String getCustomName();

    String getCustomDisplayName();

    Location getLocation();

    String getType();

    List<String> getCommands();

    UUID getEntityUuid();

    boolean isAutoLook();

    boolean hasViewPermission(Player player);
}