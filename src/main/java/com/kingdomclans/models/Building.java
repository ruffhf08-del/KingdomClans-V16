package com.kingdomclans.models;

/**
 * Building model - represents a building in the village
 */
public class Building {
    private String buildingId;
    private String type; // TOWN_HALL, GOLD_MINE, BARRACKS, etc.
    private int level;
    private float x, y; // Position in village
    private float width, height; // Size
    private int hitPoints;
    private int maxHitPoints;
    private long upgradeCost;
    private float upgradeTime; // In seconds
    private boolean isUpgrading;
    private float upgradeProgress;
    private String texture; // Asset reference
    
    public Building() {
        this.buildingId = "building_" + System.nanoTime();
        this.level = 1;
        this.width = 2.0f;
        this.height = 2.0f;
        this.hitPoints = 100;
        this.maxHitPoints = 100;
        this.upgradeCost = 1000;
        this.upgradeTime = 300; // 5 minutes
        this.isUpgrading = false;
        this.upgradeProgress = 0.0f;
    }
    
    /**
     * Start upgrade process
     */
    public void startUpgrade(long cost) {
        if (!isUpgrading) {
            isUpgrading = true;
            upgradeProgress = 0.0f;
            System.out.println("🔨 " + type + " upgrade started (Level " + level + " -> " + (level + 1) + ")");
        }
    }
    
    /**
     * Update upgrade progress
     */
    public void updateUpgrade(float delta) {
        if (isUpgrading) {
            upgradeProgress += delta;
            if (upgradeProgress >= upgradeTime) {
                completeUpgrade();
            }
        }
    }
    
    /**
     * Complete upgrade
     */
    private void completeUpgrade() {
        isUpgrading = false;
        level++;
        upgradeProgress = 0.0f;
        calculateStats();
        System.out.println("✅ " + type + " upgraded to level " + level);
    }
    
    /**
     * Calculate building stats based on level
     */
    private void calculateStats() {
        // HP scales with level
        maxHitPoints = 100 + (level * 50);
        hitPoints = maxHitPoints;
        
        // Upgrade cost scales
        upgradeCost = (long)(1000 * Math.pow(1.1, level));
        
        // Upgrade time scales
        upgradeTime = 300 * (level * level); // Quadratic growth
    }
    
    /**
     * Take damage
     */
    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0) hitPoints = 0;
    }
    
    /**
     * Check if building is destroyed
     */
    public boolean isDestroyed() {
        return hitPoints <= 0;
    }
    
    // Getters and Setters
    public String getBuildingId() { return buildingId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; calculateStats(); }
    
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    
    public int getHitPoints() { return hitPoints; }
    public int getMaxHitPoints() { return maxHitPoints; }
    
    public long getUpgradeCost() { return upgradeCost; }
    public float getUpgradeTime() { return upgradeTime; }
    public boolean isUpgrading() { return isUpgrading; }
    public float getUpgradeProgress() { return upgradeProgress; }
    
    @Override
    public String toString() {
        return String.format("Building{type='%s', level=%d, pos=(%.1f,%.1f), hp=%d/%d}",
            type, level, x, y, hitPoints, maxHitPoints);
    }
}
