package com.kingdomclans.ui;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Army Screen - Train troops and manage army
 */
public class ArmyScreen {
    private GameManager gameManager;
    private String[] troopTypes = {"BARBARIAN", "ARCHER", "GIANT", "WIZARD", "DRAGON"};
    
    public ArmyScreen(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    
    /**
     * Show army screen
     */
    public void showArmy() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⚔️  ARMY");
        System.out.println("=".repeat(60));
        
        List<Troop> troops = gameManager.getArmyManager().getTroops();
        int capacity = gameManager.getArmyManager().getArmyCapacity();
        
        System.out.println("\n📊 Army Size: " + troops.size() + "/" + capacity);
        System.out.println("\n🪖 Trained Troops:");
        
        for (Troop t : troops) {
            System.out.println("   🗡️  " + t.getType() + " L" + t.getLevel() + " (Damage: " + t.getDamage() + ")");
        }
        
        System.out.println("\n🏭 Train New Troops:");
        int index = 1;
        for (String type : troopTypes) {
            Troop temp = new Troop(type, 1);
            System.out.println("[" + index + "] " + type + " - " + temp.getTrainingCost() + " Elixir (" + temp.getTrainingTime() + "s)");
            index++;
        }
        
        System.out.println("\n" + "=".repeat(60));
    }
    
    /**
     * Train troop
     */
    public void trainTroop(int troopIndex) {
        if (troopIndex > 0 && troopIndex <= troopTypes.length) {
            String troopType = troopTypes[troopIndex - 1];
            gameManager.getArmyManager().trainTroop(troopType, gameManager.getResourceManager());
        }
    }
}
