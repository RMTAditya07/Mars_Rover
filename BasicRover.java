//Class  BasicRover is a child class of AbstractRover class(Parent class)
//it provides  concrete implementation with specific movement and turning behaviour.
//BasicRover can build upon the general behaviour provided by AbstractRover

import java.util.List;

class BasicRover extends AbstractRover {
    public BasicRover(Grid grid, List<Obstacle> obstacles, Logger logger,Coordinate startingPosition, String startingDirection) {
        super(grid, obstacles, logger,startingPosition,startingDirection);
    }

    @Override    
    public String generateStatusReport() {
        String status = "Rover is at (" + position.getX() + ", " + position.getY() + ") facing " + direction + ". ";
        
        if (isObstacleAt(position.getX(), position.getY())) {
            status += "Obstacle detected.";
        } else {
            status += "No Obstacles detected.";
        }
        
        return status;
    }
    //implementation of movable interface's move() method
    @Override
    public void move() throws BoundaryViolationException {
        int x = position.getX();
        int y = position.getY();
        //direction is parent class variable
        //Based on the direction, the corresponding values of x and y are changed.
        //It may throw exception when the coordinates of not within the boundary
        switch (direction) {
            case "North":
                if (y < grid.getHeight() - 1) { //Checks if y is below grid's height
                    y++;
                } else {
                    throw new BoundaryViolationException("Reached North boundary.");
                }
                break;
            case "South":
                if (y > 0) { //checks if y is above the grid's floor
                    y--;
                } else {
                    throw new BoundaryViolationException("Reached South boundary.");
                }
                break;
            case "East":
                if (x < grid.getWidth() - 1) { //check if x is smaller than width
                    x++;
                } else {
                    throw new BoundaryViolationException("Reached East boundary.");
                }
                break;
            case "West":
                if (x > 0) { //check if x is inside the grid boundary
                    x--;
                } else {
                    throw new BoundaryViolationException("Reached West boundary.");
                }
                break;
        }
        //before updating the position of the rover, it is checked if the calculated new (x,y) is not equal to the obstacle coordinate
        //if true then the position is updated.
        if (!isObstacleAt(x, y)) {
            position = new Coordinate(x, y);
            // logger.log("(" + x + "," + y + "," + direction+")");
        } else {
            logger.log("Cannot move. Obstacle detected at (" + x + "," + y + ")");
        }
    }
    //implementation of Turnable interface's turnLeft method
    //based on the previous direction, it is updated accordingly.

    @Override
    public void turnLeft() {
        switch (direction) {
            case "North":
                direction = "West";
                break;
            case "South":
                direction = "East";
                break;
            case "East":
                direction = "North";
                break;
            case "West":
                direction = "South";
                break;
        }

        // logger.log("Rover is at ("+position.getX()+","+position.getY() + ") facing " + direction);
    }
    //implementation of Turnable interface's turnRight method
    //based on the previous direction, it is updated accordingly.
    @Override
    public void turnRight() {
        switch (direction) {
            case "North":
                direction = "East";
                break;
            case "South":
                direction = "West";
                break;
            case "East":
                direction = "South";
                break;
            case "West":
                direction = "North";
                break;
        }

        // logger.log("Rover is at ("+position.getX()+","+position.getY() + ") facing " + direction);
    }
    //This method checks if the coordinates are one of the obstacle coordinates by comparing it with current coordinates
    protected boolean isObstacleAt(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getCoordinate().getX() == x && obstacle.getCoordinate().getY() == y) {
                return true;
            }
        }
        return false;
    }
   
}