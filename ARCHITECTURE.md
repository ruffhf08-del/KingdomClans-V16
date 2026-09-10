# 🏗️ Kingdom Clans V16 - Architecture Document

## System Overview

```
┌─────────────────────────────────────────────────────────┐
│                   Game Loop (60 FPS)                     │
├─────────────────────────────────────────────────────────┤
│  Input → Update Logic → Render → Audio → Repeat         │
└─────────────────────────────────────────────────────────┘
         ↓
    ┌────────────────────────────────────────┐
    │        Game Manager (Core)             │
    │  - Initialize subsystems               │
    │  - Manage game states                  │
    │  - Handle main loop                    │
    └────────────────────────────────────────┘
         ↓
    ┌────────────────────────────────────────┐
    │      Managers (Subsystems)             │
    ├────────────────────────────────────────┤
    │ • ResourceManager    (Gold, Elixir)   │
    │ • BuildingManager    (Placement, Lvl) │
    │ • ArmyManager        (Training, Stats)│
    │ • BattleManager      (Combat Logic)   │
    │ • SaveManager        (Persistence)    │
    │ • NetworkManager     (Multiplayer)    │
    │ • UIManager          (Display)        │
    └────────────────────────────────────────┘
         ↓
    ┌────────────────────────────────────────┐
    │      Data Models (Game State)          │
    ├────────────────────────────────────────┤
    │ • Player (Level, XP, Trophies)        │
    │ • Village (Buildings, Layout)         │
    │ • Building (Type, Level, HP)          │
    │ • Troop (Type, Level, Stats)          │
    │ • Hero (Type, Level, Abilities)       │
    │ • Battle (Units, Damage, Report)      │
    └────────────────────────────────────────┘
         ↓
    ┌────────────────────────────────────────┐
    │      Persistence Layer                 │
    ├────────────────────────────────────────┤
    │ • SQLite Database (Local Save)        │
    │ • JSON Config Files                   │
    │ • Asset Loading (Images, Audio)       │
    └────────────────────────────────────────┘
```

---

## Core Components

### 1. Game Manager
Central controller managing all game systems.

```java
public class GameManager {
    private ResourceManager resourceManager;
    private BuildingManager buildingManager;
    private ArmyManager armyManager;
    private BattleManager battleManager;
    private SaveManager saveManager;
    private Village village;
    private Player player;
    
    public void update(float delta) {
        resourceManager.update(delta);
        buildingManager.update(delta);
        armyManager.update(delta);
        battleManager.update(delta);
    }
    
    public void render(Renderer renderer) {
        // Render all game elements
    }
}
```

### 2. Resource Manager
Handles all resources (Gold, Elixir, Dark Elixir).

```java
public class ResourceManager {
    private long gold;
    private long elixir;
    private long darkElixir;
    private Map<String, Building> generators;
    
    public void update(float delta) {
        // Update gold from Gold Mines
        // Update elixir from Elixir Collectors
        // Update dark elixir from DE drills
    }
    
    public boolean spend(ResourceType type, long amount) {
        if (getBalance(type) >= amount) {
            subtractResource(type, amount);
            return true;
        }
        return false;
    }
}
```

### 3. Building Manager
Manages all buildings - placement, upgrades, levels.

```java
public class BuildingManager {
    private List<Building> buildings;
    private Building[][] grid;
    private int maxX, maxY;
    
    public boolean placeBuilding(Building b, int x, int y) {
        if (isPositionValid(x, y)) {
            buildings.add(b);
            grid[x][y] = b;
            return true;
        }
        return false;
    }
    
    public void upgradeBuilding(Building b, ResourceManager rm) {
        if (rm.spend(b.getCostType(), b.getUpgradeCost())) {
            b.startUpgrade();
        }
    }
}
```

### 4. Army Manager
Manages troop training, heroes, and army composition.

```java
public class ArmyManager {
    private List<Troop> trainedTroops;
    private List<Hero> heroes;
    private int totalArmyCapacity;
    private Barracks barracks;
    private DarkBarracks darkBarracks;
    
    public void trainTroop(TroopType type) {
        Troop t = new Troop(type);
        barracks.addToQueue(t);
    }
    
    public int getCurrentArmyCapacity() {
        return trainedTroops.size();
    }
}
```

### 5. Battle Manager
Handles all battle logic and combat simulation.

```java
public class BattleManager {
    private Battle currentBattle;
    private BattleRenderer battleRenderer;
    
    public BattleReport startBattle(Village attacking, Village defending) {
        currentBattle = new Battle(attacking, defending);
        return simulate();
    }
    
    private BattleReport simulate() {
        // AI pathfinding
        // Damage calculation
        // Victory/Defeat logic
        return generateReport();
    }
}
```

### 6. Save Manager
Persists all game state to SQLite.

```java
public class SaveManager {
    private SQLiteDatabase db;
    
    public void save(Village village, Player player) {
        // Save village layout
        // Save player progress
        // Save all building/troop data
        // Timestamp for auto-save
    }
    
    public GameState load(int slotIndex) {
        // Load from database
        // Reconstruct village
        // Return complete game state
    }
}
```

### 7. Network Manager
Handles local multiplayer via Bluetooth/WiFi.

```java
public class NetworkManager {
    private BluetoothAdapter bluetoothAdapter;
    private NetworkSocket socket;
    
    public void connect(String deviceAddress) {
        // Establish Bluetooth connection
    }
    
    public void sendBattle(BattleData data) {
        // Serialize and send to opponent
    }
    
    public void receiveBattle(BattleData data) {
        // Process received battle
    }
}
```

---

## Data Models

