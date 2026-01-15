package fr.elias.npcs.data;

import org.bukkit.Location;
import java.util.List;

/**
 * Represents an NPC route for pathfinding.
 */
public interface NPCRouteInterface {

    /**
     * Get all waypoints in this route
     * @return List of locations
     */
    List<Location> getWaypoints();

    /**
     * Add a waypoint to the route
     * @param location The waypoint location
     */
    void addWaypoint(Location location);

    /**
     * Clear all waypoints
     */
    void clearWaypoints();

    /**
     * Get route mode (PATROL or LOOP)
     * @return Route mode
     */
    String getMode();

    /**
     * Set route mode
     * @param mode "PATROL" or "LOOP"
     */
    void setMode(String mode);
}