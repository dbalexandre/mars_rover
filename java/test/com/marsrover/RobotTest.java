package com.marsrover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = new Robot(2, 5, "N");
    }

    @Test
    public void testNewRobot() {
        assertEquals(2, robot.getX());
        assertEquals(5, robot.getY());
        assertEquals("N", robot.getDirection());
    }

    @Test
    public void testTurnRobotLeft90DegreesFromNorth() {
        robot.turnTo('L');
        assertEquals("W", robot.getDirection());
    }

    @Test
    public void testTurnRobotRight90DegreesFromNorth() {
        robot.turnTo('R');
        assertEquals("E", robot.getDirection());
    }

    @Test
    public void testTurnRobotLeft90DegreesFromEast() {
        robot.setDirection("E");
        robot.turnTo('L');
        assertEquals("N", robot.getDirection());
    }

    @Test
    public void testTurnRobotRight90DegreesFromEast() {
        robot.setDirection("E");
        robot.turnTo('R');
        assertEquals("S", robot.getDirection());
    }

    @Test
    public void testTurnRobotLeft90DegreesFromSouth() {
        robot.setDirection("S");
        robot.turnTo('L');
        assertEquals("E", robot.getDirection());
    }

    @Test
    public void testTurnRobotRight90DegreesFromSouth() {
        robot.setDirection("S");
        robot.turnTo('R');
        assertEquals("W", robot.getDirection());
    }

    @Test
    public void testTurnRobotLeft90DegreesFromWest() {
        robot.setDirection("W");
        robot.turnTo('L');
        assertEquals("S", robot.getDirection());
    }

    @Test
    public void testTurnRobotRight90DegreesFromWest() {
        robot.setDirection("W");
        robot.turnTo('R');
        assertEquals("N", robot.getDirection());
    }

}
