package fr.elias.npcs;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Main API interface for ModeledNPCs
 */
public interface IModeledNPCsAPI {

    @Nullable
    String getNPCDisplayName(int id);

    @NotNull
    List<Integer> getAllNPCIds();

    @Nullable
    Location getNPCLocation(int id);

    void moveNPC(int id, @NotNull Location location);

    void respawnNPC(int id);

    void deleteNPC(int id);

    void hideNPCNametag(int id);

    void showNPCNametag(int id);

    boolean isNPCNametagHidden(int id);

    void addRouteWaypoint(int id, @NotNull Location location);

    void clearRoute(int id);

    void startEscort(int id, @NotNull Player player);

    void stopEscort(@NotNull UUID playerId);

    void openDialog(@NotNull Player player, int id);

    void assignQuest(@NotNull Player player, @NotNull String questName);
}