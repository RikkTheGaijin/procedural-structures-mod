package com.procedural_structures.client;

import com.procedural_structures.config.StructureConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private ButtonWidget decorationsButton;
    private ButtonWidget lightingButton;
    private ButtonWidget plantsButton;
    private ButtonWidget floatingIslandsButton;
    private ButtonWidget themeButton;
    private SliderWidget minScaleSlider;
    private SliderWidget maxScaleSlider;

    public ConfigScreen(Screen parent) {
        super(Text.translatable("gui.procedural_structures.config.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int startY = 50;
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacing = 25;

        // Theme selection
        this.themeButton = ButtonWidget.builder(
            Text.literal("Theme: " + StructureConfig.getCurrentTheme().getDisplayName()),
            button -> {
                StructureConfig.nextTheme();
                button.setMessage(Text.literal("Theme: " + StructureConfig.getCurrentTheme().getDisplayName()));
            })
            .dimensions(centerX - buttonWidth / 2, startY, buttonWidth, buttonHeight)
            .build();
        this.addDrawableChild(themeButton);

        // Scale sliders
        this.minScaleSlider = new SliderWidget(centerX - buttonWidth / 2, startY + spacing, buttonWidth, buttonHeight, 
            Text.literal("Min Scale: " + StructureConfig.getMinScale()), 
            (StructureConfig.getMinScale() - 3) / 47.0) {
            @Override
            protected void updateMessage() {
                int value = (int) (this.value * 47) + 3;
                this.setMessage(Text.literal("Min Scale: " + value));
            }

            @Override
            protected void applyValue() {
                int value = (int) (this.value * 47) + 3;
                StructureConfig.setMinScale(value);
            }
        };
        this.addDrawableChild(minScaleSlider);

        this.maxScaleSlider = new SliderWidget(centerX - buttonWidth / 2, startY + spacing * 2, buttonWidth, buttonHeight,
            Text.literal("Max Scale: " + StructureConfig.getMaxScale()),
            (StructureConfig.getMaxScale() - 3) / 47.0) {
            @Override
            protected void updateMessage() {
                int value = (int) (this.value * 47) + 3;
                this.setMessage(Text.literal("Max Scale: " + value));
            }

            @Override
            protected void applyValue() {
                int value = (int) (this.value * 47) + 3;
                StructureConfig.setMaxScale(value);
            }
        };
        this.addDrawableChild(maxScaleSlider);

        // Toggle buttons
        this.decorationsButton = ButtonWidget.builder(
            Text.literal("Decorations: " + (StructureConfig.isDecorationsEnabled() ? "ON" : "OFF")),
            button -> {
                StructureConfig.setDecorationsEnabled(!StructureConfig.isDecorationsEnabled());
                button.setMessage(Text.literal("Decorations: " + (StructureConfig.isDecorationsEnabled() ? "ON" : "OFF")));
            })
            .dimensions(centerX - buttonWidth / 2, startY + spacing * 3, buttonWidth, buttonHeight)
            .build();
        this.addDrawableChild(decorationsButton);

        this.lightingButton = ButtonWidget.builder(
            Text.literal("Lighting: " + (StructureConfig.isLightingEnabled() ? "ON" : "OFF")),
            button -> {
                StructureConfig.setLightingEnabled(!StructureConfig.isLightingEnabled());
                button.setMessage(Text.literal("Lighting: " + (StructureConfig.isLightingEnabled() ? "ON" : "OFF")));
            })
            .dimensions(centerX - buttonWidth / 2, startY + spacing * 4, buttonWidth, buttonHeight)
            .build();
        this.addDrawableChild(lightingButton);

        this.plantsButton = ButtonWidget.builder(
            Text.literal("Plants: " + (StructureConfig.isPlantsEnabled() ? "ON" : "OFF")),
            button -> {
                StructureConfig.setPlantsEnabled(!StructureConfig.isPlantsEnabled());
                button.setMessage(Text.literal("Plants: " + (StructureConfig.isPlantsEnabled() ? "ON" : "OFF")));
            })
            .dimensions(centerX - buttonWidth / 2, startY + spacing * 5, buttonWidth, buttonHeight)
            .build();
        this.addDrawableChild(plantsButton);

        this.floatingIslandsButton = ButtonWidget.builder(
            Text.literal("Floating Islands: " + (StructureConfig.isFloatingIslandsEnabled() ? "ON" : "OFF")),
            button -> {
                StructureConfig.setFloatingIslandsEnabled(!StructureConfig.isFloatingIslandsEnabled());
                button.setMessage(Text.literal("Floating Islands: " + (StructureConfig.isFloatingIslandsEnabled() ? "ON" : "OFF")));
            })
            .dimensions(centerX - buttonWidth / 2, startY + spacing * 6, buttonWidth, buttonHeight)
            .build();
        this.addDrawableChild(floatingIslandsButton);

        // Done button
        this.addDrawableChild(ButtonWidget.builder(
            Text.translatable("gui.procedural_structures.config.done"),
            button -> this.close())
            .dimensions(centerX - 50, startY + spacing * 8, 100, buttonHeight)
            .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Render a simple background instead of using blur
        context.fill(0, 0, this.width, this.height, 0x88000000);
        
        super.render(context, mouseX, mouseY, delta);
        
        // Title
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        
        // Current theme description
        String description = StructureConfig.getCurrentTheme().getDescription();
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(description), 
            this.width / 2, 160, 0xAAAAAA);
        
        // Help text
        context.drawCenteredTextWithShadow(this.textRenderer, 
            Text.translatable("gui.procedural_structures.config.help"), 
            this.width / 2, this.height - 30, 0x888888);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parent);
        }
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game
    }
}
