package com.kingdomclans.managers;

import com.kingdomclans.models.*;
import java.util.*;

/**
 * Manages army training, troops, and heroes
 */
public class ArmyManager {
    private Village village;
    private List<Troop> trainedTroops;
    private List<Hero> heroes;
    private Queue<Troop> trainingQueue;
    private int totalArmyCapacity;
    private Troop currentTraining;
    private float trainingProgress;
    
    public ArmyManager(Village village) {
        this.village = village;
        this.trainedTroops = new ArrayList<>();
        this.heroes = new ArrayList<>();
        this.trainingQueue = new LinkedList<>();
        this.totalArmyCapacity = 100 + (village.getTownHallLevel() * 50);
        this.trainingProgress = 0.0f;
        initializeHeroes();
    }
    
    /**
     * Initialize heroes
     */
    private void initializeHeroes() {
        // Barbarian King
        Hero king = new Hero("Barbarian King", 1);
        heroes.add(king);
        
        // Archer Queen
        Hero queen = new Hero("Archer Queen", 1);
        heroes.add(queen);
        
        System.out.println("👑 Heroes initialized");
    }
    
    /**
     * Train a new troop
     */
    public void trainTroop(String troopType, ResourceManager rm) {
        Troop t = new Troop(troopType, 1);
        
        if (rm.spendElixir(t.getTrainingCost())) {
            trainingQueue.add(t);
            currentTraining = t;
            trainingProgress = 0.0f;
            System.out.println("🎖️ Training " + troopType);
        } else {
            System.out.println("❌ Insufficient elixir");
        }
    }
    
    /**
     * Update troop training
     */
    public void update(float delta) {
        if (currentTraining != null) {
            trainingProgress += delta;
            if (trainingProgress >= currentTraining.getTrainingTime()) {
                completeTraining();
            }
        }
    }
    
    /**
     * Complete training
     */
    private void completeTraining() {
        if (currentTraining != null) {
            if (trainedTroops.size() < totalArmyCapacity) {
                trainedTroops.add(currentTraining);
                System.out.println("✅ " + currentTraining.getType() + " trained!");
            }
            
            if (!trainingQueue.isEmpty()) {
                currentTraining = trainingQueue.poll();
                trainingProgress = 0.0f;
            } else {
                currentTraining = null;
            }
        }
    }
    
    public void render() {
        // Render all troops
        for (Troop t : trainedTroops) {
            // TODO: Render troop at position
        }
    }
    
    public void dispose() {}
    
    public List<Troop> getTroops() { return trainedTroops; }
    public List<Hero> getHeroes() { return heroes; }
    public int getArmyCapacity() { return totalArmyCapacity; }
    public int getCurrentArmySize() { return trainedTroops.size(); }
}
