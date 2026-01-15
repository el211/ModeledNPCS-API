package fr.elias.npcs.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provider for accessing the ModeledNPCs API
 */
public class ModeledNPCsProvider {

    private static IModeledNPCsAPI instance;

    @Nullable
    public static IModeledNPCsAPI get() {
        return instance;
    }

    public static void register(@NotNull IModeledNPCsAPI api) {
        if (instance != null) {
            throw new IllegalStateException("API already registered!");
        }
        instance = api;
    }

    public static void unregister() {
        instance = null;
    }

    public static boolean isLoaded() {
        return instance != null;
    }
}