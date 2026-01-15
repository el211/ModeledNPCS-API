package fr.elias.npcs.data;

/**
 * Represents an NPC effect
 */
public interface INPCEffect {

    /**
     * Get the effect type (e.g., "SPEED", "REGENERATION")
     * @return Effect type name
     */
    String getEffectType();

    /**
     * Get effect duration in ticks
     * @return Duration
     */
    int getDuration();

    /**
     * Get effect amplifier (power level)
     * @return Amplifier
     */
    int getAmplifier();
}