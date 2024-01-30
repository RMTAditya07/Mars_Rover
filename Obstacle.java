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