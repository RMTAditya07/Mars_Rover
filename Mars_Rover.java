import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

//The class Grid represents the boundaries of the rectangle grid. It contains two piece of information [width and height]. They are private. Hence can be only accessed within the class.
//It has two methods [getWidth, getHeight] to find out the width and height
class Grid{
    private int width; 
    private int height;

    public Grid(int width,int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){ 
        return width;
    }
    public int getHeight(){
        return height;
    }
}

//Class Obstacle contains the coordinates of the obstacles in a grid. 
class Obstacle{
    private Coordinate coordinate;
    public Obstacle(int x,int y){
        this.coordinate = new Coordinate(x,y);
    }
    public Coordinate getCoordinate(){
        return coordinate;
    }
}

//This class is to print the Necessary Message 
class Logger {
    public void log(String message) {
        System.out.println(message);
    }
}

//Exception Handling when the rover tries to move beyond the boundary limit
class BoundaryViolationException extends Exception {
    public BoundaryViolationException(String message) {
        super(message);
    }
}


//It is a contract that classes can choose to follow.
//Any class that claims to be Moveable must have a move method.
//The same applies to all other interfaces.
interface Movable {
    void move() throws BoundaryViolationException;
}

interface Turnable {
    void turnLeft();
    void turnRight();
}

interface Positionable {
    Coordinate getCurrentPosition();
}

//It provides a common structure for different types of rovers. 
//It implements the Movable, Turnable, and Positionable interfaces.
//It has attributes like position, direction, grid, obstacles, and logger.
//Any Rover have these characteristics
//Can create rover of desired type using this abstract rover. 
abstract class AbstractRover implements Movable, Turnable, Positionable {
    protected Coordinate position;
    protected String direction;
    protected Grid grid;
    protected List<Obstacle> obstacles;
    protected Logger logger;

    public AbstractRover(Grid grid, List<Obstacle> obstacles, Logger logger) {
        //initial state
        this.position = new Coordinate(0, 0);
        this.direction = "North";
        this.grid = grid;
        this.obstacles = obstacles;
        this.logger = logger;
    }
    //implementation of the getCurrentPosition method required by Positionable interface
    @Override
    public Coordinate getCurrentPosition() {
        return position;
    }
}

//Class  BasicRover is a child class of AbstractRover class(Parent class)
//it provides  concrete implementation with specific movement and turning behaviour.
//BasicRover can build upon the general behaviour provided by AbstractRover
class BasicRover extends AbstractRover {
    public BasicRover(Grid grid, List<Obstacle> obstacles, Logger logger) {
        super(grid, obstacles, logger);
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
            logger.log("(" + x + "," + y + "," + direction+")");
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

        logger.log("Rover is at ("+position.getX()+","+position.getY() + ") facing " + direction);
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

        logger.log("Rover is at ("+position.getX()+","+position.getY() + ") facing " + direction);
    }
    //This method checks if the coordinates are one of the obstacle coordinates by comparing it with current coordinates
    private boolean isObstacleAt(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getCoordinate().getX() == x && obstacle.getCoordinate().getY() == y) {
                return true;
            }
        }
        return false;
    }
   
}
//Main Class Mars_Rover
class Mars_Rover {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10); //Create a 10 x 10 grid
        List<Obstacle> obstacles = new ArrayList<>(); //List of obstacle coordinates.
        //Added obstacles coordinates
        obstacles.add(new Obstacle(2, 2)); 
        obstacles.add(new Obstacle(3, 5));
        Logger logger = new Logger();
        //Created an object referencing BasicRover of type AbstractRover. 

        AbstractRover rover = new BasicRover(grid, obstacles, logger);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rover Control Program.");
        System.out.println("Commands: 'M' to move, 'L' to turn left, 'R' to turn right, 'C' to get current position, 'Q' to quit.");

        char command;
        //Try catch block is used. If error appears, the corresponding error message is printed.
        do {
            System.out.println("Enter command: ");
            command = scanner.next().charAt(0);

            if (command != 'Q') {
                try {
                    switch (command) {
                        case 'M':
                            rover.move();
                            break;
                        case 'L':
                            rover.turnLeft();
                            break;
                        case 'R':
                            rover.turnRight();
                            break;
                        case 'C':
                            Coordinate currentPosition = rover.getCurrentPosition();
                            logger.log("Current position: (" + currentPosition.getX() + "," + currentPosition.getY() + ")");
                            break;
                        default:
                            logger.log("Invalid command. Use 'M' to move, 'L' to turn left, 'R' to turn right, 'C' to get current position, 'Q' to quit.");
                    }
                } catch (BoundaryViolationException e) {
                    logger.log("Error: " + e.getMessage());
                }
            }
        } while (command != 'Q');
    }
}
