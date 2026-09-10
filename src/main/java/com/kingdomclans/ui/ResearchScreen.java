package com.kingdomclans.ui;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Research Screen - Upgrade troops and spells
 */
public class ResearchScreen {
    private GameManager gameManager;
    private List<Research> researchItems;
    
    public ResearchScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        loadResearch();
    }
    
    private void loadResearch() {
        researchItems = new java.util.ArrayList<>();
        researchItems.add(new Research("Barbarian Upgrade", "BARBARIAN", 1000, 300));
        researchItems.add(new Research("Archer Upgrade", "ARCHER", 1500, 600));
        researchItems.add(new Research("Dragon Upgrade", "DRAGON", 5000, 3600));
    }
    
    public void showResearch() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔬 RESEARCH LAB");
        System.out.println("=".repeat(60));
        
        int index = 1;
        for (Research r : researchItems) {
            System.out.println("[" + index + "] " + r.getName() + " - " + r.getCost() + " Elixir (" + r.getTime() + "s)");
            index++;
        }
        
        System.out.println("\n" + "=".repeat(60));
    }
    
    static class Research {
        private String name;
        private String type;
        private int cost;
        private int time;
        
        public Research(String name, String type, int cost, int time) {
            this.name = name;
            this.type = type;
            this.cost = cost;
            this.time = time;
        }
        
        public String getName() { return name; }
        public String getType() { return type; }
        public int getCost() { return cost; }
        public int getTime() { return time; }
    }
}
