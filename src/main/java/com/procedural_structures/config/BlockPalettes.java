package com.procedural_structures.config;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.List;

public class BlockPalettes {
    
    public static final List<Block> DEFAULT_PALETTE = List.of(
        // Woods / planks / logs
        Blocks.OAK_PLANKS, Blocks.BIRCH_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.JUNGLE_PLANKS, 
        Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.OAK_LOG, Blocks.SPRUCE_LOG, 
        Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG,
        
        // Stones / building blocks
        Blocks.STONE, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.ANDESITE, 
        Blocks.DIORITE, Blocks.GRANITE, Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS,
        Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, Blocks.BASALT, 
        Blocks.BLACKSTONE, Blocks.POLISHED_ANDESITE,
        
        // Terracotta
        Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, 
        Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, 
        Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, 
        Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, 
        Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA,
        
        // Concretes / glass
        Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.MAGENTA_CONCRETE, 
        Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, 
        Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, 
        Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, 
        Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.RED_CONCRETE, Blocks.BLACK_CONCRETE,
        
        // Decorative
        Blocks.GLOWSTONE, Blocks.SEA_LANTERN, Blocks.LANTERN, Blocks.BOOKSHELF, 
        Blocks.QUARTZ_BLOCK, Blocks.NETHER_BRICKS, Blocks.BRICKS, Blocks.PRISMARINE, 
        Blocks.LAPIS_BLOCK, Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK, Blocks.DIAMOND_BLOCK
    );
    
    public static final List<Block> NETHER_PALETTE = List.of(
        // Nether stones
        Blocks.NETHERRACK, Blocks.NETHER_BRICKS, Blocks.RED_NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
        Blocks.CHISELED_NETHER_BRICKS, Blocks.BASALT, Blocks.POLISHED_BASALT, Blocks.SMOOTH_BASALT,
        Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
        Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE,
        
        // Nether woods
        Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_STEM, Blocks.WARPED_STEM,
        Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_WARPED_STEM,
        
        // Nether decorative
        Blocks.NETHER_QUARTZ_ORE, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, Blocks.QUARTZ_BRICKS,
        Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.NETHER_GOLD_ORE,
        Blocks.ANCIENT_DEBRIS, Blocks.CRYING_OBSIDIAN, Blocks.RESPAWN_ANCHOR,
        
        // Nether special
        Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.SOUL_SOIL, Blocks.BONE_BLOCK,
        Blocks.RED_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.BLACK_TERRACOTTA,
        Blocks.RED_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.BLACK_CONCRETE
    );
    
    public static final List<Block> END_PALETTE = List.of(
        // End stones
        Blocks.END_STONE, Blocks.END_STONE_BRICKS, Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR,
        Blocks.PURPUR_STAIRS, Blocks.PURPUR_SLAB, Blocks.END_ROD, Blocks.CHORUS_PLANT,
        Blocks.CHORUS_FLOWER, Blocks.DRAGON_EGG, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN,
        
        // Purple/magenta theme
        Blocks.PURPLE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.PURPLE_CONCRETE,
        Blocks.MAGENTA_CONCRETE, Blocks.PURPLE_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS,
        Blocks.PURPLE_WOOL, Blocks.MAGENTA_WOOL, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_CONCRETE,
        
        // End decorative
        Blocks.SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX,
        Blocks.BLACK_SHULKER_BOX, Blocks.ENDER_CHEST, Blocks.BEACON
    );
    
    public static final List<Block> OVERWORLD_PALETTE = List.of(
        // Natural stones
        Blocks.STONE, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.ANDESITE, 
        Blocks.DIORITE, Blocks.GRANITE, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE,
        
        // Natural woods
        Blocks.OAK_LOG, Blocks.BIRCH_LOG, Blocks.SPRUCE_LOG, Blocks.JUNGLE_LOG,
        Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG, Blocks.CHERRY_LOG, Blocks.MANGROVE_LOG,
        
        // Natural blocks
        Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.MYCELIUM,
        Blocks.MOSS_BLOCK, Blocks.SAND, Blocks.RED_SAND, Blocks.SANDSTONE, Blocks.RED_SANDSTONE,
        
        // Natural decorative
        Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.JUNGLE_LEAVES,
        Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.CHERRY_LEAVES, Blocks.MANGROVE_LEAVES
    );
    
    // Color-based palettes
    public static final List<Block> RED_PALETTE = List.of(
        Blocks.RED_TERRACOTTA, Blocks.RED_CONCRETE, Blocks.RED_STAINED_GLASS, Blocks.RED_WOOL,
        Blocks.RED_NETHER_BRICKS, Blocks.NETHER_BRICKS, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE,
        Blocks.CUT_RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.REDSTONE_BLOCK,
        Blocks.RED_MUSHROOM_BLOCK, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, Blocks.NETHERRACK,
        Blocks.MAGMA_BLOCK, Blocks.RED_SAND, Blocks.BRICKS, Blocks.RED_GLAZED_TERRACOTTA
    );
    
