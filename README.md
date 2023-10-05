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
1. Encapsulation :
  - It is the concept of bundlling data and methods that operate  on the data into a single unit called class.
2. Inheritance : 
  - It is a machanism in Java where one class can inherit the fields and methods from another class.
  - `BasicRover extends the AbstractRover i.e it inherits the behaviour defined in AbstractRover`
   
4. Polymorphism :
  - It allows the objects to be treated as instances of their super classse.
  - Interfaces are Movable, Turnable and Positionable.
  - Both AbstractRover and BasicRover implement these interfaces,  which allows them to be used interchangeably wherever these interfaces are expected.
6. Abstraction
  - It involves hiding the implementation details of an object and exposing only the relevent operations.
  - The interfaces provide a level of abstraction.
  - They define what an interface should do without specifying how it is done.
7. Exception Handling
  - Exceptions are handled when the rover tries to go beyond the boundary.
8. Logging
  -  Logger class is used to implement logging mechanism.
9. Single Responsibility Principle(SRP)
  - A class should have only one responsibility or job.
  -  For example, Coordinate handles coordinates, Grid manages the grid dimensions, Obstacle represents obstacles, and Logger handles logging.
10. Open-Closed Principle (OCP)
  -  This principle emphasizes that software entities (e.g., classes, modules, functions) should be open for extension but closed for modification.
  -  For example, if you wanted to create a new type of rover with additional features, you could do so by creating a new class that extends AbstractRover without having to modify the existing rover classes.
11. Liskov Substituition Principle (LSP)
  - This principle states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
  - BasicRover is a subclass of AbstractRover.
  - This relationship adheres to the Liskov Substitution Principle, as BasicRover can be used in place of AbstractRover without altering the correctness of the program. 
12. Interface Segregation Principle (ISP)
  - This principle suggests that it's better to have many small, specific interfaces rather than one large, general-purpose interface.
  - Specific interfaces like Movable, Turnable, and Positionable are relatively focused and specific.   
13. Dependency Inversion Principle (DIP)
  - This principle states that high-level modules should not depend on low-level modules, but both should depend on abstractions. 
  - The AbstractRover class takes Grid, List<Obstacle>, and Logger as parameters in its constructor, which allows for dependency injection. 
