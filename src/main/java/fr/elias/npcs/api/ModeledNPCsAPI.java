package fr.elias.npcs.api;

import fr.elias.npcs.data.INPCData;
import fr.elias.npcs.data.INPCEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * ModeledNPCs Public API
 *
 * Complete API for NPC management, AI, pathfinding, escorts,
 * ModelEngine/MythicMobs integration, traders, quests, and dialogs.
 *
 * @version 7.7b
 * @author Elias
 */
public abstract class ModeledNPCsAPI {

    private static ModeledNPCsAPI instance;

    /**
     * Get the singleton API instance
     * @return The global ModeledNPCsAPI instance
     */
    public static ModeledNPCsAPI get() {
        return instance;
    }

    /**
     * Internal: Register implementation (called by plugin)
     */
    protected static void setInstance(ModeledNPCsAPI api) {
        instance = api;
    }

    // ========================================================================
    // BASIC NPC ACCESS
    // ========================================================================

    /**
     * Get NPC data by ID
     * @param id The NPC ID
     * @return NPCData or null if not found
     */
    public abstract INPCData getNPCById(int id); // ✅ Changed from NPCData to INPCData

    /**
     * Get the in-game entity for an NPC
     * @param id The NPC ID
     * @return The Entity or null if not spawned
     */
    public abstract Entity getEntityByNPCId(int id);

    /**
     * Get all registered NPC IDs
     * @return List of all NPC IDs
     */
    public abstract List<Integer> getAllNPCIds();

    /**
     * Get all loaded NPCs
     * @return Map of NPC ID to NPCData
     */
    public abstract Map<Integer, INPCData> getAllNPCs(); // ✅ Changed from NPCData to INPCData

    // ========================================================================
    // DISPLAY NAMES & NAMETAGS
    // ========================================================================

    /**
     * Get NPC display name (priority: customDisplayName > customName > name)
     * @param npcId The NPC ID
     * @return Display name or null
     */
    public abstract String getNPCDisplayName(int npcId);

    /**
     * Get raw display name (may contain color codes like <green>, &a)
     * @param npcId The NPC ID
     * @return Raw display name or null
     */
    public abstract String getNPCDisplayNameRaw(int npcId);

    /**
     * Get formatted display name for a specific player (with PlaceholderAPI)
     * @param viewer The player viewing the name
     * @param npcId The NPC ID
     * @return Formatted display name or null
     */
    public abstract String getNPCDisplayNameFor(Player viewer, int npcId);

    /**
     * Set NPC display name and hologram height
     * @param id The NPC ID
     * @param name The new display name
     * @param height Hologram height offset
     */
    public abstract void setNPCDisplayName(int id, String name, double height);

    /**
     * Hide NPC nametag completely
     * @param npcId The NPC ID
     */
    public abstract void hideNPCNametag(int npcId);

    /**
     * Show NPC nametag with original name
     * @param npcId The NPC ID
     */
    public abstract void showNPCNametag(int npcId);

    /**
     * Check if NPC nametag is hidden
     * @param npcId The NPC ID
     * @return true if hidden, false otherwise
     */
    public abstract boolean isNPCNametagHidden(int npcId);

    /**
     * Reapply custom names and holograms to a specific NPC
     * @param npcId The NPC ID
     */
    public abstract void reapplyNPCName(int npcId);

    /**
     * Reapply custom names and holograms to all NPCs
     */
    public abstract void reapplyAllNPCNames();

    // ========================================================================
    // LOCATION & MOVEMENT
    // ========================================================================

    /**
     * Get NPC location
     * @param npcId The NPC ID
     * @return Location or null if not found
     */
    public abstract Location getNPCLocation(int npcId);

    /**
     * Move NPC to a new location
     * @param npcId The NPC ID
     * @param newLocation The target location
     */
    public abstract void moveNPC(int npcId, Location newLocation);

    // ========================================================================
    // CREATION & DELETION
    // ========================================================================

    /**
     * Create a new NPC
     * @param type "modelengine" or "mythicmobs"
     * @param name The model/mob name
     * @param location Spawn location
     * @return New NPC ID, or -1 if failed
     */
    public abstract int createNPC(String type, String name, Location location);

    /**
     * Delete an NPC completely
     * @param npcId The NPC ID
     */
    public abstract void deleteNPC(int npcId);

    // ========================================================================
    // PERMISSIONS & VISIBILITY
    // ========================================================================

    /**
     * Check if player can view NPC
     * @param npcId The NPC ID
     * @param player The player
     * @return true if player has permission
     */
    public abstract boolean canPlayerViewNPC(int npcId, Player player);

    // ========================================================================
    // COMMANDS
    // ========================================================================

    /**
     * Get NPC commands
     * @param npcId The NPC ID
     * @return List of commands
     */
    public abstract List<String> getNPCCommands(int npcId);

