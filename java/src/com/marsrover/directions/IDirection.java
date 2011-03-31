package com.marsrover.directions;

public interface IDirection {

	public int[] moveForward(int x, int y);
	
	public String turnLeft();
	
	public String turnRight();
}
