package fr.elias.npcs.api;

import fr.elias.npcs.IModeledNPCsAPI;

/**
 * Provider for backward compatibility with IModeledNPCsAPI
 */
public class ModeledNPCsProvider {

    private static IModeledNPCsAPI instance;

    /**
     * Register API implementation
     * @param api The API implementation
     */
    public static void register(IModeledNPCsAPI api) {
        instance = api;
    }

    /**
     * Unregister API implementation (called on plugin disable)
     */
    public static void unregister() {
        instance = null;
    }

    /**
     * Get API instance (delegates to ModeledNPCsAPI.get())
     * @return ModeledNPCsAPI instance
     */
    public static ModeledNPCsAPI get() {
        return ModeledNPCsAPI.get();
    }

    /**
     * Get simple API instance (backward compatibility)
     * @return IModeledNPCsAPI instance or null if not registered
     */
    public static IModeledNPCsAPI getSimpleAPI() {
        return instance;
    }
}