package com.marsrover;

import com.marsrover.directions.Directions;
import com.marsrover.directions.IDirection;


public class Board {

    private int x;
    private int y;
    private Directions directions;

    public Board(int x, int y) {

        this.x = x;
        this.y = y;
        this.directions = new Directions();
    }

    public boolean isValidMove(int x, int y) {

        return (x <= this.x && y <= this.y);
    }

    public Robot moveTo(Robot robot, int x, int y) {

        if (isValidMove(x, y)) {
            robot.setX(x);
            robot.setY(y);
        }

        return robot;
    }

    public Robot move(Robot robot) {

        IDirection direction = this.directions.get(robot.getDirection());
        int[] coordinates = direction.moveForward(robot.getX(), robot.getY());
        moveTo(robot, coordinates[0], coordinates[1]);

        return robot;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

}

