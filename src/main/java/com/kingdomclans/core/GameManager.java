package com.kingdomclans.core;

import com.kingdomclans.managers.*;
import com.kingdomclans.models.*;
import java.util.List;

/**
 * Central Game Manager - Controls all game systems
 * Singleton pattern for global access
 */
public class GameManager {
    private static GameManager instance;
    
    private ResourceManager resourceManager;
    private BuildingManager buildingManager;
    private ArmyManager armyManager;
    private BattleManager battleManager;
    private SaveManager saveManager;
    private NetworkManager networkManager;
    private UIManager uiManager;
    
    private Village village;
    private Player player;
    private boolean isRunning;
    private float deltaTime;
    
    // Singleton
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    
    private GameManager() {}
    
    /**
     * Initialize all game systems
     */
    public void init(Object context) {
        System.out.println("🎮 Initializing Kingdom Clans V16...");
        
        // Load or create player
        saveManager = new SaveManager(context);
        player = saveManager.loadPlayer();
        if (player == null) {
            player = new Player();
            System.out.println("✨ New player created!");
        }
        
        // Load or create village
        village = saveManager.loadVillage();
        if (village == null) {
            village = new Village();
            village.setTownHallLevel(1);
            System.out.println("🏰 New village created!");
        }
        
        // Initialize managers
        resourceManager = new ResourceManager(village);
        buildingManager = new BuildingManager(village);
        armyManager = new ArmyManager(village);
        battleManager = new BattleManager();
        networkManager = new NetworkManager();
        uiManager = new UIManager();
        
        isRunning = true;
        System.out.println("✅ Game initialized successfully!");
    }
    
    /**
     * Main game loop - called every frame
     */
    public void update(float delta) {
        if (!isRunning) return;
        
        deltaTime = delta;
        
        // Update all systems
        resourceManager.update(delta);
        buildingManager.update(delta);
        armyManager.update(delta);
        battleManager.update(delta);
        
        // Auto-save every 30 seconds
        if ((int)(System.currentTimeMillis() / 1000) % 30 == 0) {
            saveManager.save(village, player);
        }
    }
    
    /**
     * Render all game elements
     */
    public void render() {
        if (!isRunning) return;
        
        // Render order: Background -> Buildings -> Units -> UI -> Effects
        uiManager.renderBackground();
        buildingManager.render();
        armyManager.render();
        uiManager.renderUI();
    }
    
    /**
     * Start attack
     */
    public BattleReport startBattle(Village enemyVillage) {
        System.out.println("⚔️ Battle started!");
        BattleReport report = battleManager.startBattle(village, enemyVillage);
        
        if (report.isVictory()) {
            // Reward player
            long loot = (long)(enemyVillage.getGold() * 0.5);
            resourceManager.addGold(loot);
            player.addTrophies(10);
            player.addXP(50);
        } else {
            player.addTrophies(-5);
        }
        
        return report;
    }
    
    /**
     * Pause game
     */
    public void pause() {
        isRunning = false;
        System.out.println("⏸️ Game paused");
    }
    
    /**
     * Resume game
     */
    public void resume() {
        isRunning = true;
        System.out.println("▶️ Game resumed");
    }
    
    /**
     * Dispose resources
     */
    public void dispose() {
        System.out.println("💾 Saving and disposing...");
        saveManager.save(village, player);
        resourceManager.dispose();
        buildingManager.dispose();
        armyManager.dispose();
        uiManager.dispose();
        System.out.println("✅ Game disposed");
    }
    
    // Getters
    public Village getVillage() { return village; }
    public Player getPlayer() { return player; }
    public ResourceManager getResourceManager() { return resourceManager; }
    public BuildingManager getBuildingManager() { return buildingManager; }
    public ArmyManager getArmyManager() { return armyManager; }
    public BattleManager getBattleManager() { return battleManager; }
    public float getDeltaTime() { return deltaTime; }
}
