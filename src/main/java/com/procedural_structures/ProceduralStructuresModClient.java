package com.procedural_structures;

import com.procedural_structures.client.ConfigScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ProceduralStructuresModClient implements ClientModInitializer {

    private static KeyBinding generateStructureKeyBinding;
    private static KeyBinding cycleThemeKeyBinding;
    private static KeyBinding showConfigKeyBinding;

    @Override
    public void onInitializeClient() {
        System.out.println("Procedural Structures client loaded!");
        System.out.println("Use commands: /generatestructure, /structuretheme, /structureconfig");
        System.out.println("Or use keybindings (configurable in Controls settings):");
        
        // Register keybindings
        generateStructureKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.procedural_structures.generate_structure", // Translation key
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_G, // Default key: G
            "category.procedural_structures.general" // Category
        ));

        cycleThemeKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.procedural_structures.cycle_theme", // Translation key
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_T, // Default key: T
            "category.procedural_structures.general" // Category
        ));

        showConfigKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.procedural_structures.show_config", // Translation key
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_H, // Default key: H
            "category.procedural_structures.general" // Category
        ));

        // Register client tick event to handle key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Check if keys were pressed and handle them
            while (generateStructureKeyBinding.wasPressed()) {
                handleGenerateStructureKey(client);
            }
            
            while (cycleThemeKeyBinding.wasPressed()) {
                handleCycleThemeKey(client);
            }
            
            while (showConfigKeyBinding.wasPressed()) {
                handleShowConfigKey(client);
            }
        });
        
        System.out.println("- Generate Structure: G key (configurable)");
        System.out.println("- Cycle Theme: T key (configurable)");
        System.out.println("- Show Config: H key (configurable)");
    }

    private void handleGenerateStructureKey(net.minecraft.client.MinecraftClient client) {
        if (client.player != null && client.getNetworkHandler() != null) {
            // Send command to server
            client.getNetworkHandler().sendChatCommand("generatestructure");
        }
    }

    private void handleCycleThemeKey(net.minecraft.client.MinecraftClient client) {
        if (client.player != null && client.getNetworkHandler() != null) {
            // Send command to server
            client.getNetworkHandler().sendChatCommand("structuretheme");
        }
    }

    private void handleShowConfigKey(net.minecraft.client.MinecraftClient client) {
        if (client.player != null && client.currentScreen == null) {
            // Open the configuration GUI
            client.setScreen(new ConfigScreen(null));
        }
    }
}
