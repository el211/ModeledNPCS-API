package fr.elias.npcs.data;

/**
 * Represents an NPC effect
 */
public interface INPCEffect {

    String getType();

    String getData();

    boolean isLooping();
}