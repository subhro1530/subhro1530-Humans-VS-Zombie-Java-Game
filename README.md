# Humans-VS-Zombie-Java-Game
The provided Java implementation simulates the dynamics of a hypothetical scenario involving humans and zombies based on differential equations representing the rate of change in their populations. Here's a detailed description of the simulation process and the key components of the implementation:

### Simulation Description:

1. **Population Dynamics**:
   - The simulation involves two groups: humans (`H`) and zombies (`Z`).
   - The populations of humans (`H`) and zombies (`Z`) change over time (`t`) based on specified kill rates (`λ_H` for humans and `λ_Z` for zombies).

2. **Differential Equations**:
   - The rate of change in the number of humans (`dH/dt`) is given by:
     \[ \frac{dH}{dt} = -\lambda_Z \times Z \]
     This equation represents the decrease in the human population due to zombie attacks (`λ_Z` is the kill rate of zombies).
   
   - The rate of change in the number of zombies (`dZ/dt`) is given by:
     \[ \frac{dZ}{dt} = -\lambda_H \times H \]
     This equation represents the decrease in the zombie population due to human attacks (`λ_H` is the kill rate of humans).

3. **Numerical Integration**:
   - The simulation uses a numerical integration approach (Euler's method) to approximate the solution of the differential equations.
   - The `simulate()` method iterates over time (`t`) in small increments (`dt`) to update the populations of humans and zombies based on the differential equations.

4. **Simulation Loop**:
   - Within the `simulate()` method:
     - Compute the kills inflicted by zombies on humans (`killsByZombies`) and by humans on zombies (`killsByHumans`) at each time step.
     - Update the populations of humans and zombies using the `iterate()` method of the `Player` class, which simulates the decrease in population due to the calculated kills.
     - Store the current state (time, number of humans, number of zombies) in the `results` list for later analysis or output.

5. **Result Storage**:
   - Simulation results (time, number of humans, number of zombies) are stored in the `results` list during the simulation.
   - After the simulation completes, the `saveResultsToCSV()` method is called to write the simulation results to a CSV file (`game_results.csv`), where each row represents a time point with the corresponding populations of humans and zombies.

### Key Components of the Implementation:

- **Player Class**:
  - Represents a group (humans or zombies) with attributes for population count (`n`), kill rate (`killRate`), and name (`name`).
  - Provides methods to retrieve population count, kill rate, update population based on kills (`iterate()`), and check if the group is alive (`isAlive()`).

- **Game Class**:
  - Manages the simulation process by initializing populations of humans and zombies, running the simulation (`simulate()`), and saving the results to a CSV file (`saveResultsToCSV()`).
  - Uses numerical methods to compute the dynamics of population change based on the specified differential equations.

- **Simulation Workflow**:
  - The `Main` class serves as the entry point, where simulation parameters (initial populations, kill rates) are set, and the simulation is initiated by calling methods from the `Game` class.

This simulation framework provides a basic model for exploring the dynamics between humans and zombies over time, demonstrating how to apply numerical methods and object-oriented programming concepts in Java to solve differential equations and simulate population dynamics in a controlled environment. Adjustments and enhancements can be made to this framework to further refine the simulation or explore different scenarios.
