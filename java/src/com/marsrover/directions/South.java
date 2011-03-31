package com.marsrover.directions;

public class South implements IDirection {

	@Override
	public int[] moveForward(int x, int y) {
		return new int[] { x, y - 1 };
	}
	
	@Override
	public String turnLeft() {
		return "E";
	}

	@Override
	public String turnRight() {
		return "W";
	}

}
