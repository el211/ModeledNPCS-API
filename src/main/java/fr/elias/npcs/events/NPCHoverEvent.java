package fr.elias.npcs.events;

import fr.elias.npcs.data.INPCData;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when a player starts or stops hovering an NPC
 * (i.e. aiming their crosshair at it within the configured range).
 *
 * <p>Cancelling a {@link HoverAction#ENTER} event prevents the scale-up,
 * sound, and action-bar hint from being applied for that tick's transition.
 * It does NOT suppress future checks — if the player is still aiming next
 * tick the event will fire again.</p>
 */
public class NPCHoverEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final INPCData npcData;
    private final HoverAction action;
    private boolean cancelled = false;

    public NPCHoverEvent(@NotNull Player player, @NotNull INPCData npcData, @NotNull HoverAction action) {
        this.player  = player;
        this.npcData = npcData;
        this.action  = action;
    }

    /** The player whose crosshair triggered the hover change. */
    @NotNull
    public Player getPlayer() { return player; }

    /** The NPC that was entered or left. */
    @NotNull
    public INPCData getNPCData() { return npcData; }

    /** Whether the player started ({@link HoverAction#ENTER}) or stopped ({@link HoverAction#LEAVE}) hovering. */
    @NotNull
    public HoverAction getAction() { return action; }

    @Override public boolean isCancelled()            { return cancelled; }
    @Override public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    @NotNull @Override public HandlerList getHandlers()          { return HANDLERS; }
    @NotNull public static HandlerList getHandlerList()          { return HANDLERS; }

    /** Whether the player started or stopped hovering the NPC. */
    public enum HoverAction {
        /** Player's crosshair just entered the NPC's hover cone. */
        ENTER,
        /** Player's crosshair just left the NPC's hover cone. */
        LEAVE
    }
}
