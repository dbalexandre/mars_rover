package com.marsrover.directions;

import java.util.HashMap;
import java.util.Map;


public class Directions {
	
	private Map<String, IDirection> directions;
	
	public Directions() {
		
		this.directions = new HashMap<String, IDirection>();
		
		this.directions.put("N", new North());
		this.directions.put("E", new East());
		this.directions.put("S", new South());
		this.directions.put("W", new West());
	}
	
	public IDirection get(String direction) {
		return this.directions.get(direction);
	}
}
