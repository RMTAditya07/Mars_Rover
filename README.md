# Mars_Rover

## Problem_Statement
- Create a simulation for a Mars Rover that can navigate a grid-based terrain. 
- Your Rover should be able to move forward, turn left, and turn
right. 
- You'll need to make sure that it avoids obstacles and stays within the boundaries of the grid. 
- Remember to use pure Object-Oriented
Programming, design patterns, and avoid using if-else conditional constructs.

## Functional Requirements
1. Initialize the Rover with a starting position (x, y) and direction (N, S, E, W).
2. Implement the following commands:
'M' for moving one step forward in the direction the rover is facing
'L' for turning left
'R' for turning right
3. Implement obstacle detection. If an obstacle is detected in the path, the Rover should not move.
4. Optional: Add functionality for the Rover to send a status report containing its current position and facing direction.

## Possible Inputs
- Grid Size: (10 x 10)
- Starting Position: (0, 0, N)
- Commands: ['M', 'M', 'R', 'M', 'L', 'M']
- Obstacles: [(2, 2), (3, 5)]

## Possible Outputs
- Final Position: (1, 3, E)
- Status Report: "Rover is at (1, 3) facing East. No Obstacles detected."

## Principles Followed
1. Encapsulation 
2. Inheritance
3. Polymorphism
4. Abstraction
5. Exception Handling
6. Logging
7. Single Responsibility Principle(SRP)
8. Open-Closed Principle (OCP)
9. Liskov Substituition Principle (LSP)
10. Interface Segregation Principle (ISP)
11. Dependency Inversion Principle (DIP)