package com.kingdomclans.models;

/**
 * Hero model - legendary units with special abilities
 */
public class Hero {
    private String heroId;
    private String heroName;
    private int level;
    private int damage;
    private int hitPoints;
    private String ability;
    private long upgradeCost;
    private boolean isAlive;
    
    public Hero(String name, int level) {
        this.heroId = "hero_" + System.nanoTime();
        this.heroName = name;
        this.level = level;
        this.isAlive = true;
        calculateStats();
    }
    
    private void calculateStats() {
        switch (heroName) {
            case "Barbarian King":
                damage = 50 + (level * 10);
                hitPoints = 500 + (level * 50);
                ability = "Rage Mode";
                break;
            case "Archer Queen":
                damage = 40 + (level * 8);
                hitPoints = 400 + (level * 40);
                ability = "Multi-Shot";
                break;
            default:
                damage = 30;
                hitPoints = 300;
                ability = "Normal Attack";
        }
        upgradeCost = 50000 * level;
    }
    
    public void upgrade() {
        level++;
        calculateStats();
        System.out.println("⭐ " + heroName + " upgraded to level " + level);
    }
    
    public void activateAbility() {
        System.out.println("✨ " + heroName + " uses " + ability);
    }
    
    // Getters
    public String getHeroName() { return heroName; }
    public int getLevel() { return level; }
    public int getDamage() { return damage; }
    public int getHitPoints() { return hitPoints; }
    public String getAbility() { return ability; }
}
