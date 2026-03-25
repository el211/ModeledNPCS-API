package fr.elias.npcs.events;

import fr.elias.npcs.data.INPCData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when an NPC's active state changes via
 * {@code ModeledNPCsAPI#setNPCState(int, String)} or the
 * {@code /mnpc state} command.
 *
 * <p>Cancelling the event prevents the new state (animation + hologram
 * suffix) from being applied.</p>
 */
public class NPCStateChangeEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final INPCData npcData;
    private final String previousState;
    private final String newState;
    private boolean cancelled = false;

    public NPCStateChangeEvent(@NotNull INPCData npcData,
                               @Nullable String previousState,
                               @NotNull String newState) {
        this.npcData       = npcData;
        this.previousState = previousState != null ? previousState : "default";
        this.newState      = newState;
    }

    /** The NPC whose state is changing. */
    @NotNull
    public INPCData getNPCData() { return npcData; }

    /** The state the NPC was in before this event. */
    @NotNull
    public String getPreviousState() { return previousState; }

    /** The state the NPC will switch to (if not cancelled). */
    @NotNull
    public String getNewState() { return newState; }

    @Override public boolean isCancelled()             { return cancelled; }
    @Override public void setCancelled(boolean cancel)  { this.cancelled = cancel; }

    @NotNull @Override public HandlerList getHandlers()         { return HANDLERS; }
    @NotNull public static HandlerList getHandlerList()         { return HANDLERS; }
}
