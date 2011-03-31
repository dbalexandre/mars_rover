package com.marsrover;

import com.marsrover.directions.Directions;
import com.marsrover.directions.IDirection;

public class Robot {

	private int x;
	private int y;
	private String direction;
	private Directions directions;
	
	public Robot(int x, int y, String direction) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.directions = new Directions();
	}
	
	public void turnTo(char side) {
		
		IDirection direction = this.directions.get(this.direction);
		this.direction = (side == 'L' ? direction.turnLeft() : direction.turnRight());
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return this.direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.direction;
	}
	
}
