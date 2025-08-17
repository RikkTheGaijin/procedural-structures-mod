package com.procedural_structures.config;

public class StructureConfig {
    public enum StructureTheme {
        DEFAULT("Default", "Mixed blocks from all categories"),
        NETHER("Nether", "Fire-resistant nether materials"),
        END("End", "Mysterious end stone and chorus blocks"),
        MEDIEVAL("Medieval", "Stone bricks and cobblestone"),
        MODERN("Modern", "Clean concrete and glass"),
        NATURE("Nature", "Wood and organic materials"),
        OCEAN("Ocean", "Aquatic prismarine blocks"),
        DESERT("Desert", "Sandstone and terracotta"),
        SNOW("Snow", "Ice and snow blocks"),
        JUNGLE("Jungle", "Tropical jungle woods"),
        COLOR_RED("Red", "Red-themed blocks only"),
        COLOR_BLUE("Blue", "Blue-themed blocks only"),
        COLOR_GREEN("Green", "Green-themed blocks only"),
        COLOR_PURPLE("Purple", "Purple-themed blocks only"),
        RAINBOW("Rainbow", "Colorful mixed palette");
        
        private final String displayName;
        private final String description;
        
        StructureTheme(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    // Configuration values
    private static StructureTheme currentTheme = StructureTheme.DEFAULT;
    private static int minScale = 8;
    private static int maxScale = 28;
    private static boolean enableDecorations = true;
    private static boolean enableFloatingIslands = true;
    private static boolean enableLighting = true;
    private static boolean enablePlants = true;
    
    // Getters and setters
    public static StructureTheme getCurrentTheme() {
        return currentTheme;
    }
    
    public static void setCurrentTheme(StructureTheme theme) {
        currentTheme = theme;
    }
    
    public static int getMinScale() {
        return minScale;
    }
    
    public static void setMinScale(int scale) {
        minScale = Math.max(3, Math.min(scale, maxScale - 1));
    }
    
    public static int getMaxScale() {
        return maxScale;
    }
    
    public static void setMaxScale(int scale) {
        maxScale = Math.max(minScale + 1, Math.min(scale, 50));
    }
    
    public static boolean isDecorationsEnabled() {
        return enableDecorations;
    }
    
    public static void setDecorationsEnabled(boolean enabled) {
        enableDecorations = enabled;
    }
    
    public static boolean isFloatingIslandsEnabled() {
        return enableFloatingIslands;
    }
    
    public static void setFloatingIslandsEnabled(boolean enabled) {
        enableFloatingIslands = enabled;
    }
    
    public static boolean isLightingEnabled() {
        return enableLighting;
    }
    
    public static void setLightingEnabled(boolean enabled) {
        enableLighting = enabled;
    }
    
    public static boolean isPlantsEnabled() {
        return enablePlants;
    }
    
    public static void setPlantsEnabled(boolean enabled) {
        enablePlants = enabled;
    }
    
    public static void nextTheme() {
        StructureTheme[] themes = StructureTheme.values();
        int currentIndex = currentTheme.ordinal();
        currentTheme = themes[(currentIndex + 1) % themes.length];
    }
    
    public static void previousTheme() {
        StructureTheme[] themes = StructureTheme.values();
        int currentIndex = currentTheme.ordinal();
        currentTheme = themes[(currentIndex - 1 + themes.length) % themes.length];
    }
}
