# Ceiling Fan Simulation

## Overview

This project simulates a ceiling fan with adjustable speed and direction. The fan has four speed
settings (OFF=0, LOW=1, MEDIUM=2, HIGH=3) and two directions (CLOCKWISE, COUNTER_CLOCKWISE). It
demonstrates object-oriented programming principles and enum usage in Java.

## Requirements

- Java JDK 17 or higher
- Gradle 7.3 or higher

## Features

- Four-speed settings: OFF, LOW, MEDIUM, HIGH
- Two rotation directions: CLOCKWISE, COUNTER_CLOCKWISE
- Speed cord simulation to cycle through speeds
- Direction cord simulation to toggle direction
- Automatic cycling of speed and direction settings

## Project Structure

```
src/
├── main/
│ └── java/
│ └── com/
│ └── rkalbi/
│ ├── fan/
│ │ └── CeilingFan.java
│ └── Main.java
build.gradle.kts
```

## Classes

### CeilingFan

`CeilingFan` is the main class representing the ceiling fan. It includes:

- `Speed` enum: Represents the fan's speed settings
- `Direction` enum: Represents the fan's rotation direction
- Methods to simulate cord pulling and retrieve fan state

### Main

`Main` class demonstrates the usage of the `CeilingFan` class with various test scenarios.

## How to Run

1. Ensure you have Java JDK 8 or higher installed.
2. Clone the repository:
   ```
   git clone https://github.com/your-username/ceiling-fan-simulation.git
   ```
3. Navigate to the project directory:
   ```
   cd ceiling-fan-simulation
   ```
4. Build the project using Gradle:
   ```
   ./gradlew build
   ```
5. Run the main class:
   ```
   ./gradlew run
   ```
6. Run the tests:
   ```
   ./gradlew test
   ```

## Sample Output

```
Initial state: CeilingFan{speed=OFF, direction=CLOCKWISE}

Testing speed cord:
Current state: CeilingFan{speed=LOW, direction=CLOCKWISE}
Current state: CeilingFan{speed=MEDIUM, direction=CLOCKWISE}
Current state: CeilingFan{speed=HIGH, direction=CLOCKWISE}
Current state: CeilingFan{speed=OFF, direction=CLOCKWISE}

Testing direction cord:
Current state: CeilingFan{speed=OFF, direction=COUNTER_CLOCKWISE}
Current state: CeilingFan{speed=OFF, direction=CLOCKWISE}

Testing multiple speed cycles:
After 10 speed cord pulls: CeilingFan{speed=MEDIUM, direction=CLOCKWISE}
```

## Dependencies

- JUnit 5.10.0 for testing (configured in `build.gradle.kts`)

## Author

Ramesh Kalbi

## License

This project is open-source and available under
the [MIT License](https://opensource.org/licenses/MIT).