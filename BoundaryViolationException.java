//Exception Handling when the rover tries to move beyond the boundary limit
class BoundaryViolationException extends Exception {
    public BoundaryViolationException(String message) {
        super(message);
    }
}
