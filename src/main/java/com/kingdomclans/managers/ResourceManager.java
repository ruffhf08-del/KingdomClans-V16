package com.kingdomclans.managers;

import com.kingdomclans.models.*;
import java.util.*;

/**
 * Manages all resources (Gold, Elixir, Dark Elixir)
 */
public class ResourceManager {
    private Village village;
    private Map<String, Long> productionRates;
    private long lastUpdateTime;
    
    public ResourceManager(Village village) {
        this.village = village;
        this.productionRates = new HashMap<>();
        this.lastUpdateTime = System.currentTimeMillis();
        calculateProductionRates();
    }
    
    /**
     * Calculate production rates from buildings
     */
    private void calculateProductionRates() {
        long goldRate = 0;
        long elixirRate = 0;
        long darkElixirRate = 0;
        
        for (Building b : village.getBuildings()) {
            if ("GOLD_MINE".equals(b.getType())) {
                goldRate += 50 * b.getLevel(); // +50 per level
            } else if ("ELIXIR_COLLECTOR".equals(b.getType())) {
                elixirRate += 40 * b.getLevel(); // +40 per level
            } else if ("DARK_ELIXIR_DRILL".equals(b.getType())) {
                darkElixirRate += 5 * b.getLevel(); // +5 per level
            }
        }
        
        productionRates.put("gold", goldRate);
        productionRates.put("elixir", elixirRate);
        productionRates.put("darkElixir", darkElixirRate);
    }
    
    /**
     * Update resources based on production
     */
    public void update(float delta) {
        long currentTime = System.currentTimeMillis();
        long timePassed = (currentTime - lastUpdateTime) / 1000; // Convert to seconds
        
        if (timePassed > 0) {
            // Calculate production
            long goldProduced = (productionRates.get("gold") * timePassed) / 60; // Per minute
            long elixirProduced = (productionRates.get("elixir") * timePassed) / 60;
            long deProduced = (productionRates.get("darkElixir") * timePassed) / 60;
            
            // Add to village
            village.setGold(village.getGold() + goldProduced);
            village.setElixir(village.getElixir() + elixirProduced);
            village.setDarkElixir(village.getDarkElixir() + deProduced);
            
            lastUpdateTime = currentTime;
        }
    }
    
    /**
     * Spend resources
     */
    public boolean spendGold(long amount) {
        if (village.getGold() >= amount) {
            village.setGold(village.getGold() - amount);
            return true;
        }
        return false;
    }
    
    public boolean spendElixir(long amount) {
        if (village.getElixir() >= amount) {
            village.setElixir(village.getElixir() - amount);
            return true;
        }
        return false;
    }
    
    public boolean spendDarkElixir(long amount) {
        if (village.getDarkElixir() >= amount) {
            village.setDarkElixir(village.getDarkElixir() - amount);
            return true;
        }
        return false;
    }
    
    /**
     * Add resources
     */
    public void addGold(long amount) {
        village.setGold(village.getGold() + amount);
    }
    
    public void addElixir(long amount) {
        village.setElixir(village.getElixir() + amount);
    }
    
    public void addDarkElixir(long amount) {
        village.setDarkElixir(village.getDarkElixir() + amount);
    }
    
    public void dispose() {}
    
    public long getProductionRate(String type) {
        return productionRates.getOrDefault(type, 0L);
    }
}
