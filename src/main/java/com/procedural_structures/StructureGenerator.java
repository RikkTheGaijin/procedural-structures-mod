package com.procedural_structures;

import com.procedural_structures.config.BlockPalettes;
import com.procedural_structures.config.StructureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StructureGenerator {
    private static final Random RANDOM = new Random();
    
    private static final List<Block> GLASS_BLOCKS = List.of(
        Blocks.WHITE_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, 
        Blocks.RED_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS
    );
    
    private static final List<Block> LIGHT_BLOCKS = List.of(
        Blocks.LANTERN, Blocks.END_ROD, Blocks.TORCH, Blocks.SEA_LANTERN, Blocks.GLOWSTONE
    );
    
    private static final List<Block> PLANT_BLOCKS = List.of(
        Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DANDELION, Blocks.POPPY, 
        Blocks.LILY_OF_THE_VALLEY, Blocks.BLUE_ORCHID
    );
    
    private static final List<Block> SIGNATURE_BLOCKS = List.of(
        Blocks.EMERALD_BLOCK, Blocks.LAPIS_BLOCK, Blocks.GOLD_BLOCK, 
        Blocks.REDSTONE_BLOCK, Blocks.DIAMOND_BLOCK, Blocks.COAL_BLOCK
    );
    
    private static final List<Block> ISLAND_BASE_BLOCKS = List.of(
        Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.MOSS_BLOCK
    );

    public static void generateRandomStructure(net.minecraft.world.World world, BlockPos playerPos, PlayerEntity player) {
        if (!(world instanceof ServerWorld serverWorld)) {
            return; // Only generate on server side
        }
        
        player.sendMessage(Text.literal("§6Generating procedural structure... §7(Theme: " + 
            StructureConfig.getCurrentTheme().getDisplayName() + ")"), false);
        
        // Get themed palette
        List<Block> palette = getThemedPalette();
        String motif = getRandomMotif();
        int scale = rndInt(StructureConfig.getMinScale(), StructureConfig.getMaxScale());
        int baseRadius = Math.max(3, scale / rndInt(3, 6));
        int height = Math.max(6, (int)(scale * (RANDOM.nextDouble() * 1.2 + 0.8)));
        int turns = rndInt(2, Math.max(3, height / 6));
        
        BlockPos centerPos = playerPos.add(rndInt(-5, 5), 0, rndInt(-5, 5));
        
        // Build the structure
        buildFoundation(serverWorld, centerPos, baseRadius, palette);
        
        if (motif.equals("spiral") || motif.equals("pavilion") || motif.equals("cantilever")) {
            buildSpiralTower(serverWorld, centerPos, baseRadius, height, palette, turns);
            buildCantilevers(serverWorld, centerPos, rndInt(2, Math.max(3, baseRadius / 2)), 
                Math.max(3, (int)(baseRadius * 1.6)), palette);
        } else if (motif.equals("dome")) {
            buildDome(serverWorld, centerPos, baseRadius, height, palette);
            buildCantilevers(serverWorld, centerPos, rndInt(1, 3), 
                Math.max(3, (int)(baseRadius * 1.5)), palette);
        } else if (motif.equals("floating_islands") && StructureConfig.isFloatingIslandsEnabled()) {
            buildSpiralTower(serverWorld, centerPos, baseRadius, height / 2, palette, Math.max(2, turns - 1));
            buildFloatingIslands(serverWorld, centerPos, rndInt(3, 7), baseRadius + scale / 6);
        }
        
        // Add decorations based on config
        if (StructureConfig.isDecorationsEnabled()) {
            addDecorations(serverWorld, centerPos, palette, scale);
        }
        
        // Add lights and plants based on config
        if (StructureConfig.isLightingEnabled()) {
            addLightsAndPlants(serverWorld, centerPos, height);
        }
        
        // Add bridges
        addBridges(serverWorld, centerPos, baseRadius, height, palette);
        
        // Add signature block
        addSignatureBlock(serverWorld, centerPos, baseRadius, height);
        
        player.sendMessage(Text.literal("§aStructure generated! §7Motif: " + motif + ", Scale: " + scale), false);
    }
    
    private static List<Block> getThemedPalette() {
        List<Block> basePalette;
        
        switch (StructureConfig.getCurrentTheme()) {
            case NETHER -> basePalette = BlockPalettes.NETHER_PALETTE;
            case END -> basePalette = BlockPalettes.END_PALETTE;
            case MEDIEVAL -> basePalette = BlockPalettes.STONE_PALETTE;
            case MODERN -> basePalette = BlockPalettes.WHITE_PALETTE;
            case NATURE -> basePalette = BlockPalettes.WOODEN_PALETTE;
            case OCEAN -> basePalette = BlockPalettes.BLUE_PALETTE;
            case DESERT -> basePalette = BlockPalettes.YELLOW_PALETTE;
            case SNOW -> basePalette = BlockPalettes.WHITE_PALETTE;
            case JUNGLE -> basePalette = BlockPalettes.GREEN_PALETTE;
            case COLOR_RED -> basePalette = BlockPalettes.RED_PALETTE;
            case COLOR_BLUE -> basePalette = BlockPalettes.BLUE_PALETTE;
            case COLOR_GREEN -> basePalette = BlockPalettes.GREEN_PALETTE;
            case COLOR_PURPLE -> basePalette = BlockPalettes.PURPLE_PALETTE;
            case BLACK -> basePalette = BlockPalettes.BLACK_PALETTE;
            case WHITE -> basePalette = BlockPalettes.WHITE_PALETTE;
            default -> basePalette = BlockPalettes.DEFAULT_PALETTE;
        }
        
        // Randomize the palette order
        List<Block> shuffled = new ArrayList<>(basePalette);
        Collections.shuffle(shuffled, RANDOM);
        return shuffled.subList(0, Math.min(shuffled.size(), Math.max(25, rndInt(25, 40))));
    }
    
    private static String getRandomMotif() {
        String[] motifs = {"spiral", "pavilion", "dome", "floating_islands", "cantilever"};
        return motifs[RANDOM.nextInt(motifs.length)];
    }
    
    private static void buildFoundation(ServerWorld world, BlockPos center, int radius, List<Block> palette) {
        int idx = 0;
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if (Math.hypot(dx, dz) <= radius + 0.5) {
                    Block block = palette.get(idx % palette.size());
                    setBlock(world, center.add(dx, 0, dz), block);
                    idx++;
                }
            }
        }
    }
    
    private static void buildSpiralTower(ServerWorld world, BlockPos center, int baseRadius, int height, List<Block> palette, int turns) {
        // Central core column
        for (int h = 1; h <= height; h++) {
            Block blockCore = choice(palette);
            setBlock(world, center.add(0, h, 0), blockCore);
        }
        
        // Spiral shell
        int segmentsPerTurn = 12;
        int totalSegments = turns * segmentsPerTurn;
        int spiralPoints = totalSegments * (height / Math.max(8, height / 8));
        
        for (int seg = 0; seg < spiralPoints; seg++) {
            double t = (double) seg / totalSegments;
            int y = (int) Math.round(t * height);
            double angle = seg * (2 * Math.PI / segmentsPerTurn);
            
            int radius = Math.max(1, (int) Math.round(baseRadius * (1 - t * 0.6) + Math.sin(seg * 0.3) * 0.8));
            int x = (int) Math.round(Math.cos(angle) * radius);
            int z = (int) Math.round(Math.sin(angle) * radius);
            
            Block block = palette.get((seg + y) % palette.size());
            setBlock(world, center.add(x, y, z), block);
            
            // Add occasional decorations
            if (RANDOM.nextDouble() < 0.06) {
                setBlock(world, center.add(x, y + 1, z), Blocks.END_ROD);
            }
            if (RANDOM.nextDouble() < 0.04) {
                setBlock(world, center.add(x, y, z + 1), choice(GLASS_BLOCKS));
            }
        }
    }
    
    private static void buildDome(ServerWorld world, BlockPos center, int baseRadius, int height, List<Block> palette) {
        for (int h = 1; h <= height; h++) {
            int radius = Math.max(1, (int) Math.round(baseRadius * (1 - (double) h / (height + 1))));
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx * dx + dz * dz <= radius * radius + 0.5) {
                        setBlock(world, center.add(dx, h, dz), choice(palette));
                    }
                }
            }
        }
        
        // Center pillar
        for (int h = 1; h <= height / 2; h++) {
            setBlock(world, center.add(0, h, 0), choice(palette));
        }
    }
    
    private static void buildCantilevers(ServerWorld world, BlockPos center, int count, int maxLen, List<Block> palette) {
        for (int i = 0; i < count; i++) {
            double sideAngle = RANDOM.nextDouble() * Math.PI * 2;
            int y = rndInt(2, Math.max(3, maxLen / 2));
            int len = rndInt(3, maxLen);
            int dx = (int) Math.round(Math.cos(sideAngle));
            int dz = (int) Math.round(Math.sin(sideAngle));
            
            int bx = center.getX(), bz = center.getZ();
            for (int l = 1; l <= len; l++) {
                bx = center.getX() + dx * l;
                bz = center.getZ() + dz * l;
                Block block = choice(palette);
                setBlock(world, new BlockPos(bx, center.getY() + y, bz), block);
                
                if (l == len && RANDOM.nextDouble() < 0.6) {
                    // Create platform
                    for (int sx = -1; sx <= 1; sx++) {
                        for (int sz = -1; sz <= 1; sz++) {
                            setBlock(world, new BlockPos(bx + sx, center.getY() + y, bz + sz), choice(palette));
                            if (RANDOM.nextDouble() < 0.2) {
                                setBlock(world, new BlockPos(bx + sx, center.getY() + y + 1, bz + sz), choice(LIGHT_BLOCKS));
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void buildFloatingIslands(ServerWorld world, BlockPos center, int count, int maxRadius) {
        for (int i = 0; i < count; i++) {
            int ix = center.getX() + rndInt(-maxRadius * 2, maxRadius * 2);
            int iz = center.getZ() + rndInt(-maxRadius * 2, maxRadius * 2);
            int iy = center.getY() + rndInt(6, 14);
            int radius = rndInt(2, Math.max(2, Math.min(6, maxRadius / 2)));
            
            // Island base
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (Math.hypot(dx, dz) <= radius + 0.5) {
                        int ydrop = RANDOM.nextDouble() < 0.15 ? -1 : 0;
                        Block block = RANDOM.nextDouble() < 0.5 ? Blocks.GRASS_BLOCK : choice(ISLAND_BASE_BLOCKS);
                        setBlock(world, new BlockPos(ix + dx, iy + ydrop, iz + dz), block);
                        
                        // Surface plants
                        if (RANDOM.nextDouble() < 0.25) {
                            Block plant = choice(PLANT_BLOCKS);
                            setBlock(world, new BlockPos(ix + dx, iy + 1 + ydrop, iz + dz), plant);
                        }
                    }
                }
            }
            
            // Hanging chains/lanterns
            if (RANDOM.nextDouble() < 0.6) {
                setBlock(world, new BlockPos(ix, iy - 1, iz), Blocks.CHAIN);
                setBlock(world, new BlockPos(ix, iy - 2, iz), Blocks.LANTERN);
            }
        }
    }
    
    private static void addDecorations(ServerWorld world, BlockPos center, List<Block> palette, int scale) {
        // Glass canopy
        int r = Math.max(2, scale / 3);
        for (int dx = -r; dx <= r; dx++) {
            for (int dz = -r; dz <= r; dz++) {
                if (dx * dx + dz * dz <= r * r) {
                    int y = rndInt(Math.max(2, scale / 4), Math.max(3, scale / 2));
                    if (RANDOM.nextDouble() < 0.8) {
                        setBlock(world, center.add(dx, y, dz), choice(GLASS_BLOCKS));
                    }
                }
            }
        }
        
        // Waterfall-like structures using glass
        for (int i = 0; i < Math.max(1, scale / 6); i++) {
            int sx = center.getX() + rndInt(-Math.max(2, scale / 2), Math.max(2, scale / 2));
            int sz = center.getZ() + rndInt(-Math.max(2, scale / 2), Math.max(2, scale / 2));
            int topY = center.getY() + rndInt(3, Math.max(6, scale / 3));
            int len = rndInt(3, Math.max(3, scale / 3));
            
            for (int l = 0; l < len; l++) {
                Block block = choice(List.of(Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.GLASS, Blocks.BLUE_STAINED_GLASS));
                setBlock(world, new BlockPos(sx, topY - l, sz), block);
            }
        }
    }
    
    private static void addLightsAndPlants(ServerWorld world, BlockPos center, int height) {
        for (int h = 2; h <= Math.min(20, height); h += rndInt(1, 3)) {
            if (RANDOM.nextDouble() < 0.5) {
                int x = center.getX() + rndInt(-1, 1);
                int z = center.getZ() + rndInt(-1, 1);
                setBlock(world, new BlockPos(x, center.getY() + h, z), choice(LIGHT_BLOCKS));
            }
            if (StructureConfig.isPlantsEnabled() && RANDOM.nextDouble() < 0.4) {
                int x = center.getX() + rndInt(-2, 2);
                int z = center.getZ() + rndInt(-2, 2);
                setBlock(world, new BlockPos(x, center.getY() + h, z), choice(PLANT_BLOCKS));
            }
        }
    }
    
    private static void addBridges(ServerWorld world, BlockPos center, int baseRadius, int height, List<Block> palette) {
        int bridgeCount = rndInt(1, Math.max(1, baseRadius / 2));
        for (int b = 0; b < bridgeCount; b++) {
            int dirX = rndInt(-1, 1);
            int dirZ = dirX == 0 ? (RANDOM.nextBoolean() ? -1 : 1) : 0;
            int len = rndInt(4, Math.max(6, baseRadius * rndInt(1, 3)));
            int by = center.getY() + rndInt(1, Math.max(2, height / 3));
            
            for (int s = 1; s <= len; s++) {
                int bx = center.getX() + dirX * s;
                int bz = center.getZ() + dirZ * s;
                setBlock(world, new BlockPos(bx, by, bz), choice(palette));
                if (RANDOM.nextDouble() < 0.15) {
                    setBlock(world, new BlockPos(bx, by + 1, bz), Blocks.LANTERN);
                }
            }
        }
    }
    
    private static void addSignatureBlock(ServerWorld world, BlockPos center, int baseRadius, int height) {
        int sigX = center.getX() + rndInt(-Math.max(2, baseRadius), Math.max(2, baseRadius));
        int sigZ = center.getZ() + rndInt(-Math.max(2, baseRadius), Math.max(2, baseRadius));
        int sigY = center.getY() + rndInt(1, Math.max(3, height / 4));
        Block signature = choice(SIGNATURE_BLOCKS);
        setBlock(world, new BlockPos(sigX, sigY, sigZ), signature);
    }
    
    private static void setBlock(ServerWorld world, BlockPos pos, Block block) {
        if (world.isInBuildLimit(pos)) {
            world.setBlockState(pos, block.getDefaultState());
        }
    }
    
    private static <T> T choice(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }
    
    private static int rndInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
