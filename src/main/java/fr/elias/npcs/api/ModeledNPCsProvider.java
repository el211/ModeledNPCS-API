package fr.elias.npcs.api;

/**
 * Provider for backward compatibility with IModeledNPCsAPI
 */
public class ModeledNPCsProvider {

    /**
     * Get API instance (delegates to ModeledNPCsAPI.get())
     */
    public static ModeledNPCsAPI get() {
        return ModeledNPCsAPI.get();
    }
}