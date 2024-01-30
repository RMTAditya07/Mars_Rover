//It provides a common structure for different types of rovers. 
//It implements the Movable, Turnable, and Positionable interfaces.
//It has attributes like position, direction, grid, obstacles, and logger.
//Any Rover have these characteristics
//Can create rover of desired type using this abstract rover. 

import java.util.List;

abstract class AbstractRover implements Movable, Turnable, Positionable {
    protected Coordinate position;
    protected String direction;
    protected Grid grid;
    protected List<Obstacle> obstacles;
    protected Logger logger;

    public AbstractRover(Grid grid, List<Obstacle> obstacles, Logger logger, Coordinate startingPosition, String startingDirection) {
        //initial state
        this.position = startingPosition;
        this.direction = startingDirection;
        this.grid = grid;
        this.obstacles = obstacles;
        this.logger = logger;
    }
    //implementation of the getCurrentPosition method required by Positionable interface
    protected boolean isObstacleAt(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getCoordinate().getX() == x && obstacle.getCoordinate().getY() == y) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Coordinate getCurrentPosition() {
        return position;
    }
    public String getCurrentDirection() {
        return direction;
    }
    public abstract String generateStatusReport();
}