    /**
     * Add command to NPC
     * @param id The NPC ID
     * @param command Command string (e.g., "player: warp spawn")
     */
    public abstract void addCommandToNPC(int id, String command);

    /**
     * Run all NPC commands for a player
     * @param id The NPC ID
     * @param player The player
     */
    public abstract void runNPCCommands(int id, Player player);

    // ========================================================================
    // EFFECTS
    // ========================================================================

    /**
     * Get NPC effects
     * @param npcId The NPC ID
     * @return List of NPCEffect
     */
    public abstract List<INPCEffect> getNPCEffects(int npcId); // ✅ Changed from NPCEffect to INPCEffect

    /**
     * Play interaction effects
     * @param id The NPC ID
     * @param player The player who interacted
     */
    public abstract void playInteractEffects(int id, Player player);

    /**
     * Restart looped effects
     * @param id The NPC ID
     */
    public abstract void restartLoopedEffect(int id);

    // ========================================================================
    // UPDATE & RESPAWN
    // ========================================================================

    /**
     * Update NPC state and visuals
     * @param id The NPC ID
     */
    public abstract void updateNPC(int id);

    /**
     * Respawn NPC
     * @param id The NPC ID
     */
    public abstract void respawnNPC(int id);

    // ========================================================================
    // AUTO-LOOK
    // ========================================================================

    /**
     * Enable auto-look (NPC looks at nearby players)
     * @param id The NPC ID
     */
    public abstract void enableAutoLook(int id);

    /**
     * Disable auto-look
     * @param id The NPC ID
     */
    public abstract void disableAutoLook(int id);

    // ========================================================================
    // AI & PATHFINDING
    // ========================================================================

    /**
     * Add waypoint to NPC route
     * @param npcId The NPC ID
     * @param location Waypoint location
     */
    public abstract void addRouteWaypoint(int npcId, Location location);

    /**
     * Clear all route waypoints
     * @param npcId The NPC ID
     */
    public abstract void clearRoute(int npcId);

    // ========================================================================
    // ESCORT SYSTEM
    // ========================================================================

    /**
     * Start escort for player (uses default route)
     * @param npcId The NPC ID
     * @param player The player to escort
     */
    public abstract void startEscort(int npcId, Player player);

    /**
     * Stop escort for player
     * @param playerId The player UUID
     */
    public abstract void stopEscort(UUID playerId);

    /**
     * Set escort animation for NPC
     * @param npcId The NPC ID
     * @param animationName ModelEngine animation name
     */
    public abstract void setEscortAnimation(int npcId, String animationName);

    /**
     * Get escort animation for NPC
     * @param npcId The NPC ID
     * @return Animation name or null
     */
    public abstract String getEscortAnimation(int npcId);

    // ========================================================================
    // TRADER SYSTEM
    // ========================================================================

    /**
     * Open trader GUI for player
     * @param player The player
     * @param npcId The trader NPC ID
     */
    public abstract void openTraderGUI(Player player, int npcId);

    // ========================================================================
    // QUEST SYSTEM
    // ========================================================================

    /**
     * Assign quest to player
     * @param player The player
     * @param questName Quest name/ID
     */
    public abstract void assignQuest(Player player, String questName);

    // ========================================================================
    // DIALOG SYSTEM
    // ========================================================================

    /**
     * Open dialog for player
     * @param player The player
     * @param npcId The NPC ID
     */
    public abstract void openDialog(Player player, int npcId);

    // ========================================================================
    // GLOWING SYSTEM
    // ========================================================================

    /**
     * Set NPC glow color for a specific player
     * @param npcId The NPC ID
     * @param player The player who will see the glow
     * @param color The glow color (e.g., ChatColor.RED, ChatColor.YELLOW, ChatColor.GREEN)
     */
    public abstract void setNPCGlow(int npcId, Player player, org.bukkit.ChatColor color);

    /**
     * Remove NPC glow for a specific player
     * @param npcId The NPC ID
     * @param player The player
     */
    public abstract void removeNPCGlow(int npcId, Player player);

    /**
     * Set NPC glow color for all online players
     * @param npcId The NPC ID
     * @param color The glow color
     */
    public abstract void setNPCGlowForAll(int npcId, org.bukkit.ChatColor color);

    /**
     * Remove NPC glow for all online players
     * @param npcId The NPC ID
     */
    public abstract void removeNPCGlowForAll(int npcId);

    /**
     * Toggle NPC glow on/off for a specific player
     * @param npcId The NPC ID
     * @param player The player
     * @param enabled Whether to enable or disable glow
     * @param color The glow color (only used if enabled is true)
     */
    public abstract void toggleNPCGlow(int npcId, Player player, boolean enabled, org.bukkit.ChatColor color);
}