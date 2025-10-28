# ⌛ Zaun Adventure

<div align="center">

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue.svg)](https://maven.apache.org/)
[![JLine](https://img.shields.io/badge/JLine-3.26.2-green.svg)](https://github.com/jline/jline3)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

*A terminal-based adventure game inspired by the League of Legends universe*

[Features](#-features) • [Installation](#-installation) • [How to Play](#-how-to-play) • [Architecture](#-architecture) • [Development](#-development)

</div>

---

## 📖 Overview

**Zaun Adventure** is a roguelike terminal game set in the gritty undercity of Zaun from the League of Legends universe. Play as Ekko, the Boy Who Shattered Time, and navigate through dangerous territories filled with Piltover guards and other enemies.

The game features a clean, single-frame rendering system powered by JLine3, providing a smooth and responsive gameplay experience directly in your terminal.

## ✨ Features

### 🎮 Gameplay
- **Real-time Movement**: WASD controls with instant response (no Enter key needed)
- **Combat System**: Multiple attack types (basic, middle, and ultimate attacks)
- **Character Abilities**: Unique player abilities including protection and dodge mechanics
- **Enemy AI**: Different AI behaviors (passive, aggressive, boss phases)
- **Map Exploration**: Navigate through procedurally generated maps

### 🔧 Technical Features
- **Single-Frame Rendering**: Smooth display updates using JLine3
- **Clean Terminal Interface**: No screen clutter or flickering
- **Save System**: Save and load game progress
- **Modular Architecture**: Clean separation of concerns with MVC-like pattern
- **Hextech Weapons System**: Multiple weapon types including melee, distance, and hextech arms

### 🗡️ Weapon Types
- **Melee Weapons**: Sword and close-range combat
- **Distance Weapons**: Pistol and PowPow minigun
- **Hextech Weapons**: Fishbone rocket launcher, Gauntlet, and Hextech Rifle

## 🚀 Installation

### Prerequisites
- **Java 17** or higher
- **Maven 3.9+**
- Terminal with UTF-8 support

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/RodrigoAlexander7/terminal-game.git
   cd terminal-game/zaun-adventure
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the game**
   ```bash
   mvn exec:java
   ```

## 🎯 How to Play

### Main Menu
When you start the game, you'll see the Zaun Adventure title screen with ASCII art.

**Commands:**
- Type `start` to begin your adventure
- Type `exit` to quit the game

### In-Game Controls

| Key | Action |
|-----|--------|
| `W` | Move Up |
| `S` | Move Down |
| `A` | Move Left |
| `D` | Move Right |
| `Q` | Quit to Menu |
| `ESC` | Quit to Menu |

### Game Elements

```
⌛ - Ekko (Player)
🛡️ - Piltover Guard (Enemy)
# - Wall
. - Floor
```

### Game Stats
During gameplay, you'll see:
- **Position**: Your current coordinates
- **Life**: Current health points
- **Power**: Available power for abilities

## 🏗️ Architecture

The project follows a clean, modular architecture:

```
zaun-adventure/
├── src/main/java/com/zaund/
│   ├── combat/          # Combat system
│   │   ├── arm/         # Weapon types
│   │   │   ├── melee/
│   │   │   ├── distance/
│   │   │   └── hextech/
│   │   └── atack/       # Attack implementations
│   ├── entity/          # Game entities
│   │   ├── character/   # Player characters
│   │   │   └── enemies/ # Enemy types
│   │   └── ai/          # AI behaviors
│   ├── game/            # Game core
│   │   ├── Game.java
│   │   ├── GameController.java
│   │   ├── GameState.java
│   │   └── GameLogger.java
│   ├── io/              # Input/Output
│   │   ├── ConsoleRenderer.java
│   │   ├── InputHandler.java
│   │   ├── Menu.java
│   │   └── SaveSystem.java
│   ├── map/             # Map generation
│   │   ├── Map.java
│   │   ├── MapGenerator.java
│   │   ├── Position.java
│   │   └── Tile.java
│   ├── system/          # Game systems
│   │   ├── MenuSystem.java
│   │   └── MovementSystem.java
│   └── util/            # Utilities
│       ├── Config.java
│       └── RandomUtils.java
└── src/main/resources/
    ├── config.properties
    ├── maps/
    └── saves/
```

### Key Components

#### 🎮 Game Controller (`GameController.java`)
Central game loop managing:
- Game state transitions (Menu → Exploring → Battle → Game Over)
- Player input processing
- Game rendering coordination
- Terminal cleanup on exit

#### 🖥️ Console Renderer (`ConsoleRenderer.java`)
Handles all terminal rendering:
- Single-frame rendering using JLine3
- Screen clearing and cursor positioning
- Map and entity visualization
- Player stats display

#### 🕹️ Input Handler (`InputHandler.java`)
Manages player input:
- Raw mode terminal input
- Instant character reading (no Enter needed)
- Command parsing and validation

#### 🗺️ Map System
- `Map.java`: Core map data structure
- `MapGenerator.java`: Procedural map generation
- `Tile.java`: Individual tile properties

#### ⚔️ Combat System
- Multiple weapon types with unique characteristics
- Attack strategies (Melee, Distance, Hextech)
- Damage calculation and status effects

#### 🤖 AI System
- `AIPassive`: Doesn't attack unless provoked
- `AIAggressive`: Actively seeks and attacks player
- `AIBossPhase`: Complex multi-phase behavior

## 🛠️ Development

### Project Structure

The game uses **Maven** for dependency management and **JLine3** for terminal manipulation.

### Dependencies

```xml
<dependency>
    <groupId>org.jline</groupId>
    <artifactId>jline</artifactId>
    <version>3.26.2</version>
</dependency>
```

### Building

```bash
# Clean build
mvn clean

# Compile
mvn compile

# Run tests (if available)
mvn test

# Package
mvn package

# Run
mvn exec:java
```

### Configuration

Edit `src/main/resources/config.properties` to customize:
- Game difficulty
- Map dimensions
- Enemy spawn rates
- Player starting stats

### Adding New Enemies

1. Create a new class extending `Enemy` in `com.zaund.entity.character.enemies`
2. Implement `basicAtack(Player player)` method
3. Define stats (LIFE_POINTS, BASIC_ATACK_POWER, RENDER_SYMBOL)
4. Add to map generation logic

### Adding New Weapons

1. Create weapon class in appropriate package (`melee`, `distance`, or `hextech`)
2. Extend `Arm` abstract class
3. Implement attack methods
4. Define weapon stats and characteristics

## 🎨 Terminal Requirements

### Recommended Terminals
- ✅ **Windows Terminal** (Recommended for Windows)
- ✅ **PowerShell** 7+
- ✅ **Git Bash**
- ✅ **WSL** (Ubuntu/Debian)
- ✅ **iTerm2** (macOS)
- ✅ **GNOME Terminal** (Linux)

### Font Requirements
For best experience, use a terminal with:
- UTF-8 encoding support
- Monospaced font with emoji support (e.g., Cascadia Code, Fira Code)
- ANSI escape sequence support

## 🔧 Troubleshooting

### Game doesn't display correctly
- Ensure your terminal supports UTF-8 encoding
- Try running with: `mvn exec:java -Dfile.encoding=UTF-8`
- Use Windows Terminal instead of CMD on Windows

### Input not responding
- Make sure no other terminal applications are running
- The game uses raw mode; if it crashes, restart your terminal

### Terminal stays in raw mode after crash
```bash
# Reset terminal (Linux/Mac)
reset

# PowerShell (Windows)
# Just close and reopen the terminal
```

## 🗺️ Roadmap

- [ ] Implement full combat system with all attack types
- [ ] Add more enemy types and bosses
- [ ] Create multiple levels/zones
- [ ] Implement inventory system
- [ ] Add equipment and upgrades
- [ ] Implement save/load functionality
- [ ] Add sound effects (ASCII-based)
- [ ] Multiplayer support
- [ ] Achievement system
- [ ] Procedural dungeon generation

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Coding Standards
- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Keep methods focused and concise
- Write meaningful commit messages

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👏 Acknowledgments

- Inspired by **League of Legends** universe created by Riot Games
- Built with **JLine3** for terminal manipulation
- ASCII art generated with various online tools
- Special thanks to the Java terminal game development community

## 📧 Contact

**Rodrigo Alexander** - [@RodrigoAlexander7](https://github.com/RodrigoAlexander7)

Project Link: [https://github.com/RodrigoAlexander7/terminal-game](https://github.com/RodrigoAlexander7/terminal-game)

---

<div align="center">

Made with ❤️ and ☕ by Rodrigo Alexander

⭐ Star this repository if you enjoyed playing!

</div>
