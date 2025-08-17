package com.procedural_structures;

import com.procedural_structures.config.StructureConfig;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class StructureCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            registerCommands(dispatcher);
        });
    }

    private static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("generatestructure")
            .executes(StructureCommand::executeCommand));
            
        dispatcher.register(CommandManager.literal("structureconfig")
            .executes(StructureCommand::showConfig));
            
        dispatcher.register(CommandManager.literal("structuretheme")
            .executes(StructureCommand::nextTheme));
            
        // New configuration commands
        dispatcher.register(CommandManager.literal("structurescale")
            .then(CommandManager.argument("min", IntegerArgumentType.integer(3, 50))
                .then(CommandManager.argument("max", IntegerArgumentType.integer(3, 50))
                    .executes(StructureCommand::setScaleRange)))
            .executes(StructureCommand::showScale));
            
        dispatcher.register(CommandManager.literal("structuredecorations")
            .executes(StructureCommand::toggleDecorations));
            
        dispatcher.register(CommandManager.literal("structurelighting")
            .executes(StructureCommand::toggleLighting));
            
        dispatcher.register(CommandManager.literal("structureplants")
            .executes(StructureCommand::togglePlants));
            
        dispatcher.register(CommandManager.literal("structurefloatingislands")
            .executes(StructureCommand::toggleFloatingIslands));
    }

    private static int executeCommand(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            player.sendMessage(Text.literal("§6Generating structure with theme: §e" + 
                StructureConfig.getCurrentTheme().getDisplayName()), false);
            StructureGenerator.generateRandomStructure(player.getWorld(), player.getBlockPos(), player);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int showConfig(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            player.sendMessage(Text.literal("§6Procedural Structures Configuration"), false);
            player.sendMessage(Text.literal("§ePress §fH §ekey to open the configuration menu"), false);
            player.sendMessage(Text.literal("§7Or customize keybindings in Controls > Key Binds > Procedural Structures"), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int nextTheme(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            StructureConfig.nextTheme();
            player.sendMessage(Text.literal("§6Structure Theme changed to: §e" + 
                StructureConfig.getCurrentTheme().getDisplayName()), false);
            player.sendMessage(Text.literal("§7" + StructureConfig.getCurrentTheme().getDescription()), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    // New configuration command implementations
    private static int setScaleRange(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            int minScale = IntegerArgumentType.getInteger(context, "min");
            int maxScale = IntegerArgumentType.getInteger(context, "max");
            
            if (minScale >= maxScale) {
                player.sendMessage(Text.literal("§cError: Minimum scale must be less than maximum scale!"), false);
                return 0;
            }
            
            StructureConfig.setMinScale(minScale);
            StructureConfig.setMaxScale(maxScale);
            player.sendMessage(Text.literal("§6Scale range updated to: §e" + minScale + "-" + maxScale), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int showScale(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            player.sendMessage(Text.literal("§6Current Scale Range: §e" + 
                StructureConfig.getMinScale() + "-" + StructureConfig.getMaxScale()), false);
            player.sendMessage(Text.literal("§7Usage: /structurescale <min> <max> (range: 3-50)"), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int toggleDecorations(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            boolean newState = !StructureConfig.isDecorationsEnabled();
            StructureConfig.setDecorationsEnabled(newState);
            player.sendMessage(Text.literal("§6Decorations " + (newState ? "§aENABLED" : "§cDISABLED")), false);
            player.sendMessage(Text.literal("§7Glass canopies and waterfall effects: " + (newState ? "ON" : "OFF")), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int toggleLighting(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            boolean newState = !StructureConfig.isLightingEnabled();
            StructureConfig.setLightingEnabled(newState);
            player.sendMessage(Text.literal("§6Lighting " + (newState ? "§aENABLED" : "§cDISABLED")), false);
            player.sendMessage(Text.literal("§7Lanterns and light sources: " + (newState ? "ON" : "OFF")), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int togglePlants(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            boolean newState = !StructureConfig.isPlantsEnabled();
            StructureConfig.setPlantsEnabled(newState);
            player.sendMessage(Text.literal("§6Plants " + (newState ? "§aENABLED" : "§cDISABLED")), false);
            player.sendMessage(Text.literal("§7Vegetation and organic elements: " + (newState ? "ON" : "OFF")), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
    
    private static int toggleFloatingIslands(CommandContext<ServerCommandSource> context) {
        var source = context.getSource();
        var player = source.getPlayer();
        
        if (player != null) {
            boolean newState = !StructureConfig.isFloatingIslandsEnabled();
            StructureConfig.setFloatingIslandsEnabled(newState);
            player.sendMessage(Text.literal("§6Floating Islands " + (newState ? "§aENABLED" : "§cDISABLED")), false);
            player.sendMessage(Text.literal("§7Floating island generation: " + (newState ? "ON" : "OFF")), false);
        } else {
            source.sendFeedback(() -> Text.literal("This command can only be used by players"), false);
        }
        
        return 1;
    }
}
