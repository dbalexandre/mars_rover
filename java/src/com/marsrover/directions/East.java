package com.marsrover.directions;


public class East implements IDirection {

	@Override
	public int[] moveForward(int x, int y) {
		return new int[] { x + 1, y };
	}
	
	@Override
	public String turnLeft() {
		return "N";
	}

	@Override
	public String turnRight() {
		return "S";
	}

}
