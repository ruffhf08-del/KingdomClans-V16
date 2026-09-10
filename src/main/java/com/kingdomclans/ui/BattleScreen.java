package com.kingdomclans.ui;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.managers.BattleManager.BattleReport;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Battle Screen - Shows battle in progress and results
 */
public class BattleScreen {
    private GameManager gameManager;
    private BattleReport battleReport;
    private float battleTime;
    private boolean battleInProgress;
    
    public BattleScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        this.battleInProgress = false;
    }
    
    /**
     * Start new battle
     */
    public void startBattle(Village enemyVillage) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⚔️  BATTLE STARTED!");
        System.out.println("=".repeat(60));
        
        Village myVillage = gameManager.getVillage();
        System.out.println("\n🗡️  Attacker: " + gameManager.getPlayer().getPlayerName());
        System.out.println("🛡️  Defender: " + enemyVillage.getVillageName());
        
        battleReport = gameManager.getBattleManager().startBattle(myVillage, enemyVillage);
        battleInProgress = true;
        battleTime = 0;
        
        showBattleReport();
    }
    
    /**
     * Show battle results
     */
    public void showBattleReport() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("📊 BATTLE REPORT");
        System.out.println("-".repeat(60));
        
        if (battleReport.isVictory()) {
            System.out.println("\n✅ VICTORY! 🏆");
            System.out.println("⭐ Stars: " + battleReport.getStars() + "/3");
            System.out.println("💰 Loot: " + battleReport.getLoot() + " Gold");
            System.out.println("+10 Trophies");
        } else {
            System.out.println("\n❌ DEFEAT 😢");
            System.out.println("-5 Trophies");
        }
        
        System.out.println("\n" + "=".repeat(60));
        battleInProgress = false;
    }
    
    /**
     * Update battle
     */
    public void update(float delta) {
        if (battleInProgress) {
            battleTime += delta;
        }
    }
    
    public void render() {
        if (battleInProgress) {
            System.out.println("⚔️  Battle in progress... " + (int)battleTime + "s");
        }
    }
}
