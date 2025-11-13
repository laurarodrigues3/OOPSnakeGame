# Snake Game - University Project

A complete Snake game developed in Java with graphical interface, ranking system, multiple game modes, and customizable settings. This project was developed as part of a university Object-Oriented Programming course.

## Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Requirements](#requirements)
- [Installation and Execution](#installation-and-execution)
- [How to Play](#how-to-play)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Authors](#authors)

## About the Project

This is a complete Snake game developed in Java using Swing for the graphical interface. The project demonstrates advanced Object-Oriented Programming concepts, including inheritance, polymorphism, interfaces, and design patterns. The game offers a complete experience with an interactive menu, scoring system, persistent ranking, and multiple customization options.

## Features

### Game Modes
- **Manual Mode**: Control the snake using keyboard arrows (↑ ↓ ← →)
- **Automatic Mode 1**: The snake moves automatically towards food using a simple coordinate-based algorithm
- **Automatic Mode 2**: More sophisticated algorithm that calculates the distance to food in all possible directions and chooses the shortest path

### Customizable Settings
- **Difficulty**: 
  - Easy (speed: 300ms)
  - Medium (speed: 240ms)
  - Hard (speed: 180ms)
- **Snake Size**: 
  - 1x1 (small)
  - 2x2 (medium)
  - 3x3 (large)
- **Arena Size**: 
  - 50x50 (small)
  - 60x60 (medium)
  - 70x70 (large)

### Game Features
- **Dynamic Obstacles**: Obstacles that rotate during gameplay (depending on difficulty)
- **Varied Food**: Food can appear as circles or squares
- **Scoring System**: Points increase when eating food
- **Persistent Ranking**: Ranking system that saves the best players to a file
- **Background Music**: Soundtrack during gameplay
- **Visual Interface**: Visual grid, different colors for snake, food, and obstacles

### Ranking System
- View top players
- Data persistence in file
- Automatic sorting by score

## Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**: Windows, Linux, or macOS
- **Audio File**: `Snake3Music.wav` (already included in the project)

## Installation and Execution

### Method 1: Manual Compilation

1. **Clone or download the repository**
   ```bash
   git clone <repository-url>
   cd snakeGame
   ```

2. **Compile all Java files (excluding tests)**
   
   **Windows (PowerShell):**
   ```powershell
   javac -d out (Get-ChildItem src\*.java | Where-Object { $_.Name -notlike '*Test.java' } | ForEach-Object { $_.FullName })
   ```
   
   **Windows (CMD) / Linux / macOS:**
   ```bash
   javac -d out src/Arena.java src/Circulo.java src/Comida.java src/ComidaCirculo.java src/ComidaQuadrado.java src/Jogador.java src/Jogo.java src/Main.java src/Menu.java src/MovimentoAutomatico.java src/MovimentoAutomatico2.java src/MovimentoDinamico.java src/MovimentoObstaculo.java src/MovimentoSnake.java src/MusicaJogo.java src/Obstaculo.java src/Poligono.java src/Ponto.java src/Quadrado.java src/Ranking.java src/Reta.java src/Retangulo.java src/SegmentoReta.java src/Settings.java src/Snake.java src/Triangulo.java
   ```
   
   **Alternative (compile in current directory):**
   ```bash
   javac src/Arena.java src/Circulo.java src/Comida.java src/ComidaCirculo.java src/ComidaQuadrado.java src/Jogador.java src/Jogo.java src/Main.java src/Menu.java src/MovimentoAutomatico.java src/MovimentoAutomatico2.java src/MovimentoDinamico.java src/MovimentoObstaculo.java src/MovimentoSnake.java src/MusicaJogo.java src/Obstaculo.java src/Poligono.java src/Ponto.java src/Quadrado.java src/Ranking.java src/Reta.java src/Retangulo.java src/SegmentoReta.java src/Settings.java src/Snake.java src/Triangulo.java
   ```

3. **Run the game**
   
   If compiled with `-d out`:
   ```bash
   java -cp out Main
   ```
   
   If compiled in current directory:
   ```bash
   java -cp src Main
   ```
   
   **Important**: Make sure the `Snake3Music.wav` file is in the same directory where you run the `java` command.

### Method 2: Using IDE (IntelliJ IDEA, Eclipse, etc.)

1. Open the project in your preferred IDE
2. Make sure the `Snake3Music.wav` file is in the project root
3. Configure the `src` directory as source root
4. Run the `Main.java` class

### Important Note

- Make sure the `Snake3Music.wav` file is in the same directory where you run the `java` command, or adjust the path in the code if necessary.
- Test files (`*Test.java`) require JUnit 5 for compilation. They are not necessary to run the game, only to run unit tests.

## How to Play

### Starting the Game

1. Run the program (see [Installation and Execution](#installation-and-execution) section)
2. The main menu will be displayed with three options:
   - **PLAY**: Starts a new game
   - **RANKING**: Views the ranking of best players
   - **EXIT**: Closes the game

### Configuring a Game

When clicking **PLAY**, you will be directed to the settings screen:

1. **Player Name**: 
   - Enter your name in the text field
   - Click **ENTER** to confirm

2. **Difficulty**: 
   - Choose between **EASY**, **MEDIUM**, or **HARD**
   - Difficulty affects snake speed and number of obstacles

3. **Snake Size**: 
   - Choose between **1x1**, **2x2**, or **3x3**
   - Affects the initial snake size

4. **Snake Movement**: 
   - **MANUAL**: You control with keyboard arrows
   - **AUTOMATIC 1**: Simple automatic movement
   - **AUTOMATIC 2**: Alternative automatic movement

5. **Arena Size**: 
   - Choose between **50x50**, **60x60**, or **70x70**

6. Click **START** to begin the game

### Controls (Manual Mode)

- **↑ (Up Arrow)**: Moves the snake up
- **↓ (Down Arrow)**: Moves the snake down
- **← (Left Arrow)**: Moves the snake left
- **→ (Right Arrow)**: Moves the snake right

### Game Objective

- **Eat the food** (red circles or squares) to increase your score
- **Avoid colliding** with:
  - Arena walls
  - Your own body (tail)
  - Purple obstacles
- **Increase your score** as much as possible!

### Game Over

The game ends when the snake collides with:
- Arena borders
- Its own body
- An obstacle

Your score will be automatically saved to the ranking if you are among the best players.

### Viewing the Ranking

1. In the main menu, click **RANKING**
2. Enter the number of players you want to view
3. Click **ENTER**
4. The ranking will be displayed sorted by score (highest to lowest)

## Project Structure

```
snakeGame/
│
├── src/
│   │
│   ├── Core Game Classes
│   │   ├── Main.java                 # Application entry point
│   │   ├── Jogo.java                 # Main game controller
│   │   ├── Arena.java                # Game arena and rendering
│   │   ├── Snake.java                # Snake entity and behavior
│   │   ├── Obstaculo.java            # Obstacle entity
│   │   └── Jogador.java              # Player data model
│   │
│   ├── Food System
│   │   ├── Comida.java               # Abstract food class
│   │   ├── ComidaCirculo.java        # Circle food implementation
│   │   └── ComidaQuadrado.java       # Square food implementation
│   │
│   ├── Movement System
│   │   ├── MovimentoSnake.java       # Snake movement interface
│   │   ├── MovimentoDinamico.java    # Manual movement implementation
│   │   ├── MovimentoAutomatico.java  # Automatic movement algorithm 1
│   │   ├── MovimentoAutomatico2.java # Automatic movement algorithm 2
│   │   └── MovimentoObstaculo.java   # Obstacle movement interface
│   │
│   ├── UI Components
│   │   ├── Menu.java                 # Main menu interface
│   │   └── Settings.java             # Game settings interface
│   │
│   ├── Game Services
│   │   ├── Ranking.java              # Ranking system and persistence
│   │   └── MusicaJogo.java           # Audio playback service
│   │
│   ├── Geometry Library
│   │   ├── Ponto.java                # 2D point representation
│   │   ├── Poligono.java             # Base polygon class
│   │   ├── Quadrado.java             # Square implementation
│   │   ├── Circulo.java              # Circle implementation
│   │   ├── Retangulo.java            # Rectangle implementation
│   │   ├── Triangulo.java            # Triangle implementation
│   │   ├── Reta.java                 # Line representation
│   │   └── SegmentoReta.java         # Line segment implementation
│   │
│   └── Tests
│       ├── PontoTest.java
│       ├── QuadradoTest.java
│       ├── RetanguloTest.java
│       ├── SegmentoRetaTest.java
│       ├── SnakeTest.java
│       ├── TrianguloTest.java
│       └── PoligonoTest.java
│
├── Snake3Music.wav                   # Background music file
├── .gitignore                        # Git ignore rules
└── README.md                         # Project documentation
```

## Technologies Used

- **Java**: Main programming language
- **Java Swing**: Framework for graphical interface
- **Java AWT**: Library for 2D graphics
- **Java Sound API**: Audio playback
- **Java Serialization**: Ranking persistence

### OOP Concepts Applied

- **Inheritance**: Geometric shape classes, food types
- **Polymorphism**: Different movement types, different food shapes
- **Interfaces**: `MovimentoSnake`, `MovimentoObstaculo`
- **Encapsulation**: Private attributes with access methods
- **Abstraction**: Abstract classes like `Comida` and `Poligono`
- **Composition**: Arena contains Snake, Food, Obstacles
- **Design Patterns**: Strategy (movements), Factory (food)

---

## Additional Notes

- The ranking file (`snake`) is created automatically on first run
- Background music plays in continuous loop during gameplay
- Dynamic obstacles rotate automatically during gameplay
- The game was developed as an academic project to demonstrate Object-Oriented Programming concepts

## Running Tests

The project includes unit tests using JUnit 5. To run them:

1. **Add JUnit 5 to classpath**:
   - Download JUnit 5 (Jupiter) from [junit.org](https://junit.org/junit5/)
   - Add the JARs to the project classpath

2. **Run tests in your IDE**:
   - IntelliJ IDEA: Right-click on `src` folder → "Run All Tests"
   - Eclipse: Right-click on project → "Run As" → "JUnit Test"

3. **Or compile and run manually** (after adding JUnit to classpath):
   ```bash
   javac -cp ".:junit-platform-console-standalone-1.x.x.jar" src/*.java
   java -cp ".:junit-platform-console-standalone-1.x.x.jar" org.junit.platform.console.ConsoleLauncher --class-path src --scan-class-path
   ```

**Note**: Tests are not necessary to run the game, only to verify the correctness of geometric classes and game logic.

## Troubleshooting

### Problem: "Audio file not found"
**Solution**: Make sure the `Snake3Music.wav` file is in the same directory where you run the program, or in the project root.

### Problem: "Compilation error"
**Solution**: 
- Verify that all classes are in the `src/` directory
- Make sure you are using JDK 8 or higher
- If compiling all files including tests, exclude `*Test.java` files or add JUnit 5 to classpath

### Problem: "Window does not appear"
**Solution**: Make sure you are running the `Main` class and not another project class.

### Problem: "Error loading ranking"
**Solution**: The ranking file will be created automatically on first run. Make sure the program has write permissions in the directory where it is being executed.

---

**Developed for educational purposes**
