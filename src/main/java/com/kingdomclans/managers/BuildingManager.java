package com.kingdomclans.managers;

import com.kingdomclans.models.*;
import java.util.*;

/**
 * Manages building placement, upgrades, and rendering
 */
public class BuildingManager {
    private Village village;
    private List<Building> buildingsToUpgrade;
    private int maxBuilders;
    private int availableBuilders;
    
    public BuildingManager(Village village) {
        this.village = village;
        this.buildingsToUpgrade = new ArrayList<>();
        this.maxBuilders = 6;
        this.availableBuilders = 1; // Start with 1 builder
    }
    
    /**
     * Update all buildings
     */
    public void update(float delta) {
        // Update upgrades in progress
        for (Building b : village.getBuildings()) {
            if (b.isUpgrading()) {
                b.updateUpgrade(delta);
            }
        }
    }
    
    /**
     * Start building upgrade
     */
    public boolean upgradeBuilding(Building building, ResourceManager rm) {
        if (availableBuilders <= 0) {
            System.out.println("❌ No builders available");
            return false;
        }
        
        if (rm.spendGold(building.getUpgradeCost())) {
            building.startUpgrade(building.getUpgradeCost());
            availableBuilders--;
            System.out.println("👷 Builder assigned (" + availableBuilders + " remaining)");
            return true;
        }
        
        return false;
    }
    
    /**
     * Place new building
     */
    public boolean placeBuilding(Building building, float x, float y) {
        building.setX(x);
        building.setY(y);
        return village.addBuilding(building);
    }
    
    /**
     * Unlock new builder
     */
    public void unlockBuilder() {
        if (availableBuilders < maxBuilders) {
            availableBuilders++;
            System.out.println("🏗️ New builder unlocked! (" + availableBuilders + "/" + maxBuilders + ")");
        }
    }
    
    public void render() {
        // Render all buildings
        for (Building b : village.getBuildings()) {
            // TODO: Render using texture and position
        }
    }
    
    public void dispose() {}
    
    public int getAvailableBuilders() { return availableBuilders; }
    public List<Building> getBuildings() { return village.getBuildings(); }
}
