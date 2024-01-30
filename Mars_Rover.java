import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Main Class Mars_Rover
class Mars_Rover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grid size (width height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        Grid grid = new Grid(width,height); //Create a 10 x 10 grid
        System.out.println("Enter total number of obstacles: ");
        int totalObstacles = scanner.nextInt();
        List<Obstacle> obstacles = new ArrayList<>(); //List of obstacle coordinates.
        //Added obstacles coordinates
        for (int i = 0; i < totalObstacles; i++) {
            System.out.println("Enter obstacle coordinates (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            obstacles.add(new Obstacle(x, y));
        }
        Logger logger = new Logger();
        
        System.out.println("Enter starting position and direction (x y direction): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String direction = scanner.next();
        
        System.out.println("Choose rover type: 'B' for Basic Rover, 'J' for Jumping Rover");
        char roverType = scanner.next().charAt(0);

        AbstractRover rover;

        if (roverType == 'B') {
            rover = new BasicRover(grid, obstacles, logger, new Coordinate(x, y), direction);
        } else if (roverType == 'J') {
            rover = new JumpingRover(grid, obstacles, logger, new Coordinate(x, y), direction);
        } else {
            System.out.println("Invalid rover type. Exiting program.");
            return;
        }


        System.out.println("Welcome to Rover Control Program.");
        System.out.println("Commands: 'M' to move, 'L' to turn left, 'R' to turn right, 'C' to get current position, 'F' to get the Final position.'S' to get the Status Report. 'Q' to quit.");

        char command;
        boolean isFinalCommandReceived = false;
        //Try catch block is used. If error appears, the corresponding error message is printed.
        do {
            System.out.println("Enter command: ");
            command = scanner.next().charAt(0);

            if (command == 'F') {
                isFinalCommandReceived = true;
            } else if (command == 'S') {
                String statusReport = rover.generateStatusReport();
                logger.log("Status Report: " + statusReport);
            }
            else if (command != 'Q') {
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
                            logger.log("Invalid command. Use 'M' to move, 'L' to turn left, 'R' to turn right, 'C' to get current position,'F' to get final position,'S' to get status report. 'Q' to quit.");
                    }
                } catch (BoundaryViolationException e) {
                    logger.log("Error: " + e.getMessage());
                }
            }
        } while (!isFinalCommandReceived && command != 'Q');
        if (isFinalCommandReceived) {
            Coordinate currentPosition = rover.getCurrentPosition();
            String currentDirection = rover.getCurrentDirection();
            logger.log("Final position: (" + currentPosition.getX() + "," + currentPosition.getY() + "," + currentDirection + ")");
        }

        scanner.close();
    }
}
