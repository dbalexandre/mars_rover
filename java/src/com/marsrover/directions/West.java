package com.marsrover.directions;

public class West implements IDirection {

    @Override
    public int[] moveForward(int x, int y) {
        return new int[] { x - 1, y };
    }
    
    @Override
    public String turnLeft() {
        return "S";
    }

    @Override
    public String turnRight() {
        return "N";
    }

}
