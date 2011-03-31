package com.marsrover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotGrammarParserTest {

	RobotGrammarParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new RobotGrammarParser();
	}

	@Test
	public void testMakeBoard() {
		Board board = parser.makeBoard("10 10");
		assertEquals(10, board.getX());
		assertEquals(10, board.getY());
	}

	@Test
	public void testMakeRobot() {
		Robot robot = parser.makeRobot("2 5 N");
		assertEquals(2, robot.getX());
		assertEquals(5, robot.getY());
		assertEquals("N", robot.getDirection());
	}

}
