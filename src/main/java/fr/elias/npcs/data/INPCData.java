package fr.elias.npcs.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Represents NPC data
 */
public interface INPCData {

    // ========================================================================
    // IDENTITY
    // ========================================================================

    int getId();

    String getName();

    String getType();

    // ========================================================================
    // DISPLAY NAMES
    // ========================================================================

    String getCustomName();

    String getCustomDisplayName();

    // ========================================================================
    // LOCATION
    // ========================================================================

    Location getLocation();

    void setLocation(Location location);

    // ========================================================================
    // COMMANDS
    // ========================================================================

    List<String> getCommands();

    void setCommands(List<String> commands);

    void addCommand(String command);

    void removeCommand(String command);

    // ========================================================================
    // ENTITY & UUID
    // ========================================================================

    UUID getEntityUuid();

    void setEntityUuid(UUID entityUuid);

    UUID getInternalUUID();

    void setInternalUUID(UUID internalUUID);

    // ========================================================================
    // VISIBILITY & PERMISSIONS
    // ========================================================================

    String getViewPermission();

    void setViewPermission(String viewPermission);

    boolean hasViewPermission(Player player);

    boolean isHidden();

    // ========================================================================
    // AUTO-LOOK & HOLOGRAM
    // ========================================================================

    boolean isAutoLook();

    void setAutoLook(boolean autoLook);

    double getHologramHeight();

    void setHologramHeight(double hologramHeight);

    // ========================================================================
    // NAMES (SETTERS)
    // ========================================================================

    void setCustomName(String name);

    void setCustomDisplayName(String customDisplayName);

    // ========================================================================
    // ESCORT
    // ========================================================================

    double getEscortSpeed();

    void setEscortSpeed(double speed);

    // ========================================================================
    // ANIMATIONS (ModelEngine)
    // ========================================================================

    String getLoopedAnimation();

    void setLoopedAnimation(String loopedAnimation);

    String getInteractAnimation();

    void setInteractAnimation(String interactAnimation);

    String getEscortAnimation();

    void setEscortAnimation(String escortAnimation);

    int getInteractCooldownSeconds();

    void setInteractCooldownSeconds(int interactCooldownSeconds);

    // ========================================================================
    // MODEL
    // ========================================================================

    String getModelId();

    void setModelId(String modelId);

    // ========================================================================
    // EFFECTS
    // ========================================================================

    List<? extends INPCEffect> getEffects();

    void setEffects(List<? extends INPCEffect> effects);
    // ========================================================================
    // TASKS (Runtime)
    // ========================================================================

    int getLoopedEffectTaskId();

    void setLoopedEffectTaskId(int taskId);
}