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
