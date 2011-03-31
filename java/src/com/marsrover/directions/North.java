package com.marsrover.directions;

public class North implements IDirection {

	@Override
	public int[] moveForward(int x, int y) {
		return new int[] { x, y + 1 };
	}
	
	@Override
	public String turnLeft() {
		return "W";
	}

	@Override
	public String turnRight() {
		return "E";
	}

}
