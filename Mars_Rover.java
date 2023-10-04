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
