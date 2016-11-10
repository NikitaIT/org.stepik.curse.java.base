import java.math.*;
import java.util.Arrays;

public class RobotWorld {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, 3, -1);
        System.out.print(robot.getX()+" ");
        System.out.println(robot.getY());
        moveRobot(robot, 2, 1);
        System.out.print(robot.getX()+" ");
        System.out.println(robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int i;
        switch (robot.getDirection()) {
            case DOWN:{robot.turnRight();robot.turnRight();}
                break;
            case RIGHT: robot.turnLeft();
                break;
            case LEFT: robot.turnRight();
                break;
        }
        int mtoX,mtoY;
        if (toX>robot.getX()){
            mtoX=Math.abs(toX-robot.getX());
        }else{
            mtoX=Math.abs(robot.getX()-toX);
        }
        if (toY>robot.getY()){
            mtoY=Math.abs(toY-robot.getY());
        }else{
            mtoY=Math.abs(robot.getY()-toY);
        }
        if  (toX>=robot.getX()){
            if  (toY>=robot.getY()){
                //+x +y
                for (i=0;i<mtoY;i++)robot.stepForward();
                robot.turnRight();
                for (i=0;i<mtoX;i++)robot.stepForward();
            }else{
                //+x -y
                robot.turnRight();
                for (i=0;i<mtoX;i++)robot.stepForward();
                robot.turnRight();
                for (i=0;i<mtoY;i++)robot.stepForward();
            }
        }else{
            if  (toY>robot.getY()){
                //-x +y
                for (i=0;i<mtoY;i++)robot.stepForward();
                robot.turnLeft();
                for (i=0;i<mtoX;i++)robot.stepForward();
            }else{
                //-x -y
                robot.turnLeft();
                for (i=0;i<mtoX;i++)robot.stepForward();
                robot.turnLeft();
                for (i=0;i<mtoY;i++)robot.stepForward();
            }
        }
    }
}
