package com.kingdomclans.game;

import com.kingdomclans.core.GameManager;
import com.kingdomclans.ui.*;
import com.kingdomclans.models.*;
import java.util.Scanner;

/**
 * Main Game Loop - Console version for testing
 */
public class GameLoop {
    private GameManager gameManager;
    private VillageScreen villageScreen;
    private BattleScreen battleScreen;
    private ArmyScreen armyScreen;
    private ResearchScreen researchScreen;
    private ShopScreen shopScreen;
    private Scanner scanner;
    private boolean isRunning;
    private int currentScreen; // 0=Village, 1=Battle, 2=Army, 3=Research, 4=Shop
    
    public GameLoop() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Initialize game
     */
    public void init() {
        System.out.println("\n🎮 Initializing Kingdom Clans V16...");
        
        gameManager = GameManager.getInstance();
        gameManager.init(null);
        
        villageScreen = new VillageScreen(gameManager, 1920, 1080);
        battleScreen = new BattleScreen(gameManager);
        armyScreen = new ArmyScreen(gameManager);
        researchScreen = new ResearchScreen(gameManager);
        shopScreen = new ShopScreen(gameManager);
        
        isRunning = true;
        currentScreen = 0;
        
        System.out.println("✅ Game initialized!");
        showMainMenu();
    }
    
    /**
     * Main game loop
     */
    public void run() {
        init();
        
        long lastTime = System.currentTimeMillis();
        
        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            float deltaTime = (currentTime - lastTime) / 1000.0f;
            lastTime = currentTime;
            
            // Update game logic
            gameManager.update(deltaTime);
            
            // Render
            renderCurrentScreen();
            
            // Handle input
            handleInput();
            
            try {
                Thread.sleep(100); // 10 FPS for console
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        shutdown();
    }
    
    /**
     * Render current screen
     */
    private void renderCurrentScreen() {
        switch (currentScreen) {
            case 0:
                villageScreen.render();
                break;
            case 1:
                battleScreen.render();
                break;
            case 2:
                armyScreen.showArmy();
                break;
            case 3:
                researchScreen.showResearch();
                break;
            case 4:
                shopScreen.showShop();
                break;
        }
    }
    
    /**
     * Show main menu
     */
    private void showMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎮 KINGDOM CLANS V16 - MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("[1] Village");
        System.out.println("[2] Attack");
        System.out.println("[3] Army");
        System.out.println("[4] Research");
        System.out.println("[5] Shop");
        System.out.println("[0] Exit");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Handle user input
     */
    private void handleInput() {
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) return;
            
            try {
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        currentScreen = 0;
                        break;
                    case 2:
                        startBattle();
                        break;
                    case 3:
                        currentScreen = 2;
                        break;
                    case 4:
                        currentScreen = 3;
                        break;
                    case 5:
                        currentScreen = 4;
                        break;
                    case 0:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }
    
    /**
     * Start battle with random village
     */
    private void startBattle() {
        System.out.println("\n🎯 Preparing battle...");
        
        // Create random enemy village
        Village enemyVillage = new Village();
        enemyVillage.setVillageName("Enemy Village #" + (int)(Math.random() * 1000));
        
        currentScreen = 1;
        battleScreen.startBattle(enemyVillage);
    }
    
    /**
     * Shutdown game
     */
    public void shutdown() {
        System.out.println("\n👋 Shutting down game...");
        gameManager.dispose();
        scanner.close();
        System.out.println("✅ Game closed");
    }
    
    /**
     * Main entry point
     */
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.run();
    }
}
