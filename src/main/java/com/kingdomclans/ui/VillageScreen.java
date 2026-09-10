package com.kingdomclans.ui;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Main Village Screen - Isometric view with all UI elements
 */
public class VillageScreen {
    private GameManager gameManager;
    private float cameraX, cameraY, zoom;
    private boolean isPanning;
    private float panStartX, panStartY;
    private float screenWidth, screenHeight;
    
    public VillageScreen(GameManager gameManager, float width, float height) {
        this.gameManager = gameManager;
        this.screenWidth = width;
        this.screenHeight = height;
        this.cameraX = 0;
        this.cameraY = 0;
        this.zoom = 1.0f;
        this.isPanning = false;
    }
    
    /**
     * Handle touch/mouse input
     */
    public void handleInput(float x, float y, int action) {
        switch (action) {
            case 0: // Touch down
                panStartX = x;
                panStartY = y;
                isPanning = true;
                handleBuildingSelection(x, y);
                break;
            case 1: // Touch up
                isPanning = false;
                break;
            case 2: // Touch move
                if (isPanning) {
                    float deltaX = x - panStartX;
                    float deltaY = y - panStartY;
                    cameraX -= deltaX / zoom;
                    cameraY -= deltaY / zoom;
                    panStartX = x;
                    panStartY = y;
                }
                break;
        }
    }
    
    /**
     * Handle zoom
     */
    public void handleZoom(float scale) {
        zoom *= scale;
        zoom = Math.max(0.5f, Math.min(3.0f, zoom)); // Clamp zoom
    }
    
    /**
     * Handle building selection
     */
    private void handleBuildingSelection(float x, float y) {
        // Convert screen coords to world coords
        float worldX = x / zoom + cameraX;
        float worldY = y / zoom + cameraY;
        
        Village village = gameManager.getVillage();
        for (Building b : village.getBuildings()) {
            if (isPointInBuilding(worldX, worldY, b)) {
                showBuildingPanel(b);
                break;
            }
        }
    }
    
    private boolean isPointInBuilding(float x, float y, Building b) {
        return x >= b.getX() && x <= b.getX() + b.getWidth() &&
               y >= b.getY() && y <= b.getY() + b.getHeight();
    }
    
    /**
     * Show building upgrade panel
     */
    private void showBuildingPanel(Building building) {
        System.out.println("\n📋 " + building.getType() + " (Level " + building.getLevel() + ")");
        System.out.println("   HP: " + building.getHitPoints() + "/" + building.getMaxHitPoints());
        System.out.println("   Upgrade Cost: " + building.getUpgradeCost() + " Gold");
        System.out.println("   Upgrade Time: " + (int)building.getUpgradeTime() + "s");
        
        if (!building.isUpgrading()) {
            System.out.println("   [UPGRADE]");
        } else {
            System.out.println("   [UPGRADING: " + (int)(building.getUpgradeProgress() / building.getUpgradeTime() * 100) + "%]");
        }
    }
    
    /**
     * Render village screen
     */
    public void render() {
        Village village = gameManager.getVillage();
        Player player = gameManager.getPlayer();
        
        // Clear screen
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎮 KINGDOM CLANS - VILLAGE VIEW");
        System.out.println("=".repeat(60));
        
        // Player info
        System.out.println("\n👤 " + player.getPlayerName() + " | Level: " + player.getLevel() + " | Trophies: " + player.getTrophies());
        
        // Village info
        System.out.println("🏰 " + village.getVillageName() + " | Town Hall: " + village.getTownHallLevel());
        
        // Resources
        System.out.println("\n💰 Resources:");
        System.out.println("   Gold: " + village.getGold() + " 🟡");
        System.out.println("   Elixir: " + village.getElixir() + " 💜");
        System.out.println("   Dark Elixir: " + village.getDarkElixir() + " ⚫");
        System.out.println("   Gems: " + player.getGems() + " 💎");
        
        // Buildings list
        System.out.println("\n🏗️  Buildings (" + village.getBuildings().size() + "):");
        for (Building b : village.getBuildings()) {
            String status = b.isUpgrading() ? "⏳" : "✅";
            System.out.println("   " + status + " " + b.getType() + " L" + b.getLevel() + " (HP: " + b.getHitPoints() + ")");
        }
        
        System.out.println("\n" + "=".repeat(60));
    }
}
