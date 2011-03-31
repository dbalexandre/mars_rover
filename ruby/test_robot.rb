require 'test/unit'
require_relative 'robot'

class TestRobot < Test::Unit::TestCase

  def test_new_board
    board = Board.new(10, 10)
    assert_equal(10, board.x)
    assert_equal(10, board.y)
  end

  def test_is_valid_move
    board = Board.new(10, 10)
    assert(board.is_valid_move?(4, 5))
  end

  def test_is_not_valid_move
    board = Board.new(10, 10)
    refute(board.is_valid_move?(6, 13))
  end

  def test_new_robot
    robot = Robot.new(2, 5, "N")
    assert_equal(2, robot.x)
    assert_equal(5, robot.y)
    assert_equal("N", robot.direction)
  end

  def test_turn_robot_left_90_degrees_from_north
    robot = Robot.new(2, 5, "N")
    robot.turn_to("L")
    assert_equal("W", robot.direction)
  end

  def test_turn_robot_right_90_degrees_from_north
    robot = Robot.new(2, 5, "N")
    robot.turn_to("R")
    assert_equal("E", robot.direction)
  end

  def test_turn_robot_left_90_degrees_from_east
    robot = Robot.new(2, 5, "E")
    robot.turn_to("L")
    assert_equal("N", robot.direction)
  end

  def test_turn_robot_right_90_degrees_from_east
    robot = Robot.new(2, 5, "E")
    robot.turn_to("R")
    assert_equal("S", robot.direction)
  end

  def test_turn_robot_left_90_degrees_from_south
    robot = Robot.new(2, 5, "S")
    robot.turn_to("L")
    assert_equal("E", robot.direction)
  end

  def test_turn_robot_right_90_degrees_from_south
    robot = Robot.new(2, 5, "S")
    robot.turn_to("R")
    assert_equal("W", robot.direction)
  end

  def test_turn_robot_left_90_degrees_from_west
    robot = Robot.new(2, 5, "W")
    robot.turn_to("L")
    assert_equal("S", robot.direction)
  end

  def test_turn_robot_right_90_degrees_from_west
    robot = Robot.new(2, 5, "W")
    robot.turn_to("R")
    assert_equal("N", robot.direction)
  end

  def test_move_robot_to_another_point
    board = Board.new(10, 10)
    robot = Robot.new(2, 5, "N")
    board.move_to(robot, 4, 7)
    assert_equal(4, robot.x)
    assert_equal(7, robot.y)
  end

  def test_move_robot_from_north
    board = Board.new(10, 10)
    robot = Robot.new(2, 5, "N")
    board.move(robot)
    assert_equal(2, robot.x)
    assert_equal(6, robot.y)
  end

  def test_move_robot_from_east
    board = Board.new(10, 10)
    robot = Robot.new(2, 5, "E")
    board.move(robot)
    assert_equal(3, robot.x)
    assert_equal(5, robot.y)
  end

  def test_move_robot_from_south
    board = Board.new(10, 10)
    robot = Robot.new(2, 5, "S")
    board.move(robot)
    assert_equal(2, robot.x)
    assert_equal(4, robot.y)
  end

  def test_move_robot_from_west
    board = Board.new(10, 10)
    robot = Robot.new(2, 5, "W")
    board.move(robot)
    assert_equal(1, robot.x)
    assert_equal(5, robot.y)
  end

  def test_invalid_robot_movement
    board = Board.new(10, 10)
    robot = Robot.new(10, 10, "N")
    board.move(robot)
    assert_equal(10, robot.x)
    assert_equal(10, robot.y)
  end

  def test_make_board
    parser = RobotGrammarParser.new
    board = parser.make_board("10 10")
    assert_equal(10, board.x)
    assert_equal(10, board.y)
  end

  def test_make_robot
    parser = RobotGrammarParser.new
    robot = parser.make_robot("2 5 N")
    assert_equal(2, robot.x)
    assert_equal(5, robot.y)
    assert_equal("N", robot.direction)
  end

  def test_parser
    parser = RobotGrammarParser.new
    final_position = parser.parse('robot_movements.txt')
    assert_equal("2 1 W", final_position)
  end

end
