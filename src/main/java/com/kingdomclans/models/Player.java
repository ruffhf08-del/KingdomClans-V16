package com.kingdomclans.models;

/**
 * Player model - stores player progression data
 */
public class Player {
    private int playerId;
    private String playerName;
    private int level;
    private long xp;
    private long trophies;
    private int gems;
    private long gold;
    private long elixir;
    private long darkElixir;
    private int builderCount;
    private int maxBuilders;
    private long createdAt;
    private long lastPlayedAt;
    
    public Player() {
        this.playerId = (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
        this.playerName = "Player" + playerId;
        this.level = 1;
        this.xp = 0;
        this.trophies = 0;
        this.gems = 500; // Starting gems
        this.gold = 1000; // Starting resources
        this.elixir = 1000;
        this.darkElixir = 0;
        this.builderCount = 1; // Start with 1 builder
        this.maxBuilders = 6;
        this.createdAt = System.currentTimeMillis();
        this.lastPlayedAt = System.currentTimeMillis();
    }
    
    // Add XP and level up
    public void addXP(long amount) {
        this.xp += amount;
        checkLevelUp();
    }
    
    private void checkLevelUp() {
        long requiredXP = this.level * 500L; // Scale by level
        if (this.xp >= requiredXP) {
            this.xp -= requiredXP;
            this.level++;
            this.gems += 50; // Reward gems on level up
            System.out.println("⭐ Leveled up to " + level);
        }
    }
    
    // Add/subtract trophies
    public void addTrophies(int amount) {
        this.trophies += amount;
        if (this.trophies < 0) this.trophies = 0;
    }
    
    // Getters and Setters
    public int getPlayerId() { return playerId; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String name) { this.playerName = name; }
    
    public int getLevel() { return level; }
    public long getXP() { return xp; }
    public long getTrophies() { return trophies; }
    public int getGems() { return gems; }
    
    public long getGold() { return gold; }
    public void setGold(long gold) { this.gold = Math.max(0, gold); }
    
    public long getElixir() { return elixir; }
    public void setElixir(long elixir) { this.elixir = Math.max(0, elixir); }
    
    public long getDarkElixir() { return darkElixir; }
    public void setDarkElixir(long de) { this.darkElixir = Math.max(0, de); }
    
    public int getBuilderCount() { return builderCount; }
    public void unlockBuilder() {
        if (builderCount < maxBuilders) builderCount++;
    }
    
    @Override
    public String toString() {
        return String.format("Player{name='%s', level=%d, trophies=%d, gold=%d, elixir=%d}",
            playerName, level, trophies, gold, elixir);
    }
}
