package com.kingdomclans.models;

import java.util.*;

/**
 * Village model - stores village data and building layout
 */
public class Village {
    private int villageId;
    private int playerId;
    private String villageName;
    private int townHallLevel;
    private List<Building> buildings;
    private Map<Building, Long> upgradesInProgress;
    private long gold;
    private long elixir;
    private long darkElixir;
    private int width;
    private int height;
    private long createdAt;
    
    public Village() {
        this.villageId = (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
        this.villageName = "Village " + villageId;
        this.townHallLevel = 1;
        this.buildings = new ArrayList<>();
        this.upgradesInProgress = new HashMap<>();
        this.gold = 5000;
        this.elixir = 5000;
        this.darkElixir = 0;
        this.width = 40; // Grid size
        this.height = 40;
        this.createdAt = System.currentTimeMillis();
        
        initializeStarterBuildings();
    }
    
    /**
     * Create starter buildings for new village
     */
    private void initializeStarterBuildings() {
        // Town Hall
        Building townHall = new Building();
        townHall.setType("TOWN_HALL");
        townHall.setLevel(1);
        townHall.setX(20);
        townHall.setY(20);
        buildings.add(townHall);
        
        // Gold Mine
        Building goldMine = new Building();
        goldMine.setType("GOLD_MINE");
        goldMine.setLevel(1);
        goldMine.setX(15);
        goldMine.setY(15);
        buildings.add(goldMine);
        
        // Elixir Collector
        Building elixirCollector = new Building();
        elixirCollector.setType("ELIXIR_COLLECTOR");
        elixirCollector.setLevel(1);
        elixirCollector.setX(25);
        elixirCollector.setY(15);
        buildings.add(elixirCollector);
        
        System.out.println("🏰 Village initialized with starter buildings");
    }
    
    /**
     * Add building to village
     */
    public boolean addBuilding(Building building) {
        if (isPositionValid(building.getX(), building.getY())) {
            buildings.add(building);
            return true;
        }
        return false;
    }
    
    /**
     * Check if position is valid
     */
    private boolean isPositionValid(float x, float y) {
        // Check bounds
        if (x < 0 || y < 0 || x > width || y > height) return false;
        
        // Check collision with existing buildings
        for (Building b : buildings) {
            if (isColliding(x, y, b.getX(), b.getY())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isColliding(float x1, float y1, float x2, float y2) {
        return Math.abs(x1 - x2) < 3 && Math.abs(y1 - y2) < 3;
    }
    
    /**
     * Upgrade town hall
     */
    public void upgradeTownHall() {
        if (townHallLevel < 14) {
            townHallLevel++;
            System.out.println("📈 Town Hall upgraded to level " + townHallLevel);
        }
    }
    
    // Getters and Setters
    public int getVillageId() { return villageId; }
    public String getVillageName() { return villageName; }
    public void setVillageName(String name) { this.villageName = name; }
    
    public int getTownHallLevel() { return townHallLevel; }
    public void setTownHallLevel(int level) { this.townHallLevel = level; }
    
    public List<Building> getBuildings() { return buildings; }
    
    public long getGold() { return gold; }
    public void setGold(long amount) { this.gold = Math.max(0, amount); }
    
    public long getElixir() { return elixir; }
    public void setElixir(long amount) { this.elixir = Math.max(0, amount); }
    
    public long getDarkElixir() { return darkElixir; }
    public void setDarkElixir(long amount) { this.darkElixir = Math.max(0, amount); }
    
    @Override
    public String toString() {
        return String.format("Village{name='%s', townHall=%d, buildings=%d, gold=%d}",
            villageName, townHallLevel, buildings.size(), gold);
    }
}
