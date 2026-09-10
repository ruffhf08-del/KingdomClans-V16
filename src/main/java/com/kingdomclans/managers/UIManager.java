package com.kingdomclans.managers;

/**
 * Manages UI rendering and updates
 */
public class UIManager {
    private float screenWidth;
    private float screenHeight;
    
    public UIManager() {
        this.screenWidth = 1920;
        this.screenHeight = 1080;
    }
    
    /**
     * Render game background
     */
    public void renderBackground() {
        // TODO: Render grass terrain, sky, etc.
    }
    
    /**
     * Render UI elements
     */
    public void renderUI() {
        // TODO: Render resource bars, buttons, menus
    }
    
    public void dispose() {}
}
