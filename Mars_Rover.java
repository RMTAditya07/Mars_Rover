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
