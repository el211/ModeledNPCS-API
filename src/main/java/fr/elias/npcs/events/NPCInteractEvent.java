package fr.elias.npcs.events;

import fr.elias.npcs.data.INPCData;  // ✅ FIXED: Changed from api to data
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Event fired when a player interacts with an NPC.
 * This event is part of the ModeledNPCS API.
 */
public class NPCInteractEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final INPCData npcData;
    private final InteractionType interactionType;
    private boolean cancelled = false;

    /**
     * Creates a new NPCInteractEvent.
     *
     * @param player The player who interacted with the NPC
     * @param npcData The NPC data
     * @param interactionType The type of interaction
     */
    public NPCInteractEvent(@NotNull Player player, @NotNull INPCData npcData, @NotNull InteractionType interactionType) {
        this.player = player;
        this.npcData = npcData;
        this.interactionType = interactionType;
    }

    /**
     * Gets the player who interacted with the NPC.
     *
     * @return The player
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the NPC data.
     *
     * @return The NPC data
     */
    @NotNull
    public INPCData getNPCData() {
        return npcData;
    }

    /**
     * Gets the type of interaction.
     *
     * @return The interaction type
     */
    @NotNull
    public InteractionType getInteractionType() {
        return interactionType;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * The type of interaction with the NPC.
     */
    public enum InteractionType {
        /**
         * Left click interaction
         */
        LEFT_CLICK,

        /**
         * Right click interaction
         */
        RIGHT_CLICK,

        /**
         * Shift + left click interaction
         */
        SHIFT_LEFT_CLICK,

        /**
         * Shift + right click interaction
         */
        SHIFT_RIGHT_CLICK
    }
}