package com.marsrover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;
	private Robot robot;

	@Before
	public void setUp() throws Exception {
		board = new Board(10, 10);
		robot = new Robot(2, 5, "N");
	}

	@Test
	public void testNewBoard() {
		assertEquals(10, board.getX());
		assertEquals(10, board.getY());
	}

	@Test
	public void testIsValidMove() {
		assertEquals(true, board.isValidMove(4, 5));
	}

	@Test
	public void testIsNotValidMove() {
		assertEquals(false, board.isValidMove(6, 13));
	}

	@Test
	public void testMoveRobotToAnotherPoint() {
		board.moveTo(robot, 4, 7);
		assertEquals(4, robot.getX());
		assertEquals(7, robot.getY());
	}

	@Test
	public void testMoveRobotFromNorth() {
		board.move(robot);
		assertEquals(2, robot.getX());
		assertEquals(6, robot.getY());
	}

	@Test
	public void testMoveRobotFromEast() {
		robot.setDirection("E");
		board.move(robot);
		assertEquals(3, robot.getX());
		assertEquals(5, robot.getY());
	}

	@Test
	public void testMoveRobotFromSouth() {
		robot.setDirection("S");
		board.move(robot);
		assertEquals(2, robot.getX());
		assertEquals(4, robot.getY());
	}

	@Test
	public void testMoveRobotFromWest() {
		robot.setDirection("W");
		board.move(robot);
		assertEquals(1, robot.getX());
		assertEquals(5, robot.getY());
	}

	@Test
	public void testInvalidRobotMovement() {
		robot = new Robot(10, 10, "N");
		board.move(robot);
		assertEquals(10, robot.getX());
		assertEquals(10, robot.getY());
	}

}
