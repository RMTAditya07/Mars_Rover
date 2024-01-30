//It is a contract that classes can choose to follow.
//Any class that claims to be Moveable must have a move method.
//The same applies to all other interfaces.
interface Movable {
    void move() throws BoundaryViolationException;
}