    public static final List<Block> BLUE_PALETTE = List.of(
        Blocks.BLUE_TERRACOTTA, Blocks.BLUE_CONCRETE, Blocks.BLUE_STAINED_GLASS, Blocks.BLUE_WOOL,
        Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_STAINED_GLASS,
        Blocks.CYAN_TERRACOTTA, Blocks.CYAN_CONCRETE, Blocks.CYAN_STAINED_GLASS,
        Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.PRISMARINE,
        Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE, Blocks.SEA_LANTERN, Blocks.BLUE_ICE,
        Blocks.PACKED_ICE, Blocks.ICE, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA
    );
    
    public static final List<Block> GREEN_PALETTE = List.of(
        Blocks.GREEN_TERRACOTTA, Blocks.GREEN_CONCRETE, Blocks.GREEN_STAINED_GLASS, Blocks.GREEN_WOOL,
        Blocks.LIME_TERRACOTTA, Blocks.LIME_CONCRETE, Blocks.LIME_STAINED_GLASS, Blocks.LIME_WOOL,
        Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.MOSS_BLOCK,
        Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS, Blocks.CACTUS, Blocks.SLIME_BLOCK,
        Blocks.MELON, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK
    );
    
    public static final List<Block> YELLOW_PALETTE = List.of(
        Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_CONCRETE, Blocks.YELLOW_STAINED_GLASS, Blocks.YELLOW_WOOL,
        Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_CONCRETE, Blocks.ORANGE_STAINED_GLASS, Blocks.ORANGE_WOOL,
        Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.RAW_GOLD_BLOCK,
        Blocks.GLOWSTONE, Blocks.HONEY_BLOCK, Blocks.HONEYCOMB_BLOCK, Blocks.HAY_BLOCK,
        Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA,
        Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_SANDSTONE
    );
    
    public static final List<Block> PURPLE_PALETTE = List.of(
        Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_CONCRETE, Blocks.PURPLE_STAINED_GLASS, Blocks.PURPLE_WOOL,
        Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_STAINED_GLASS, Blocks.MAGENTA_WOOL,
        Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR, Blocks.END_STONE, Blocks.END_STONE_BRICKS,
        Blocks.CHORUS_PLANT, Blocks.CHORUS_FLOWER, Blocks.SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX,
        Blocks.MAGENTA_SHULKER_BOX, Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST, Blocks.CRYING_OBSIDIAN
    );
    
    public static final List<Block> ORANGE_PALETTE = List.of(
        Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_CONCRETE, Blocks.ORANGE_STAINED_GLASS, Blocks.ORANGE_WOOL,
        Blocks.RED_TERRACOTTA, Blocks.RED_CONCRETE, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_CONCRETE,
        Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER, Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER,
        Blocks.PUMPKIN, Blocks.CARVED_PUMPKIN, Blocks.JACK_O_LANTERN, Blocks.ORANGE_GLAZED_TERRACOTTA,
        Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.TERRACOTTA
    );
    
    public static final List<Block> BLACK_PALETTE = List.of(
        Blocks.BLACK_TERRACOTTA, Blocks.BLACK_CONCRETE, Blocks.BLACK_STAINED_GLASS, Blocks.BLACK_WOOL,
        Blocks.GRAY_TERRACOTTA, Blocks.GRAY_CONCRETE, Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE,
        Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.COAL_BLOCK, Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE,
        Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.BASALT, Blocks.POLISHED_BASALT,
        Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.ANCIENT_DEBRIS
    );
    
    public static final List<Block> WHITE_PALETTE = List.of(
        Blocks.WHITE_TERRACOTTA, Blocks.WHITE_CONCRETE, Blocks.WHITE_STAINED_GLASS, Blocks.WHITE_WOOL,
        Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_CONCRETE, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ,
        Blocks.QUARTZ_BRICKS, Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.CALCITE,
        Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.BONE_BLOCK,
        Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.RAW_IRON_BLOCK,
        Blocks.SNOW_BLOCK, Blocks.PACKED_ICE, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG
    );
    
    public static final List<Block> WOODEN_PALETTE = List.of(
        // All wood types
        Blocks.OAK_PLANKS, Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD,
        Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD,
        Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD,
        Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD,
        Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD,
        Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD,
        Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE,
        Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE,
        Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD,
        Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD,
        Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK
    );
    
    public static final List<Block> STONE_PALETTE = List.of(
        // All stone types
        Blocks.STONE, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS,
        Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, Blocks.SMOOTH_STONE, Blocks.SMOOTH_STONE_SLAB,
        Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE,
        Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE,
        Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
        Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, Blocks.CHISELED_DEEPSLATE,
        Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
        Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE,
        Blocks.BASALT, Blocks.POLISHED_BASALT, Blocks.SMOOTH_BASALT
    );
    
    public static final List<Block> GLASS_PALETTE = List.of(
        // All glass types
        Blocks.GLASS, Blocks.TINTED_GLASS,
        Blocks.WHITE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS,
        Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.LIME_STAINED_GLASS,
        Blocks.PINK_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS,
        Blocks.CYAN_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS,
        Blocks.BROWN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS, Blocks.RED_STAINED_GLASS,
        Blocks.BLACK_STAINED_GLASS,
        
        // Transparent-ish blocks
        Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SLIME_BLOCK, Blocks.HONEY_BLOCK,
        Blocks.SEA_LANTERN, Blocks.GLOWSTONE, Blocks.BEACON, Blocks.CONDUIT
    );
}
