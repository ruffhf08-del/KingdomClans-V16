# 🎮 Kingdom Clans V16 - Complete Strategy Game

<div align="center">

![Kingdom Clans](https://img.shields.io/badge/Version-1.0-blue)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow)
![License](https://img.shields.io/badge/License-MIT-green)
![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20iOS%20%7C%20Web-orange)

**A complete Clash of Clans-style offline strategy game with dragons, troops, village building, and epic battles!**

[Features](#-features) • [Installation](#-installation) • [Quick Start](#-quick-start) • [Documentation](#-documentation)

</div>

---

## 🎯 Features

### 🏰 Village Management
- **Isometric village view** with zoom & pan
- **30+ unique buildings** with multiple levels
- **Smart building placement** system
- **Visual upgrades** at each level
- **Auto-save system** every 30 seconds

### ⚔️ Army & Combat
- **15+ troop types** including dragons
- **4 legendary heroes** with unique abilities
- **Real-time battle system** with AI
- **Full battle reports** with damage breakdown
- **Loot & trophy system**

### 👑 Progression
- **14 Town Hall levels** to unlock
- **Research lab** for troop upgrades
- **Hero leveling** system
- **Daily missions** & achievements
- **World map exploration**

### 💰 Economy
- **3 resource types** (Gold, Elixir, Dark Elixir)
- **Auto-generation** from buildings
- **Smart resource management**
- **Shop system** with decorations

### 📱 Platforms
- ✅ **Android** (native support)
- ✅ **iOS** (native support)
- ✅ **Web Browser** (Libgdx + WebGL)
- ✅ **Offline First** (works without internet)
- ✅ **Local Multiplayer** (Bluetooth/WiFi)

---

## 📋 Quick Stats

| Feature | Details |
|---------|----------|
| Buildings | 30+ types with 10+ levels each |
| Troops | 15+ unit types |
| Heroes | 4 legendary heroes |
| Town Hall Levels | 14 levels of progression |
| Defenses | 12+ defensive buildings |
| Spells | Multiple spell types |
| Missions | 50+ quests & achievements |
| Save Slots | Multiple save support |

---

## 🚀 Installation

### Prerequisites
- Java 11+
- Android SDK (for mobile)
- Gradle 7.0+
- Git

### Clone & Setup

```bash
git clone https://github.com/ruffhf08-del/KingdomClans-V16.git
cd KingdomClans-V16

# Install dependencies
./gradlew build

# Run on Android
./gradlew installDebug

# Run on Desktop (Libgdx)
./gradlew desktop:run
```

---

## 🎮 Quick Start

### First Run
1. Start the game
2. Create new village
3. Complete tutorial missions
4. Build your first buildings
5. Generate resources
6. Unlock new buildings at Town Hall Level 2

### Game Loop
```
Collect Resources → Train Army → Attack Villages → Earn Loot → Upgrade Buildings
```

### Building Your Village
- Tap empty space to place buildings
- Buildings generate resources over time
- Upgrades take time (managed by builders)
- Unlock new buildings at higher Town Hall levels

### Attacking
1. Tap "Attack" button
2. Choose enemy village
3. Deploy troops on battlefield
4. Win battles to earn resources
5. View detailed battle report

---

## 📁 Project Structure

```
KingdomClans-V16/
├── core/                    # Game engine & logic
│   ├── GameManager.java     # Main game controller
│   ├── Village.java         # Village data model
│   ├── Building.java        # Building system
│   └── Battle.java          # Battle system
├── ui/                      # User interface
│   ├── VillageScreen.java   # Main village view
│   ├── BattleScreen.java    # Battle view
│   └── UIManager.java       # UI controller
├── models/                  # Game data models
│   ├── Player.java
│   ├── Troop.java
│   ├── Hero.java
│   └── Resource.java
├── managers/                # Game systems
│   ├── SaveManager.java     # Save/load
│   ├── ResourceManager.java # Resource system
│   ├── BattleManager.java   # Battle logic
│   └── NetworkManager.java  # Multiplayer
├── assets/                  # Game art & sounds
│   ├── graphics/
│   ├── audio/
│   └── data/
└── tests/                   # Unit tests
```

---

## 🔧 Configuration

### Game Settings (`config.json`)
```json
{
  "game": {
    "version": "1.0",
    "maxTownHallLevel": 14,
    "maxBuilders": 6,
    "autoSaveInterval": 30000
  },
  "graphics": {
    "resolution": "1920x1080",
    "particleEffects": true,
    "animationQuality": "high"
  },
  "gameplay": {
    "difficultyLevel": "normal",
    "enablePvP": true,
    "offlineMode": true
  }
}
```

---

## 📚 Documentation

- [Game Design Document](docs/FEATURES.md) - Complete feature list
- [Gameplay Guide](docs/GAMEPLAY.md) - How to play
- [Architecture](docs/ARCHITECTURE.md) - Technical details
- [API Reference](docs/API_REFERENCE.md) - Code documentation
- [Contributing Guide](CONTRIBUTING.md) - How to contribute

---

## 🎨 Art Style

- **Anime/Fantasy aesthetic**
- **Isometric perspective**
- **High-quality PNG assets**
- **Particle effects & animations**
- **Day/night cycle option**

---

## 🎵 Audio

- **Background music** - Epic fantasy themes
- **SFX** - Building sounds, battle effects
- **Notifications** - Resource collection, upgrade complete
- **Volume controls** - Adjustable in settings

---

## 🌐 Multiplayer

### Local Multiplayer
- **Bluetooth connection** for nearby players
- **WiFi Direct** for local network play
- **Asynchronous attacks** (attack saved villages)
- **PvP battle mode** (real-time battles)

### Future: Cloud Multiplayer
- Server-based matchmaking
- Global leaderboards
- Clan wars
- Cross-platform play

---

## 📊 Stats & Balance

### Resource Generation
- Gold Mine: +50/min per level
- Elixir: +40/min per level
- Dark Elixir: +5/min (high levels)

### Troop Costs
- Barbarian: 50 Gold
- Dragon: 200 Elixir (50 minutes)
- PEKKA: 300 Elixir (1 hour)

### Upgrade Time Formula
```
Time = 30 seconds × (Level²)
Cost = Base Cost × (Level × 1.1)
```

---

## 🐛 Known Issues

- [ ] Large village performance (50+ buildings)
- [ ] Multiplayer sync on poor connections
- [ ] Hero ability balance tweaks

See [Issues](https://github.com/ruffhf08-del/KingdomClans-V16/issues) for full list.

---

## 🤝 Contributing

Contributions are welcome! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for details.

### How to Contribute
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewFeature`)
3. Commit your changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## 📈 Roadmap

### Version 1.0 (Current)
- ✅ Core village system
- ✅ Building management
- ✅ Army training
- ✅ Battle system
- ✅ Offline save

### Version 1.1
- 🔄 Local multiplayer (Bluetooth)
- 🔄 World map exploration
- 🔄 Advanced missions

### Version 1.2
- 📅 Clan system
- 📅 Leaderboards
- 📅 Seasonal events

### Version 2.0
- 📅 Cloud save
- 📅 Global multiplayer
- 📅 Mobile optimization

---

## 📞 Support

- 📧 Email: support@kingdomclans.dev
- 🐛 Bug Reports: [GitHub Issues](https://github.com/ruffhf08-del/KingdomClans-V16/issues)
- 💬 Discussions: [GitHub Discussions](https://github.com/ruffhf08-del/KingdomClans-V16/discussions)

---

## 📄 License

This project is licensed under the **MIT License** - see [LICENSE](LICENSE) file for details.

---

## 🙏 Credits

- **Game Design** inspired by classic strategy games
- **Art Style** inspired by anime & fantasy games
- **Built with** Libgdx, Java, and passion ❤️

---

## ⭐ Show Your Support

If you like this project, please give it a star! ⭐

---

**Made with ❤️ by the Kingdom Clans Community**
