import java.util.List;

public class JumpingRover extends BasicRover {
    public JumpingRover(Grid grid, List<Obstacle> obstacles, Logger logger, Coordinate startingPosition, String startingDirection) {
        super(grid, obstacles, logger, startingPosition, startingDirection);
    }

    @Override
    public void move() throws BoundaryViolationException {
        int x = position.getX();
        int y = position.getY();

        // Calculate the new coordinates based on the direction
        switch (direction) {
            case "North":
                y++;
                break;
            case "South":
                y--;
                break;
            case "East":
                x++;
                break;
            case "West":
                x--;
                break;
        }

        // Check for obstacles
        if (isObstacleAt(x, y)) {
            // If obstacle detected, jump over it based on the direction
            logger.log("Obstacle detected at (" + x + "," + y + "). Jumping over the obstacle.");

            switch (direction) {
                case "North":
                    y++;
                    break;
                case "South":
                    y--;
                    break;
                case "East":
                    x++;
                    break;
                case "West":
                    x--;
                    break;
            }
        }

        // Check boundaries
        if (x < 0 || x >= grid.getWidth() || y < 0 || y >= grid.getHeight()) {
            throw new BoundaryViolationException("Reached boundary.");
        }

        // Update position
        position = new Coordinate(x, y);
    }
}
 

// class JumpingRover extends BasicRover {
//     public JumpingRover(Grid grid, List<Obstacle> obstacles, Logger logger, Coordinate startingPosition, String startingDirection) {
//         super(grid, obstacles, logger, startingPosition, startingDirection);
//     }

//     @Override
//     public void move() throws BoundaryViolationException {
//         // Intentional violation of LSP - changing the behavior of the superclass
//         logger.log("Jumping Rover is jumping without checking for obstacles!");
//         super.move(); // Call the move method of the superclass
//     }
// }