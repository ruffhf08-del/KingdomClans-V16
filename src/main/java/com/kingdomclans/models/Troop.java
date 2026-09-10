package com.kingdomclans.models;

/**
 * Troop model - represents a single troop unit
 */
public class Troop {
    private String troopId;
    private String type; // BARBARIAN, ARCHER, DRAGON, etc.
    private int level;
    private int damage;
    private int hitPoints;
    private float moveSpeed;
    private float attackSpeed;
    private int trainingCost;
    private float trainingTime;
    private float x, y; // Current position
    private boolean isAlive;
    
    public Troop(String type, int level) {
        this.troopId = "troop_" + System.nanoTime();
        this.type = type;
        this.level = level;
        this.isAlive = true;
        calculateStats();
    }
    
    /**
     * Calculate troop stats based on type and level
     */
    private void calculateStats() {
        switch (type) {
            case "BARBARIAN":
                damage = 10 + (level * 2);
                hitPoints = 30 + (level * 5);
                moveSpeed = 1.5f;
                attackSpeed = 0.8f;
                trainingCost = 50;
                trainingTime = 5;
                break;
                
            case "ARCHER":
                damage = 8 + (level * 2);
                hitPoints = 20 + (level * 3);
                moveSpeed = 1.2f;
                attackSpeed = 1.0f;
                trainingCost = 75;
                trainingTime = 8;
                break;
                
            case "DRAGON":
                damage = 50 + (level * 10);
                hitPoints = 200 + (level * 30);
                moveSpeed = 2.0f;
                attackSpeed = 1.5f;
                trainingCost = 200;
                trainingTime = 1800; // 30 minutes
                break;
                
            case "GIANT":
                damage = 25 + (level * 5);
                hitPoints = 150 + (level * 25);
                moveSpeed = 0.8f;
                attackSpeed = 0.5f;
                trainingCost = 100;
                trainingTime = 15;
                break;
                
            default:
                damage = 10;
                hitPoints = 50;
                moveSpeed = 1.0f;
                attackSpeed = 1.0f;
                trainingCost = 50;
                trainingTime = 10;
        }
    }
    
    /**
     * Attack target
     */
    public void attack(Building target) {
        if (isAlive && target != null) {
            target.takeDamage(damage);
            System.out.println(type + " dealt " + damage + " damage");
        }
    }
    
    /**
     * Take damage
     */
    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            isAlive = false;
            System.out.println(type + " defeated!");
        }
    }
    
    // Getters and Setters
    public String getTroopId() { return troopId; }
    public String getType() { return type; }
    public int getLevel() { return level; }
    public int getDamage() { return damage; }
    public int getHitPoints() { return hitPoints; }
    public float getMoveSpeed() { return moveSpeed; }
    public float getAttackSpeed() { return attackSpeed; }
    public int getTrainingCost() { return trainingCost; }
    public float getTrainingTime() { return trainingTime; }
    public boolean isAlive() { return isAlive; }
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    
    @Override
    public String toString() {
        return String.format("Troop{type='%s', level=%d, damage=%d, hp=%d}",
            type, level, damage, hitPoints);
    }
}
