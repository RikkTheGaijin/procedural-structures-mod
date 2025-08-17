# Professional Icon Design Guide

## Icon Requirements
- **Size**: 128x128 pixels (PNG format)
- **Style**: Minecraft-compatible, clean, professional
- **Theme**: Procedural Structures

## Design Concept: "Spiral Tower with Floating Elements"

### Color Scheme
- **Primary**: Stone Gray (#7F7F7F) - represents building blocks
- **Secondary**: Sky Blue (#87CEEB) - represents floating/procedural
- **Accent**: Gold (#FFD700) - represents magical/procedural generation
- **Background**: Dark Gray (#2F2F2F) or Transparent

### Design Elements
1. **Central Structure**: A stylized spiral tower in stone gray
   - Clean geometric lines
   - Slightly twisted/procedural appearance
   - 3D-like shading

2. **Floating Elements**: Small cube/block shapes around the tower
   - Different colors representing themes (red, blue, green, purple)
   - Scattered in a procedural pattern
   - Slight glow effect

3. **Background**: 
   - Dark gradient or transparent
   - Optional: Subtle grid pattern to suggest procedural generation

### Tools to Create Icon
1. **GIMP** (Free): 
   - Create 128x128 canvas
   - Use geometric shapes and gradients
   - Export as PNG

2. **Paint.NET** (Free):
   - Similar to GIMP, good for beginners
   - Built-in effects for glow and shadows

3. **Photoshop/Illustrator** (Professional):
   - Vector graphics for crisp lines
   - Advanced effects and gradients

4. **Online Tools**:
   - Canva (has gaming templates)
   - Figma (free, vector-based)
   - PIXLR (browser-based)

### Quick Design Steps
1. Create 128x128 canvas with dark background
2. Draw central spiral tower using rectangle and transform tools
3. Add small floating cubes around it (8-12 cubes)
4. Apply subtle glow effects
5. Add slight drop shadows for depth
6. Export as PNG
7. Replace the file at: `src/main/resources/assets/procedural_structures/icon.png`

### Alternative: Text-Based Icon
If graphic design isn't available, a clean text-based icon:
- Dark background
- Large "PS" letters in stone gray
- Small decorative blocks around the letters
- Clean, bold font (like Minecraft's style)

## Implementation
Replace the existing icon.png file with your new design, then rebuild the mod with `./gradlew build`.

The icon will appear in:
- Mod list in Minecraft
- Mod browsers like CurseForge/Modrinth
- Development environment

## References
Look at popular Minecraft mods for inspiration:
- WorldEdit: Clean, geometric
- JEI: Simple, recognizable
- Optifine: Professional, themed

Keep it simple, recognizable, and themed to procedural structures!