### Village
```java
public class Village {
    private int villageId;
    private int ownerId;
    private String villageName;
    private int townHallLevel;
    private List<Building> buildings;
    private Map<Building, Upgrade> upgradesInProgress;
    private long gold, elixir, darkElixir;
}
```

### Building
```java
public class Building {
    private BuildingType type;
    private int level;
    private float x, y; // Position
    private float width, height; // Dimensions
    private int hitPoints;
    private int maxHitPoints;
    private long upgradeCost;
    private float upgradeTime;
    private Texture[] levelTextures; // Visual variants
}
```

### Troop
```java
public class Troop {
    private TroopType type;
    private int level;
    private int damage;
    private int hitPoints;
    private int trainingCost;
    private float trainingTime;
    private float moveSpeed;
    private float attackSpeed;
}
```

### Battle
```java
public class Battle {
    private Village attacker;
    private Village defender;
    private List<Unit> deployedUnits;
    private int totalDamage;
    private float battleTime;
    private BattleReport report;
}
```

---

## Game States

```
┌──────────┐
│  Menu    │
│  State   │
└────┬─────┘
     │
     ↓
┌──────────┐      ┌──────────┐
│ Village  │─────→│ Building │
│  State   │      │  State   │
└────┬─────┘      └──────────┘
     │
     ├────────────────┬──────────────┐
     ↓                ↓              ↓
┌──────────┐   ┌──────────┐   ┌──────────┐
│   Army   │   │  Battle  │   │   Shop   │
│  State   │   │  State   │   │  State   │
└──────────┘   └──────────┘   └──────────┘
     ↑                ↑              ↑
     └────────────────┴──────────────┘
              │
              ↓
        ┌──────────┐
        │ Pause    │
        │  State   │
        └──────────┘
```

---

## Rendering Pipeline

```
1. Clear Screen
   ↓
2. Draw Background
   ↓
3. Draw Terrain (Grass, Water)
   ↓
4. Draw Buildings (Sorted by Y)
   ↓
5. Draw Units (Troops, Heroes)
   ↓
6. Draw UI Elements
   ↓
7. Draw Particles/Effects
   ↓
8. Swap Buffers
```

---

## Upgrade Progression Formula

### Level Scaling
```
Base Stats × (1 + 0.1 × Level)

Example (Dragon):
- Level 1: 100 damage
- Level 2: 110 damage
- Level 3: 120 damage
```

### Cost Scaling
```
Base Cost × (1 + 0.15 × Level)

Example (Building):
- Level 1 Upgrade Cost: 1000 Gold
- Level 2 Upgrade Cost: 1150 Gold
- Level 3 Upgrade Cost: 1322 Gold
```

### Time Scaling
```
Base Time × (Level^1.5)

Example (Troop Training):
- Level 1: 30 seconds
- Level 2: 42 seconds
- Level 3: 52 seconds
```

---

## Database Schema

### Players Table
```sql
CREATE TABLE players (
    player_id INTEGER PRIMARY KEY,
    username TEXT,
    level INTEGER,
    xp INTEGER,
    trophies INTEGER,
    created_at TIMESTAMP,
    last_played TIMESTAMP
);
```

### Villages Table
```sql
CREATE TABLE villages (
    village_id INTEGER PRIMARY KEY,
    player_id INTEGER,
    name TEXT,
    town_hall_level INTEGER,
    gold INTEGER,
    elixir INTEGER,
    dark_elixir INTEGER,
    layout_data TEXT,
    FOREIGN KEY(player_id) REFERENCES players(player_id)
);
```

### Buildings Table
```sql
CREATE TABLE buildings (
    building_id INTEGER PRIMARY KEY,
    village_id INTEGER,
    type TEXT,
    level INTEGER,
    x FLOAT,
    y FLOAT,
    hp INTEGER,
    FOREIGN KEY(village_id) REFERENCES villages(village_id)
);
```

---

## Performance Optimization

### Rendering
- Use texture atlases for buildings
- Batch rendering with spritebatch
- Frustum culling for off-screen objects
- LOD (Level of Detail) for distant buildings

### Memory
- Object pooling for units
- Lazy loading of assets
- Efficient data structures (HashMap for quick lookup)
- Garbage collection tuning

### Network
- Delta compression for village updates
- Async message sending
- Connection pooling
- Retry mechanism with exponential backoff

---

## Extension Points

### Adding New Building Type
1. Add to BuildingType enum
2. Create building PNG assets
3. Add to BuildingFactory
4. Configure stats in JSON
5. Add unlock condition in TownHall progression

### Adding New Troop Type
1. Add to TroopType enum
2. Create troop sprite sheet
3. Define stats in JSON
4. Add to Barracks training
5. Configure spell interactions

### Adding New Feature
1. Create new Manager class
2. Register with GameManager
3. Add to save/load system
4. Create UI screens
5. Add tests

---

## Testing Strategy

### Unit Tests
- Resource calculations
- Building upgrades
- Troop stats
- Battle damage

### Integration Tests
- Village save/load
- Battle flow
- Network synchronization

### Performance Tests
- Frame rate with 100+ buildings
- Memory usage over 1 hour
- Multiplayer latency

---

## Security Considerations

### Cheat Prevention
- Local checksum validation
- Time-based verification
- Server-side validation (future)

### Data Protection
- SQLite encryption
- Secure save format
- Input validation

---

## Future Scalability

### Cloud Migration
- Move to Firebase/Firestore
- Implement server-side battle validation
- Global leaderboards
- Asynchronous multiplayer

### Platform Expansion
- PC version with Steam integration
- Console ports
- VR support

---

**This architecture is designed for scalability, maintainability, and extensibility.**
