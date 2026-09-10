package com.kingdomclans.ui;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Shop Screen - Buy buildings and decorations
 */
public class ShopScreen {
    private GameManager gameManager;
    private List<ShopItem> availableItems;
    
    public ShopScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        loadShopItems();
    }
    
    /**
     * Load available shop items
     */
    private void loadShopItems() {
        availableItems = new java.util.ArrayList<>();
        
        // Add shop items based on Town Hall level
        int townHallLevel = gameManager.getVillage().getTownHallLevel();
        
        if (townHallLevel >= 1) {
            availableItems.add(new ShopItem("Builder Hut", "BUILDER_HUT", 500));
            availableItems.add(new ShopItem("Wall", "WALL", 1000));
        }
        
        if (townHallLevel >= 3) {
            availableItems.add(new ShopItem("Dark Elixir Drill", "DE_DRILL", 5000));
        }
        
        if (townHallLevel >= 5) {
            availableItems.add(new ShopItem("Spell Factory", "SPELL_FACTORY", 10000));
        }
    }
    
    /**
     * Purchase item
     */
    public void purchaseItem(ShopItem item) {
        Player player = gameManager.getPlayer();
        
        if (player.getGems() >= item.getCost()) {
            System.out.println("\n✅ Purchased: " + item.getName());
            player.setGold(player.getGold() - item.getCost());
            
            Building newBuilding = new Building();
            newBuilding.setType(item.getType());
            newBuilding.setX((float)(Math.random() * 30));
            newBuilding.setY((float)(Math.random() * 30));
            
            gameManager.getVillage().addBuilding(newBuilding);
        } else {
            System.out.println("\n❌ Insufficient gems!");
        }
    }
    
    public void showShop() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🛒 SHOP");
        System.out.println("=".repeat(60));
        
        int index = 1;
        for (ShopItem item : availableItems) {
            System.out.println("[" + index + "] " + item.getName() + " - " + item.getCost() + " Gems 💎");
            index++;
        }
        System.out.println("\n" + "=".repeat(60));
    }
    
    static class ShopItem {
        private String name;
        private String type;
        private int cost;
        
        public ShopItem(String name, String type, int cost) {
            this.name = name;
            this.type = type;
            this.cost = cost;
        }
        
        public String getName() { return name; }
        public String getType() { return type; }
        public int getCost() { return cost; }
    }
}
